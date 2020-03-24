package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
public class TrianguloTest {

    @Test
    public void testEsPuntoInteriorTriangulo() {
        Punto p = new Punto();
        p.setAxisX(new BigDecimal("0"));
        p.setAxisY(new BigDecimal("0"));

        Punto p1 = new Punto();
        p1.setAxisX(new BigDecimal("2"));
        p1.setAxisY(new BigDecimal("2"));

        Punto p2 = new Punto();
        p2.setAxisX(new BigDecimal("-1"));
        p2.setAxisY(new BigDecimal("2"));

        Punto p3 = new Punto();
        p3.setAxisX(new BigDecimal("-3"));
        p3.setAxisY(new BigDecimal("-3"));

        boolean resultado = TrianguloUtil.esPuntoInteriorTriangulo(p1, p2, p3, p);
        assertEquals(true, resultado);

        p1 = new Punto();
        p1.setAxisX(new BigDecimal("3"));
        p1.setAxisY(new BigDecimal("4"));

        p2 = new Punto();
        p2.setAxisX(new BigDecimal("2"));
        p2.setAxisY(new BigDecimal("1"));

        p3 = new Punto();
        p3.setAxisX(new BigDecimal("-2"));
        p3.setAxisY(new BigDecimal("2"));

        resultado = TrianguloUtil.esPuntoInteriorTriangulo(p1, p2, p3, p);
        assertEquals(false, resultado);


        p1 = new Punto();
        p1.setAxisX(new BigDecimal("-1"));
        p1.setAxisY(new BigDecimal("0"));

        p2 = new Punto();
        p2.setAxisX(new BigDecimal("0"));
        p2.setAxisY(new BigDecimal("2"));

        p3 = new Punto();
        p3.setAxisX(new BigDecimal("1"));
        p3.setAxisY(new BigDecimal("0"));

        resultado = TrianguloUtil.esPuntoInteriorTriangulo(p1, p2, p3, p);
        assertEquals(false, resultado);

    }

    @Test
    public void testGetArea() {
        Punto a = new Punto();
        a.setAxisX(new BigDecimal("-2"));
        a.setAxisY(new BigDecimal("3"));

        Punto b = new Punto();
        b.setAxisX(new BigDecimal("3"));
        b.setAxisY(new BigDecimal("-1"));

        Punto c = new Punto();
        c.setAxisX(new BigDecimal("5"));
        c.setAxisY(new BigDecimal("6"));

        double resultado = TrianguloUtil.getArea(a, b, c);
        assertEquals(21.5, resultado, 0.1);

        a = new Punto();
        a.setAxisX(new BigDecimal("-4"));
        a.setAxisY(new BigDecimal("-4"));

        b = new Punto();
        b.setAxisX(new BigDecimal("0"));
        b.setAxisY(new BigDecimal("4"));

        c = new Punto();
        c.setAxisX(new BigDecimal("4"));
        c.setAxisY(new BigDecimal("-4"));


        resultado = TrianguloUtil.getArea(a, b, c);
        assertEquals(32.0, resultado, 0.1);

    }

    @Test
    public void testGetPerimetro() {
        Punto a = new Punto();
        a.setAxisX(new BigDecimal("-2"));
        a.setAxisY(new BigDecimal("3"));

        Punto b = new Punto();
        b.setAxisX(new BigDecimal("3"));
        b.setAxisY(new BigDecimal("-1"));

        Punto c = new Punto();
        c.setAxisX(new BigDecimal("5"));
        c.setAxisY(new BigDecimal("6"));

        double resultado = TrianguloUtil.getPerimetro(a, b, c);
        assertEquals(21.29, resultado, 0.1);

        a = new Punto();
        a.setAxisX(new BigDecimal("-4"));
        a.setAxisY(new BigDecimal("-4"));

        b = new Punto();
        b.setAxisX(new BigDecimal("0"));
        b.setAxisY(new BigDecimal("4"));

        c = new Punto();
        c.setAxisX(new BigDecimal("4"));
        c.setAxisY(new BigDecimal("-4"));


        resultado = TrianguloUtil.getPerimetro(a, b, c);
        assertEquals(25.88, resultado, 0.1);
    }

}
