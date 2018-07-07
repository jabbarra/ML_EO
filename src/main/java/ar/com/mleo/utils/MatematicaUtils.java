package ar.com.mleo.utils;

import java.math.BigDecimal;

import ar.com.mleo.bean.Punto;

public class MatematicaUtils {
	
	public static boolean esOrientacionPositiva(Punto p1, Punto p2, Punto p3){
		boolean esPositivo = false;
		BigDecimal primerTermino = (p1.getX().subtract(p3.getX())).multiply((p2.getY().subtract(p3.getY())));
		BigDecimal segundoTermino = (p1.getY().subtract(p3.getY())).multiply((p2.getX().subtract(p3.getX())));
		
		BigDecimal orientacion = primerTermino.subtract(segundoTermino);
		if(orientacion.doubleValue() >= 0){
			esPositivo = true;
		}
//		long orientacion = ((p1.getX() - p3.getX())*(p2.getY() - p3.getY())) - ((p1.getY() - p3.getY())*(p2.getX() - p3.getX()));
//		if(orientacion >= 0){
//			esPositivo = true;
//		}
		return esPositivo;
	}
	
	
	public static boolean esPuntoInteriorTriangulo(Punto p1, Punto p2, Punto p3, Punto p){
		boolean esInterior = false;
		if(MatematicaUtils.esOrientacionPositiva(p1, p2, p3)&&
				MatematicaUtils.esOrientacionPositiva(p1, p2, p) && 
				MatematicaUtils.esOrientacionPositiva(p1, p, p3) &&
				MatematicaUtils.esOrientacionPositiva(p, p2, p3)){
			esInterior = true;
		}else if(!MatematicaUtils.esOrientacionPositiva(p1, p2, p3) &&
				!MatematicaUtils.esOrientacionPositiva(p1, p2, p) && 
				!MatematicaUtils.esOrientacionPositiva(p1, p, p3) &&
				!MatematicaUtils.esOrientacionPositiva(p, p2, p3)){
			esInterior = true;
		}
		
		return esInterior;
	}
	
	public static Punto getCoordeadasRectangular(BigDecimal radio, BigDecimal angulo, BigDecimal periodo, BigDecimal tiempo){
		BigDecimal velocidadAngular = angulo.divide(periodo);
		BigDecimal thita = velocidadAngular.multiply(tiempo);
		Double cos = Math.cos(thita.doubleValue());
		BigDecimal x = radio.multiply(new BigDecimal(cos.toString()));
		
		Double sin = Math.sin(thita.doubleValue());
		BigDecimal y = radio.multiply(new BigDecimal(sin.toString()));
		
		Punto punto = new Punto();
		punto.setX(x);
		punto.setY(y);
		
		return punto;
	}
	
}
