package ar.com.mleo.job;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import ar.com.mleo.bean.Planeta;
import ar.com.mleo.bean.Punto;
import ar.com.mleo.utils.ClimaTipos;
import ar.com.mleo.utils.MatematicaUtils;

public class MainPeriodosLLuvia {
	private static final String FILE_INFORME_PERIODO_LLUVIA = "/logs/informe-periodos-lluvia.txt";
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
		generarInformePeriodosLluvia();
	}
	
	private static void generarInformePeriodosLluvia() {
		long dia = 1;
		long diaAnterior = -1;
		long contadorPeriodos = 0;
		double perimetro = 0;
		double perimetroMax = 0;
		long diaperimetroMax = 0;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_INFORME_PERIODO_LLUVIA))) {
			
			while(dia <= ULTIMO_DIA){
				Punto fp = MatematicaUtils.getCoordeadasRectangular(ferengisPlaneta.getRadio(), ferengisPlaneta.getAngulo(), ferengisPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto bp = MatematicaUtils.getCoordeadasRectangular(betasoidesPlaneta.getRadio(), betasoidesPlaneta.getAngulo(), betasoidesPlaneta.getPeriodo(), new BigDecimal(dia));
				Punto vp = MatematicaUtils.getCoordeadasRectangularAntihorario(vulcanosPlaneta.getRadio(), vulcanosPlaneta.getAngulo(), vulcanosPlaneta.getPeriodo(),  new BigDecimal(dia));
				
				double area = MatematicaUtils.getArea(fp, bp, vp);
				if(area > 0){
					if(MatematicaUtils.esPuntoInteriorTriangulo(fp, bp, vp, sol)){
				
						if(diaAnterior ==  -1 || (diaAnterior+1) != dia){
							contadorPeriodos++;
							bw.write("PERIODO NUMERO: "+contadorPeriodos+"\n");
							bw.write("Día: "+ dia + " ");
							bw.write(ClimaTipos.LLUVIA.getValorS()+"\n");
						}else{
							bw.write("Día: "+ dia+ " ");
							bw.write(ClimaTipos.LLUVIA.getValorS()+"\n");
						}
						diaAnterior = dia;
						perimetro = MatematicaUtils.getPerimetro(fp, bp, vp);
						if(dia == 1 ||  perimetroMax < perimetro){
							perimetroMax = perimetro;
							diaperimetroMax = dia;
						}
					}
				}
				
				dia++;
			}
			
			bw.write("El pico máximo de lluvia será el día: "+ diaperimetroMax);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Habrá "+contadorPeriodos+" períodos de lluvia. Para ver el detalle favor de revisar el archivo: "+ FILE_INFORME_PERIODO_LLUVIA);
		System.out.println("El pico máximo de lluvia será el día: "+ diaperimetroMax);
	}
	
}
