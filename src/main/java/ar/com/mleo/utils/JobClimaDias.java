package ar.com.mleo.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import ar.com.mleo.bean.Planeta;
import ar.com.mleo.bean.Punto;

public class JobClimaDias {
	private static final String FILE_JOB_DIAS_LLUVIA = "C:\\logs\\dias-lluvia.txt";
	private static final String FILE_JOB_DIAS_SEQUIA = "C:\\logs\\dias-sequia.txt";
	private static final String FILE_JOB_DIAS_IDEAL = "C:\\logs\\dias-ideal.txt";
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
		jobPeridoLLuvia();
		jobPeridoSequia();
		jobPeridoIdeal();
	}

	private static void jobPeridoLLuvia() {
		long dia = 1;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_JOB_DIAS_LLUVIA))) {

			while(dia <= ULTIMO_DIA){
				Punto fp = MatematicaUtils.getCoordeadasRectangular(ferengisPlaneta.getRadio(), ferengisPlaneta.getAngulo(), ferengisPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto bp = MatematicaUtils.getCoordeadasRectangular(betasoidesPlaneta.getRadio(), betasoidesPlaneta.getAngulo(), betasoidesPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vulcanosPlaneta.getRadio(), vulcanosPlaneta.getAngulo(), vulcanosPlaneta.getPeriodo(),  new BigDecimal(dia));

				double area = Triangulo.getArea(fp, bp, vp);
				if(area > 0){
					if(Triangulo.esPuntoInteriorTriangulo(fp, bp, vp, sol)){
						String insert = getInsert(dia, ClimaTipos.LLUVIA.getValorS());
						bw.write(insert+"\n");
					}
				}
				dia++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void jobPeridoSequia() {
		long dia = 1;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_JOB_DIAS_SEQUIA))) {

			while(dia <= ULTIMO_DIA){
				Punto fp = MatematicaUtils.getCoordeadasRectangular(ferengisPlaneta.getRadio(), ferengisPlaneta.getAngulo(), ferengisPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto bp = MatematicaUtils.getCoordeadasRectangular(betasoidesPlaneta.getRadio(), betasoidesPlaneta.getAngulo(), betasoidesPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vulcanosPlaneta.getRadio(), vulcanosPlaneta.getAngulo(), vulcanosPlaneta.getPeriodo(),  new BigDecimal(dia));

				double area = Triangulo.getArea(fp, bp, vp);
				if(-1<area && area<1){

					FuncionCuadratica recta = new FuncionCuadratica(fp, bp);

					BigDecimal yaux = recta.getValorY(sol.getX());
					if(MatematicaUtils.esSemejante(yaux, bp.getY(), 0.5)){
						String insert = getInsert(dia, ClimaTipos.SEQUIA.getValorS());
						bw.write(insert+"\n");
					}
				}
				dia++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void jobPeridoIdeal() {
		long dia = 1;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_JOB_DIAS_IDEAL))) {

			while(dia <= ULTIMO_DIA){
				Punto fp = MatematicaUtils.getCoordeadasRectangular(ferengisPlaneta.getRadio(), ferengisPlaneta.getAngulo(), ferengisPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto bp = MatematicaUtils.getCoordeadasRectangular(betasoidesPlaneta.getRadio(), betasoidesPlaneta.getAngulo(), betasoidesPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vulcanosPlaneta.getRadio(), vulcanosPlaneta.getAngulo(), vulcanosPlaneta.getPeriodo(),  new BigDecimal(dia));

				double area = Triangulo.getArea(fp, bp, vp);
				if(-1<area && area<1){

					FuncionCuadratica recta = new FuncionCuadratica(fp, bp);

					BigDecimal yaux = recta.getValorY(sol.getX());
					if(!MatematicaUtils.esSemejante(yaux, bp.getY(), 0.5)){
						String insert = getInsert(dia, ClimaTipos.IDEAL.getValorS());
						bw.write(insert+"\n");
					}
				}
				dia++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getInsert(long dia, String clima) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO public.clima(dia, nombre) ").append("VALUES (").append(dia).append(", '").append(clima).append("');");
		return stringBuilder.toString();
	}

}
