package ar.com.mleo.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import ar.com.mleo.bean.FuncionCuadratica;
import ar.com.mleo.bean.Punto;

public class MainTestIgual {
	
	public static void main(String[] args) {
//		test();
//		obtenerClimaSequia();
		getArea();
//		testPuntos();
	}
	
	private static void obtenerClimaSequia() {

		long dia = 1;
		long ultimoDia = 365 * 10;
		
		
		BigDecimal fRadio = new BigDecimal("500"); 
		BigDecimal fAngulo = new BigDecimal("1"); 
		BigDecimal fPeriodo = new BigDecimal("1");
		
		BigDecimal bRadio = new BigDecimal("2000"); 
		BigDecimal bAngulo = new BigDecimal("3"); 
		BigDecimal bPeriodo = new BigDecimal("1");
		
		BigDecimal vRadio = new BigDecimal("1000"); 
		BigDecimal vAngulo = new BigDecimal("5"); 
		BigDecimal vPeriodo = new BigDecimal("1");
		
		Double anguloRad = Math.toRadians(1);
		fAngulo = new BigDecimal(anguloRad.toString());
		anguloRad = Math.toRadians(3);
		bAngulo = new BigDecimal(anguloRad.toString());
		anguloRad = Math.toRadians(5);
		vAngulo = new BigDecimal(anguloRad.toString());
		
		Punto p0 = new Punto();
		p0.setX(new BigDecimal(0));
		p0.setY(new BigDecimal(0));
		 
		
		
		
		while(dia <= ultimoDia){
			
			
			Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
			Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
			Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));
			
			if(MatematicaUtils.estanAlineados(fp, bp, vp)){
				System.out.println("fp eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
				System.out.println("bp eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
				System.out.println("vp eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				if(MatematicaUtils.estanAlineados(fp, bp, p0)){
//					System.out.println("fp eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					System.out.println("bp eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					System.out.println("vp eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}else{
//					System.out.println("-fp eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					System.out.println("-bp eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					System.out.println("-vp eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
			}
			
			dia++;
		}
		
	}

	private static void testPuntos() {
		Punto p1 = new Punto();
		p1.setX(new BigDecimal("129.40952255126037000"));
		p1.setY(new BigDecimal("482.9629131445341500"));
		
		Punto p2 = new Punto();
		p2.setX(new BigDecimal("-1414.2135623730958000"));
		p2.setY(new BigDecimal("-1414.2135623730942000"));
		
		Punto p3 =  new Punto();
		p3.setX(new BigDecimal("965.9258262890684000"));
		p3.setY(new BigDecimal("258.81904510252024000"));
		
		if(MatematicaUtils.estanAlineados(p1, p2, p3)){
			System.out.println("dsdfsd");
		}
		
	}
	private static void getArea() {

		long dia = 1;
		long ultimoDia = 365 * 10;
		
		
		BigDecimal fRadio = new BigDecimal("500"); 
		BigDecimal fAngulo = new BigDecimal("1"); 
		BigDecimal fPeriodo = new BigDecimal("1");
		
		BigDecimal bRadio = new BigDecimal("2000"); 
		BigDecimal bAngulo = new BigDecimal("3"); 
		BigDecimal bPeriodo = new BigDecimal("1");
		
		BigDecimal vRadio = new BigDecimal("1000"); 
		BigDecimal vAngulo = new BigDecimal("5"); 
		BigDecimal vPeriodo = new BigDecimal("1");
		
		Double anguloRad = Math.toRadians(1);
		fAngulo = new BigDecimal(anguloRad.toString());
		anguloRad = Math.toRadians(3);
		bAngulo = new BigDecimal(anguloRad.toString());
		anguloRad = Math.toRadians(5);
		vAngulo = new BigDecimal(anguloRad.toString());
		
		Punto p0 = new Punto();
		p0.setX(new BigDecimal(0));
		p0.setY(new BigDecimal(0));
		 
		
		String FILENAME = "C:\\logs\\areas.txt";
		int contador = 0;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
			
			while(dia <= ultimoDia){
				Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
				Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
				Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));
				
				
				double area = MatematicaUtils.getArea(fp, bp, vp);
				bw.write("DIA: "+ dia);
				if(MatematicaUtils.esPuntoInteriorTriangulo(fp, bp, vp, p0)){
					bw.write(" SOL_adentro ");
				}else{
					bw.write(" SOL_afuera ");
				}
				bw.write(" AREA: "+ area);
				bw.write(" Feje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
				bw.write(" Beje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
				bw.write(" Veje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
				if(-1<area && area<1){
					System.out.println("DIA: "+ dia);
					if(MatematicaUtils.esPuntoInteriorTriangulo(fp, bp, vp, p0)){
						System.out.println(" SOL_adentro ");
					}else{
						System.out.println(" SOL_afuera ");
					}
					System.out.println("AREA: "+ area);
					System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
					System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
					System.out.println("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
					contador++;
				}
				
				
//				if(MatematicaUtils.estanAlineados(fp, bp, vp)){
//					bw.write("DIA: "+ dia);
//					bw.write(" AREA: "+ MatematicaUtils.getArea(fp, bp, vp));
//					bw.write(" Feje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					bw.write(" Beje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					bw.write(" Veje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
//				else{
//					System.out.println("DIA: "+ dia);
//					System.out.println("AREA: "+ MatematicaUtils.getArea(fp, bp, vp));
//					System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					System.out.println("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
				dia++;
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		System.out.println("con: "+ contador);
		
	}
	
	private static void test() {
		
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("5"));
//		p1.setY(new BigDecimal("6"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("2"));
//		p2.setY(new BigDecimal("3"));
//		
//		Punto p3 =  new Punto();
//		p3.setX(new BigDecimal("-2"));
//		p3.setY(new BigDecimal("-1"));
		
		
		
		
		
//		Punto a =  new Punto();
//		a.setX(new BigDecimal("-2"));
//		a.setY(new BigDecimal("-1"));
//		
//		Punto b = new Punto();
//		b.setX(new BigDecimal("2"));
//		b.setY(new BigDecimal("3"));
//		
//		Punto c = new Punto();
//		c.setX(new BigDecimal("5"));
//		c.setY(new BigDecimal("6"));
		
		Punto a =  new Punto();
		a.setX(new BigDecimal("-2"));
		a.setY(new BigDecimal("-3"));
		
		Punto b = new Punto();
		b.setX(new BigDecimal("2"));
		b.setY(new BigDecimal("3"));
		
		Punto c = new Punto();
		c.setX(new BigDecimal("5"));
		c.setY(new BigDecimal("7.5"));
		
		Punto p0 = new Punto();
		p0.setX(new BigDecimal("0"));
		p0.setY(new BigDecimal("0"));
		 
		
		if(MatematicaUtils.estanAlineados(b, c, a)){
			if(MatematicaUtils.estanAlineados(b, c, p0)){
				System.out.println("p1 eje x: "+c.getX().toString()+"  "+ "eje y: "+c.getY().toString());
				System.out.println("p2 eje x: "+b.getX().toString()+"  "+ "eje y: "+b.getY().toString());
				System.out.println("p3 eje x: "+a.getX().toString()+"  "+ "eje y: "+a.getY().toString()+"\n");
			}
		}
	}
}
