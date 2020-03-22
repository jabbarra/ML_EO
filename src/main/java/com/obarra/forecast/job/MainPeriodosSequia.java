package com.obarra.forecast.job;

import com.obarra.forecast.bean.Planeta;
import com.obarra.forecast.bean.Punto;
import com.obarra.forecast.utils.ClimaTipos;
import com.obarra.forecast.utils.FuncionCuadratica;
import com.obarra.forecast.utils.MatematicaUtils;
import com.obarra.forecast.utils.Triangulo;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

@Log4j2
public class MainPeriodosSequia {
    private static final String FILE_INFORME_PERIODO_SEQUIA = "/archivos_mleo/informe-periodos-sequia.txt";
    private static final long ULTIMO_DIA = 365 * 10;
    private static Planeta ferengisPlaneta = null;
    private static Planeta betasoidesPlaneta = null;
    private static Planeta vulcanosPlaneta = null;
    private static Punto sol = null;

    static {
        ferengisPlaneta = new Planeta("ferengis", "1", "1", "500");
        betasoidesPlaneta = new Planeta("betasoides", "3", "1", "2000");
        vulcanosPlaneta = new Planeta("vulcanos", "5", "1", "1000");
        sol = new Punto();
        sol.setX(new BigDecimal(0));
        sol.setY(new BigDecimal(0));
    }

    public static void main(String[] args) {
        generarInformePeriodosSequia();
    }

    private static void generarInformePeriodosSequia() {
        long dia = 1;
        long diaAnterior = -1;
        long contadorPeriodos = 0;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_INFORME_PERIODO_SEQUIA))) {

            while (dia <= ULTIMO_DIA) {
                Punto fp = MatematicaUtils.getCoordeadasRectangular(ferengisPlaneta.getRadio(), ferengisPlaneta.getAngulo(), ferengisPlaneta.getPeriodo(), new BigDecimal(dia));
                Punto bp = MatematicaUtils.getCoordeadasRectangular(betasoidesPlaneta.getRadio(), betasoidesPlaneta.getAngulo(), betasoidesPlaneta.getPeriodo(), new BigDecimal(dia));
                Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vulcanosPlaneta.getRadio(), vulcanosPlaneta.getAngulo(), vulcanosPlaneta.getPeriodo(), new BigDecimal(dia));

                double area = Triangulo.getArea(fp, bp, vp);
                if (-1 < area && area < 1) {
                    FuncionCuadratica recta = new FuncionCuadratica(fp, bp);
                    BigDecimal yaux = recta.getValorY(sol.getX());
                    if (MatematicaUtils.esSemejante(yaux, bp.getY(), 0.5)) {

                        if (diaAnterior == -1 || (diaAnterior + 1) != dia) {
                            contadorPeriodos++;
                            bw.write("PERIODO NUMERO: " + contadorPeriodos + "\n");
                            bw.write("Día: " + dia + " ");
                            bw.write(ClimaTipos.SEQUIA.getValorS() + "\n");
                        } else {
                            bw.write("Día: " + dia + " ");
                            bw.write(ClimaTipos.SEQUIA.getValorS() + "\n");
                        }
                        diaAnterior = dia;
                    }
                }
                dia++;

            }

        } catch (IOException e) {
            log.error(e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Habrá ")
                .append(contadorPeriodos)
                .append(" períodos de sequía. Para ver el detalle favor de revisar el archivo:")
                .append(FILE_INFORME_PERIODO_SEQUIA);

        log.info(stringBuilder.toString());
    }

}
