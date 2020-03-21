package ar.com.mleo.utils;

import ar.com.mleo.bean.Punto;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TrianguloTest {

    @Test
    public void testEsPuntoInteriorTriangulo() {
        Punto p = new Punto();
        p.setX(new BigDecimal("0"));
        p.setY(new BigDecimal("0"));

        Punto p1 = new Punto();
        p1.setX(new BigDecimal("2"));
        p1.setY(new BigDecimal("2"));

        Punto p2 = new Punto();
        p2.setX(new BigDecimal("-1"));
        p2.setY(new BigDecimal("2"));

        Punto p3 = new Punto();
        p3.setX(new BigDecimal("-3"));
        p3.setY(new BigDecimal("-3"));

        boolean resultado = Triangulo.esPuntoInteriorTriangulo(p1, p2, p3, p);
        assertEquals(true, resultado);

        p1 = new Punto();
        p1.setX(new BigDecimal("3"));
        p1.setY(new BigDecimal("4"));

        p2 = new Punto();
        p2.setX(new BigDecimal("2"));
        p2.setY(new BigDecimal("1"));

        p3 = new Punto();
        p3.setX(new BigDecimal("-2"));
        p3.setY(new BigDecimal("2"));

        resultado = Triangulo.esPuntoInteriorTriangulo(p1, p2, p3, p);
        assertEquals(false, resultado);


        p1 = new Punto();
        p1.setX(new BigDecimal("-1"));
        p1.setY(new BigDecimal("0"));

        p2 = new Punto();
        p2.setX(new BigDecimal("0"));
        p2.setY(new BigDecimal("2"));

        p3 = new Punto();
        p3.setX(new BigDecimal("1"));
        p3.setY(new BigDecimal("0"));

        resultado = Triangulo.esPuntoInteriorTriangulo(p1, p2, p3, p);
        assertEquals(false, resultado);

    }

    @Test
    public void testGetArea() {
        Punto a = new Punto();
        a.setX(new BigDecimal("-2"));
        a.setY(new BigDecimal("3"));

        Punto b = new Punto();
        b.setX(new BigDecimal("3"));
        b.setY(new BigDecimal("-1"));

        Punto c = new Punto();
        c.setX(new BigDecimal("5"));
        c.setY(new BigDecimal("6"));

        double resultado = Triangulo.getArea(a, b, c);
        assertEquals(21.5, resultado, 0.1);

        a = new Punto();
        a.setX(new BigDecimal("-4"));
        a.setY(new BigDecimal("-4"));

        b = new Punto();
        b.setX(new BigDecimal("0"));
        b.setY(new BigDecimal("4"));

        c = new Punto();
        c.setX(new BigDecimal("4"));
        c.setY(new BigDecimal("-4"));


        resultado = Triangulo.getArea(a, b, c);
        assertEquals(32.0, resultado, 0.1);

    }

    @Test
    public void testGetPerimetro() {
        Punto a = new Punto();
        a.setX(new BigDecimal("-2"));
        a.setY(new BigDecimal("3"));

        Punto b = new Punto();
        b.setX(new BigDecimal("3"));
        b.setY(new BigDecimal("-1"));

        Punto c = new Punto();
        c.setX(new BigDecimal("5"));
        c.setY(new BigDecimal("6"));

        double resultado = Triangulo.getPerimetro(a, b, c);
        assertEquals(21.29, resultado, 0.1);

        a = new Punto();
        a.setX(new BigDecimal("-4"));
        a.setY(new BigDecimal("-4"));

        b = new Punto();
        b.setX(new BigDecimal("0"));
        b.setY(new BigDecimal("4"));

        c = new Punto();
        c.setX(new BigDecimal("4"));
        c.setY(new BigDecimal("-4"));


        resultado = Triangulo.getPerimetro(a, b, c);
        assertEquals(25.88, resultado, 0.1);
    }

}
