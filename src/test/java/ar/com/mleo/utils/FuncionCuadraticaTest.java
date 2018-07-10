package ar.com.mleo.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import ar.com.mleo.bean.Punto;

public class FuncionCuadraticaTest {

	@Test
	public void testGetValorY() {
		Punto p1 = new Punto();
		p1.setX(new BigDecimal("1"));
		p1.setY(new BigDecimal("1"));

		Punto p2 = new Punto();
		p2.setX(new BigDecimal("0"));
		p2.setY(new BigDecimal("0"));

		FuncionCuadratica fun = new FuncionCuadratica(p1, p2);
		BigDecimal y = fun.getValorY(new BigDecimal("10"));

		assertEquals(10.0, y.doubleValue(), 0.1);

		p1 = new Punto();
		p1.setX(new BigDecimal("25"));
		p1.setY(new BigDecimal("22000"));

		p2 = new Punto();
		p2.setX(new BigDecimal("32"));
		p2.setY(new BigDecimal("27600"));

		fun = new FuncionCuadratica(p1, p2);
		y = fun.getValorY(new BigDecimal("0"));
		assertEquals(2000.0, y.doubleValue(), 0.1);
	}

}