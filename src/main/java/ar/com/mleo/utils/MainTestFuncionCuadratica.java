package ar.com.mleo.utils;

import java.math.BigDecimal;

import ar.com.mleo.bean.Punto;

public class MainTestFuncionCuadratica {

	public static void main(String[] args) {
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
		
		
		Punto p1 = new Punto();
		p1.setX(new BigDecimal("1"));
		p1.setY(new BigDecimal("1"));
		
		Punto p2 = new Punto();
		p2.setX(new BigDecimal("0"));
		p2.setY(new BigDecimal("0"));
		
//		Punto p1 = new Punto();
//		p1.setX(new BigDecimal("25"));
//		p1.setY(new BigDecimal("22000"));
//		
//		Punto p2 = new Punto();
//		p2.setX(new BigDecimal("32"));
//		p2.setY(new BigDecimal("27600"));
		
		FuncionCuadratica fun = new FuncionCuadratica(p1, p2);
		BigDecimal y = fun.getValorY(new BigDecimal("10"));
		System.out.println(y.toString());
		
//		long dia = 1;
//		long ultimoDia = 365 * 10;
//		
//		
//		BigDecimal fRadio = new BigDecimal("500"); 
//		BigDecimal fAngulo = new BigDecimal("1"); 
//		BigDecimal fPeriodo = new BigDecimal("1");
//		
//		BigDecimal bRadio = new BigDecimal("2000"); 
//		BigDecimal bAngulo = new BigDecimal("3"); 
//		BigDecimal bPeriodo = new BigDecimal("1");
//		
//		BigDecimal vRadio = new BigDecimal("1000"); 
//		BigDecimal vAngulo = new BigDecimal("5"); 
//		BigDecimal vPeriodo = new BigDecimal("1");
//		
//		Punto p0 = new Punto();
//		p0.setX(new BigDecimal(0));
//		p0.setY(new BigDecimal(0));
//		 
//		while(dia <= ultimoDia){
//			Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
//			Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
//			Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));
//			
//			FuncionCuadratica recta = new FuncionCuadratica(fp, p0);
//			BigDecimal yaux = recta.getValorY(bp.getX());
//			double ymin = yaux.doubleValue() - 0.5;
//			double ymax = yaux.doubleValue() + 0.5;
////			if(yaux.compareTo(bp.getY()) == 0){
//			if(ymin < bp.getY().doubleValue() && bp.getY().doubleValue() < ymax){
////				System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString()+"\n");
////				System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString()+"\n");
////				System.out.println(yaux.doubleValue());
//				yaux = recta.getValorY(vp.getX());
//				ymin = yaux.doubleValue() - 0.5;
//				ymax = yaux.doubleValue() + 0.5;
//				if(ymin < vp.getY().doubleValue() && vp.getY().doubleValue() < ymax){
//					System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString()+"\n");
//					System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString()+"\n");
//					System.out.println("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
//			}
//			
//			dia++;
//		}
		
//		obtenerClimaSequia();
//		obtenerClimaIdeal();
		test();
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
		
		Punto p0 = new Punto();
		p0.setX(new BigDecimal(0));
		p0.setY(new BigDecimal(0));
		 
		
		
		
		while(dia <= ultimoDia){
			Double anguloRad = Math.toRadians(1);
			fAngulo = new BigDecimal(anguloRad.toString());
			anguloRad = Math.toRadians(3);
			bAngulo = new BigDecimal(anguloRad.toString());
			anguloRad = Math.toRadians(5);
			vAngulo = new BigDecimal(anguloRad.toString());
			
			Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
			Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
			Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));
			
			FuncionCuadratica recta = new FuncionCuadratica(fp, p0);
			
			BigDecimal yaux = recta.getValorY(bp.getX());
			if(esSemejante(yaux, bp, 0.5)){
//				System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//				System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString()+"\n");
				yaux = recta.getValorY(vp.getX());
				if(esSemejante(yaux, vp, 0.5)){
					System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
					System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
					System.out.println("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
				}
			}
			
			dia++;
		}
		
	}

	private static void obtenerClimaIdeal() {
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
		
		Punto p0 = new Punto();
		p0.setX(new BigDecimal(0));
		p0.setY(new BigDecimal(0));
		 
		while(dia <= ultimoDia){
			Double anguloRad = Math.toRadians(1);
			fAngulo = new BigDecimal(anguloRad.toString());
			anguloRad = Math.toRadians(3);
			bAngulo = new BigDecimal(anguloRad.toString());
			anguloRad = Math.toRadians(5);
			vAngulo = new BigDecimal(anguloRad.toString());
			
			Punto fp = MatematicaUtils.getCoordeadasRectangular(fRadio, fAngulo, fPeriodo, new BigDecimal(dia));
			Punto bp = MatematicaUtils.getCoordeadasRectangular(bRadio, bAngulo, bPeriodo, new BigDecimal(dia));
			Punto vp = MatematicaUtils.getCoordeadasRectangular(vRadio, vAngulo, vPeriodo, new BigDecimal(dia));
			
			FuncionCuadratica recta = new FuncionCuadratica(fp, bp);
			BigDecimal yaux = recta.getValorY(vp.getX());
			
			if(esSemejante(yaux, vp, 0.5)){
				System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
				System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString()+"\n");
				
//				yaux = recta.getValorY(p0.getX());
//				if(esSemejante(yaux, p0, 0.5)){
//					System.out.println("F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					System.out.println("B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					System.out.println("V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}else{
//					System.out.println("-F eje x: "+fp.getX().toString()+"  "+ "eje y: "+fp.getY().toString());
//					System.out.println("-B eje x: "+bp.getX().toString()+"  "+ "eje y: "+bp.getY().toString());
//					System.out.println("-V eje x: "+vp.getX().toString()+"  "+ "eje y: "+vp.getY().toString()+"\n");
//				}
			}
			
			dia++;
		}
		
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

	private static boolean esSemejante(BigDecimal yaux, Punto p0, double desvio) {
		double ymin = yaux.doubleValue() - desvio;
		double ymax = yaux.doubleValue() + desvio;
		if(ymin < p0.getY().doubleValue() && p0.getY().doubleValue() < ymax){
			return true;
		}
		return false;
	}
}
