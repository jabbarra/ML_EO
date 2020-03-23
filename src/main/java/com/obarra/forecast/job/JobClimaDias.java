package com.obarra.forecast.job;

import com.obarra.forecast.bean.Planeta;
import com.obarra.forecast.bean.Punto;
import com.obarra.forecast.utils.FuncionCuadratica;
import com.obarra.forecast.utils.MatematicaUtil;
import com.obarra.forecast.utils.TrianguloUtil;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.obarra.forecast.enums.ClimaTipos.IDEAL_I;
import static com.obarra.forecast.enums.ClimaTipos.LLUVIA_I;
import static com.obarra.forecast.enums.ClimaTipos.SEQUIA_I;
import static com.obarra.forecast.enums.FileJobEnum.FILE_JOB_DIAS_IDEAL;
import static com.obarra.forecast.enums.FileJobEnum.FILE_JOB_DIAS_LLUVIA;
import static com.obarra.forecast.enums.FileJobEnum.FILE_JOB_DIAS_SEQUIA;

@Log4j2
public final class JobClimaDias {

    private static final String INSERT_DIAS_COMPLETE = "INSERT INTO public.dias(numero"
            + ", id_climas"
            + ", intensidad_lluvia)"
            + " VALUES (%d, %d, %f);";

    private static final String INSERT_DIAS = "INSERT INTO public.dias(numero"
            + ", id_climas) "
            + "VALUES (%d, %d);";

    private static final long ULTIMO_DIA = 365 * 10;
    private static Planeta ferengisPlaneta;
    private static Planeta betasoidesPlaneta;
    private static Planeta vulcanosPlaneta;
    private static Punto sol;

    static {
        ferengisPlaneta = new Planeta("ferengis", "1", "1", "500");
        betasoidesPlaneta = new Planeta("betasoides", "3", "1", "2000");
        vulcanosPlaneta = new Planeta("vulcanos", "5", "1", "1000");
        sol = new Punto();
        sol.setAxisX(BigDecimal.ZERO);
        sol.setAxisY(BigDecimal.ZERO);
    }

    private JobClimaDias() {
    }

    public static void main(final String[] args) {
        jobPeridoLLuvia();
        jobPeridoSequia();
        jobPeridoIdeal();

        log.info("Se generaron exitosamente las condiciones de todos los días. Favor de revisar los archivos:");
        log.info(FILE_JOB_DIAS_LLUVIA);
        log.info(FILE_JOB_DIAS_SEQUIA);
        log.info(FILE_JOB_DIAS_IDEAL);
    }

    private static void jobPeridoLLuvia() {
        long dia = 1;
        double perimetro = 0;
        try (BufferedWriter bw =
                     Files.newBufferedWriter(Paths.get(FILE_JOB_DIAS_LLUVIA.getValue()),
                             StandardCharsets.UTF_8)) {

            while (dia <= ULTIMO_DIA) {
                Punto fp = MatematicaUtil
                        .getCoordeadasRectangular(ferengisPlaneta.getRadio(),
                                ferengisPlaneta.getAngulo(),
                                ferengisPlaneta.getPeriodo(),
                                new BigDecimal(dia));
                Punto bp = MatematicaUtil
                        .getCoordeadasRectangular(betasoidesPlaneta.getRadio(),
                                betasoidesPlaneta.getAngulo(),
                                betasoidesPlaneta.getPeriodo(),
                                new BigDecimal(dia));
                Punto vp = MatematicaUtil
                        .getCoordeadasRectangularAntihorario(
                                vulcanosPlaneta.getRadio(),
                                vulcanosPlaneta.getAngulo(),
                                vulcanosPlaneta.getPeriodo(),
                                new BigDecimal(dia));

                double area = TrianguloUtil.getArea(fp, bp, vp);

                if (area > 0 && TrianguloUtil.esPuntoInteriorTriangulo(fp, bp, vp, sol)) {
                    perimetro = TrianguloUtil.getPerimetro(fp, bp, vp);
                    String insert = getStringInsertDias(dia,
                            LLUVIA_I.getValorI(),
                            perimetro);
                    bw.write(insert + "\n");
                }

                dia++;
            }
        } catch (IOException e) {
            log.error(e);
        }
    }


    private static void jobPeridoSequia() {
        long dia = 1;

        try (BufferedWriter bw =
                     Files.newBufferedWriter(Paths.get(FILE_JOB_DIAS_SEQUIA.getValue()),
                             StandardCharsets.UTF_8)) {

            while (dia <= ULTIMO_DIA) {
                Punto fp = MatematicaUtil.getCoordeadasRectangular(ferengisPlaneta.getRadio(), ferengisPlaneta.getAngulo(), ferengisPlaneta.getPeriodo(), new BigDecimal(dia));
                Punto bp = MatematicaUtil.getCoordeadasRectangular(betasoidesPlaneta.getRadio(), betasoidesPlaneta.getAngulo(), betasoidesPlaneta.getPeriodo(), new BigDecimal(dia));
                Punto vp = MatematicaUtil.getCoordeadasRectangularAntihorario(vulcanosPlaneta.getRadio(), vulcanosPlaneta.getAngulo(), vulcanosPlaneta.getPeriodo(), new BigDecimal(dia));

                double area = TrianguloUtil.getArea(fp, bp, vp);
                if (-1 < area && area < 1) {

                    FuncionCuadratica recta = new FuncionCuadratica(fp, bp);

                    BigDecimal yaux = recta.getValorY(sol.getAxisX());
                    if (MatematicaUtil.esSemejante(yaux, bp.getAxisY(), 0.5)) {
                        String insert = getStringInsertDias(dia, SEQUIA_I.getValorI());
                        bw.write(insert + "\n");
                    }
                }
                dia++;
            }

        } catch (IOException e) {
            log.error(e);
        }
    }

    private static void jobPeridoIdeal() {
        long dia = 1;
        try (BufferedWriter bw =
                     Files.newBufferedWriter(Paths.get(FILE_JOB_DIAS_IDEAL.getValue()),
                             StandardCharsets.UTF_8)) {
            while (dia <= ULTIMO_DIA) {
                Punto fp = MatematicaUtil.getCoordeadasRectangular(ferengisPlaneta.getRadio(), ferengisPlaneta.getAngulo(), ferengisPlaneta.getPeriodo(), new BigDecimal(dia));
                Punto bp = MatematicaUtil.getCoordeadasRectangular(betasoidesPlaneta.getRadio(), betasoidesPlaneta.getAngulo(), betasoidesPlaneta.getPeriodo(), new BigDecimal(dia));
                Punto vp = MatematicaUtil.getCoordeadasRectangularAntihorario(vulcanosPlaneta.getRadio(), vulcanosPlaneta.getAngulo(), vulcanosPlaneta.getPeriodo(), new BigDecimal(dia));

                double area = TrianguloUtil.getArea(fp, bp, vp);
                if (-1 < area && area < 1) {

                    FuncionCuadratica recta = new FuncionCuadratica(fp, bp);

                    BigDecimal yaux = recta.getValorY(sol.getAxisX());
                    if (!MatematicaUtil.esSemejante(yaux, bp.getAxisY(), 0.5)) {
                        String insert = getStringInsertDias(dia, IDEAL_I.getValorI());
                        bw.write(insert + "\n");
                    }
                }
                dia++;
            }

        } catch (IOException e) {
            log.error(e);
        }
    }

    private static String getStringInsertDias(final long dia,
                                              final int clima) {
        return String.format(INSERT_DIAS, dia, clima);
    }

    private static String getStringInsertDias(final long dia,
                                              final int clima,
                                              final double perimetro) {
        return String.format(INSERT_DIAS_COMPLETE, dia, clima, perimetro);
    }
}
