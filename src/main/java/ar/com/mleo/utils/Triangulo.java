package ar.com.mleo.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import ar.com.mleo.bean.Punto;

public class  Triangulo {
	public static boolean esOrientacionPositiva(Punto a, Punto b, Punto c){
		boolean esPositivo = false;
		BigDecimal primerTermino = (a.getX().subtract(c.getX())).multiply((b.getY().subtract(c.getY())));
		BigDecimal segundoTermino = (a.getY().subtract(c.getY())).multiply((b.getX().subtract(c.getX())));
		
		BigDecimal orientacion = primerTermino.subtract(segundoTermino);
		if(orientacion.doubleValue() >= 0){
			esPositivo = true;
		}
		return esPositivo;
	}
	
	public static boolean esPuntoInteriorTriangulo(Punto a, Punto b, Punto c, Punto p){
		boolean esInterior = false;
		if(esOrientacionPositiva(a, b, c)&&
				esOrientacionPositiva(a, b, p) && 
				esOrientacionPositiva(a, p, c) &&
				esOrientacionPositiva(p, b, c)){
			esInterior = true;
		}else if(!esOrientacionPositiva(a, b, c) &&
				!esOrientacionPositiva(a, b, p) && 
				!esOrientacionPositiva(a, p, c) &&
				!esOrientacionPositiva(p, b, c)){
			esInterior = true;
		}
		
		return esInterior;
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
	
	public static double getPerimetro(Punto a, Punto b, Punto c){
		double terminoUno = Math.pow((b.getX().subtract(a.getX())).doubleValue(), 2);
		double terminoDos = Math.pow((b.getY().subtract(a.getY())).doubleValue(), 2);
		double ab = Math.sqrt(terminoUno + terminoDos);
		ab = ab < 0? -ab:ab;
		
		terminoUno = Math.pow((c.getX().subtract(a.getX())).doubleValue(), 2);
		terminoDos = Math.pow((c.getY().subtract(a.getY())).doubleValue(), 2);
		double ac = Math.sqrt(terminoUno + terminoDos);
		ac = ac < 0? -ac:ac;
		
		terminoUno = Math.pow((c.getX().subtract(b.getX())).doubleValue(), 2);
		terminoDos = Math.pow((c.getY().subtract(b.getY())).doubleValue(), 2);
		double bc = Math.sqrt(terminoUno + terminoDos);
		bc = bc < 0? -bc:bc;
		
		double perimetro = ab + ac + bc;
		
		return perimetro;
	}
	
}
