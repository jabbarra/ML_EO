package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MatematicaUtilsTest {

    @Test
    public void testGetCoordeadasRectangular() {
        BigDecimal radio = new BigDecimal("2");
        BigDecimal angulo = new BigDecimal("45");
        BigDecimal periodo = new BigDecimal("1");
        BigDecimal tiempo = new BigDecimal("1");

        Punto coordenadas = MatematicaUtil.getCoordeadasRectangular(radio, angulo, periodo, tiempo);

        assertEquals(1.05, coordenadas.getX().doubleValue(), 0.1);
        assertEquals(1.70, coordenadas.getY().doubleValue(), 0.1);

        radio = new BigDecimal("1.414213562");
        angulo = new BigDecimal("2.3562");
        periodo = new BigDecimal("1");
        tiempo = new BigDecimal("1");

        coordenadas = MatematicaUtil.getCoordeadasRectangular(radio, angulo, periodo, tiempo);

        assertEquals(-1.00, coordenadas.getX().doubleValue(), 0.1);
        assertEquals(0.99, coordenadas.getY().doubleValue(), 0.1);
    }

    @Test
    public void testGetCoordeadasRectangularAntihorario() {
        BigDecimal radio = new BigDecimal("2");
        BigDecimal angulo = new BigDecimal("45");
        BigDecimal periodo = new BigDecimal("1");
        BigDecimal tiempo = new BigDecimal("1");

        Punto coordenadas = MatematicaUtil.getCoordeadasRectangularAntihorario(radio, angulo, periodo, tiempo);

        assertEquals(1.05, coordenadas.getX().doubleValue(), 0.1);
        assertNotEquals(1.70, coordenadas.getY().doubleValue(), 0.1);

    }

    @Test
    public void testEstanAlineados() {
        Punto p1 = new Punto();
        p1.setX(new BigDecimal("1"));
        p1.setY(new BigDecimal("1"));

        Punto p2 = new Punto();
        p2.setX(new BigDecimal("3"));
        p2.setY(new BigDecimal("3"));

        Punto p3 = new Punto();
        p3.setX(new BigDecimal("0"));
        p3.setY(new BigDecimal("0"));

        boolean resultado = MatematicaUtil.estanAlineados(p1, p2, p3);
        assertEquals(true, resultado);

        p3 = new Punto();
        p3.setX(new BigDecimal("5"));
        p3.setY(new BigDecimal("2"));
        resultado = MatematicaUtil.estanAlineados(p1, p2, p3);
        assertEquals(false, resultado);
    }

    @Test
    public void testEsSemejante() {
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("2");
        boolean resultado = MatematicaUtil.esSemejante(a, b, 0.1);
        assertEquals(true, resultado);

        a = new BigDecimal("2.78");
        b = new BigDecimal("2");
        resultado = MatematicaUtil.esSemejante(a, b, 0.1);
        assertEquals(false, resultado);
    }

}
