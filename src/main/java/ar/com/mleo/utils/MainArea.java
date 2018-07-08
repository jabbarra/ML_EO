package ar.com.mleo.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import ar.com.mleo.bean.FuncionCuadratica;
import ar.com.mleo.bean.Punto;

public class MainArea {
	public static void main(String[] args) {
		obtenerAreaMaxima();
	}
	private static void test() {
//		Punto a =  new Punto();
//		a.setX(new BigDecimal("-4"));
//		a.setY(new BigDecimal("-4"));
//		
//		Punto b = new Punto();
//		b.setX(new BigDecimal("0"));
//		b.setY(new BigDecimal("4"));
//		
//		Punto c = new Punto();
//		c.setX(new BigDecimal("4"));
//		c.setY(new BigDecimal("-4"));
		
		Punto a =  new Punto();
		a.setX(new BigDecimal("-2"));
		a.setY(new BigDecimal("3"));
		
		Punto b = new Punto();
		b.setX(new BigDecimal("3"));
		b.setY(new BigDecimal("-1"));
		
		Punto c = new Punto();
		c.setX(new BigDecimal("5"));
		c.setY(new BigDecimal("6"));
		
		
		
		System.out.println(MatematicaUtils.getArea(a, b, c));
	}
	private static void obtenerAreaMaxima() {

		long dia = 1;
		long ultimoDia = 365 * 10;
		
		
		BigDecimal fRadio = new BigDecimal("500"); 
//		BigDecimal fAngulo = new BigDecimal("1"); 
		Double anguloRad = Math.toRadians(1);
		BigDecimal fAngulo = new BigDecimal(anguloRad.toString());
		BigDecimal fPeriodo = new BigDecimal("1");
		
		BigDecimal bRadio = new BigDecimal("2000"); 
//		BigDecimal bAngulo = new BigDecimal("3"); 
		anguloRad = Math.toRadians(3);
		BigDecimal bAngulo = new BigDecimal(anguloRad.toString());
		BigDecimal bPeriodo = new BigDecimal("1");
		
		BigDecimal vRadio = new BigDecimal("1000"); 
//		BigDecimal vAngulo = new BigDecimal("5"); 
		anguloRad = Math.toRadians(5);
		BigDecimal vAngulo = new BigDecimal(anguloRad.toString());
		BigDecimal vPeriodo = new BigDecimal("1");
		
		
		
		
		
		
		Punto p0 = new Punto();
		p0.setX(new BigDecimal(0));
		p0.setY(new BigDecimal(0));
		 
		String FILENAME = "C:\\logs\\filename.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
			
			while(dia <= ultimoDia){
				
				
				Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
				Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
				Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));
				
				
				
				FuncionCuadratica recta = new FuncionCuadratica(fp, bp);
				
				BigDecimal yaux = recta.getValorY(vp.getX());
				if(!esSemejante(yaux, bp, 0.5)){
					bw.write("DIA: "+ dia);
					bw.write(" AREA: "+ MatematicaUtils.getArea(fp, bp, vp));
					bw.write(" F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
					bw.write(" B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
					bw.write(" V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
				}else{
					System.out.println("DIA: "+ dia);
					System.out.println("AREA: "+ MatematicaUtils.getArea(fp, bp, vp));
					System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
					System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
					System.out.println("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
				}
				dia++;
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		
		

		
	}
	
	private static boolean esSemejante(BigDecimal yaux, Punto p0, double desvio) {
		double ymin = yaux.doubleValue() - desvio;
		double ymax = yaux.doubleValue() + desvio;
		if(ymin < p0.getY().doubleValue() && p0.getY().doubleValue() < ymax){
			return true;
		}
		return false;
	}
}
