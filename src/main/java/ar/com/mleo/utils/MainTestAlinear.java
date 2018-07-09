package ar.com.mleo.utils;

import java.math.BigDecimal;

import ar.com.mleo.bean.Punto;

public class MainTestAlinear {

	public static void main(String[] args) {
		testPuntoInteriorTriangulo();

		testCoordenadasRectangulares();
		
		testFuncionCuadratica();
		testPuntosAlineados();
		testArea();
	}

	
	private static void testArea() {
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
	private static void testPuntosAlineados() {
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

	private static void testFuncionCuadratica() {
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("1"));
//		p1.setY(new BigDecimal("1"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("0"));
//		p2.setY(new BigDecimal("0"));
		
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("25"));
//		p1.setY(new BigDecimal("22000"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("32"));
//		p2.setY(new BigDecimal("27600"));
		
//		FuncionCuadratica fun = new FuncionCuadratica(p1, p2);
//		BigDecimal y = fun.getValorY(new BigDecimal("10"));
//		System.out.println(y.toString());
		
		
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
		
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("5"));
//		p1.setY(new BigDecimal("6"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("2"));
//		p2.setY(new BigDecimal("6"));
//		
//		Punto p3 =  new Punto();
//		p3.setX(new BigDecimal("-2"));
//		p3.setY(new BigDecimal("6"));
		
		Punto p1 = new Punto();
		p1.setX(new BigDecimal("-2"));
		p1.setY(new BigDecimal("-3"));
		
		Punto p2 = new Punto();
		p2.setX(new BigDecimal("2"));
		p2.setY(new BigDecimal("3"));
		
		Punto p3 =  new Punto();
		p3.setX(new BigDecimal("5"));
		p3.setY(new BigDecimal("7"));
		
		
		
		FuncionCuadratica recta = new FuncionCuadratica(p1, p2);
		BigDecimal yaux = recta.getValorY(p3.getX());
		 
		
		if(esSemejante(yaux, p3, 0.5)){
			System.out.println("p1 eje x: "+p1.getX().toString()+"  "+ "eje y: "+p1.getY().toString());
			System.out.println("p2 eje x: "+p2.getX().toString()+"  "+ "eje y: "+p2.getY().toString());
			System.out.println("p3 eje x: "+p3.getX().toString()+"  "+ "eje y: "+p3.getY().toString()+"\n");

		}
		
	}


	private static void testCoordenadasRectangulares() {
//		BigDecimal radio = new BigDecimal("2"); 
//		BigDecimal angulo = new BigDecimal("45"); 
//		BigDecimal periodo = new BigDecimal("1");
//		BigDecimal tiempo = new BigDecimal("1");
		
		BigDecimal radio = new BigDecimal("1.414213562"); 
		BigDecimal angulo = new BigDecimal("2.3562"); 
		BigDecimal periodo = new BigDecimal("1");
		BigDecimal tiempo = new BigDecimal("1");
	
		Punto coordenadas = MatematicaUtils.getCoordeadasRectangular(radio, angulo, periodo, tiempo);
		System.out.println(coordenadas.getX().toString());
		System.out.println(coordenadas.getY().toString());
	}


	private static void testPuntoInteriorTriangulo() {
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("2"));
//		p1.setY(new BigDecimal("2"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("-1"));
//		p2.setY(new BigDecimal("2"));
//		
//		Punto p3 = new Punto();
//		p3.setX(new BigDecimal("-3"));
//		p3.setY(new BigDecimal("-3"));
		
		
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("3"));
//		p1.setY(new BigDecimal("4"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("2"));
//		p2.setY(new BigDecimal("1"));
//		
//		Punto p3 = new Punto();
//		p3.setX(new BigDecimal("-2"));
//		p3.setY(new BigDecimal("2"));
	
		
		
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("-1"));
//		p1.setY(new BigDecimal("0"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("0"));
//		p2.setY(new BigDecimal("2"));
//		
//		Punto p3 = new Punto();
//		p3.setX(new BigDecimal("1"));
//		p3.setY(new BigDecimal("0"));
//		
//		Punto p = new Punto();
//		p.setX(new BigDecimal("0"));
//		p.setY(new BigDecimal("0"));
		
//		if(MatematicaUtils.esPuntoInteriorTriangulo(p1, p2, p3, p)){
//			System.out.println("sol SI ESTA en el triangulo");
//		}else{
//			System.out.println("sol NO ESTA en el triangulo");
//		}
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
