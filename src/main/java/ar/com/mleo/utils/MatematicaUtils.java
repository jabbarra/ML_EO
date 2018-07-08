package ar.com.mleo.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
	
	public static Punto getCoordeadasRectangularAntihorario(BigDecimal radio, BigDecimal angulo, BigDecimal periodo, BigDecimal tiempo){
		BigDecimal velocidadAngular = angulo.divide(periodo);
		BigDecimal thita = velocidadAngular.multiply(tiempo);
		Double cos = Math.cos(thita.doubleValue());
		BigDecimal x = radio.multiply(new BigDecimal(cos.toString()));
		
		Double sin = -Math.sin(thita.doubleValue());
		BigDecimal y = radio.multiply(new BigDecimal(sin.toString()));
		
		Punto punto = new Punto();
		punto.setX(x);
		punto.setY(y);
		
		return punto;
	}
	
	public static boolean estanAlineados(Punto a, Punto b, Punto c){
		BigDecimal ab = (b.getX().subtract(a.getX())).divide((c.getX().subtract(b.getX())), 8, RoundingMode.HALF_UP);
		BigDecimal bc = (b.getY().subtract(a.getY())).divide((c.getY().subtract(b.getY())), 8, RoundingMode.HALF_UP);
//		if(ab.compareTo(bc) == 0){
		if(esSemejante(ab, bc, 0.24)){
			return true;
		}
		return false;
	}
	
	private static boolean esSemejante(BigDecimal yaux, BigDecimal y, double desvio) {
		double ymin = yaux.doubleValue() - desvio;
		double ymax = yaux.doubleValue() + desvio;
		if(ymin < y.doubleValue() && y.doubleValue() < ymax){
			return true;
		}
		return false;
	}
	
	public static double getArea(Punto a, Punto b, Punto c){
		double terminoUno = Math.pow((b.getX().subtract(a.getX())).doubleValue(), 2);
		double terminoDos = Math.pow((b.getY().subtract(a.getY())).doubleValue(), 2);
		double ab = Math.sqrt(terminoUno + terminoDos);
		
		terminoUno = Math.pow((c.getX().subtract(a.getX())).doubleValue(), 2);
		terminoDos = Math.pow((c.getY().subtract(a.getY())).doubleValue(), 2);
		double ac = Math.sqrt(terminoUno + terminoDos);
		
		terminoUno = Math.pow((c.getX().subtract(b.getX())).doubleValue(), 2);
		terminoDos = Math.pow((c.getY().subtract(b.getY())).doubleValue(), 2);
		double bc = Math.sqrt(terminoUno + terminoDos);
		
		double semiperimetro = (ab + ac + bc)/2;
		
		double dividendo = ab + ac + bc;

		BigDecimal aux = new BigDecimal(dividendo, MathContext.DECIMAL64);
		aux  = aux.divide(new BigDecimal(2), 8, RoundingMode.HALF_UP);
		
		double area = Math.sqrt(semiperimetro*(semiperimetro - ab)*(semiperimetro - ac)*(semiperimetro - bc));
		
		return area;
	}
	
}
