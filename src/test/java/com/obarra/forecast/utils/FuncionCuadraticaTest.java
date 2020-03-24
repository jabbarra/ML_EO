package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;



public class FuncionCuadraticaTest {

    @Test
    public void testGetValorY() {
        Punto p1 = new Punto();
        p1.setAxisX(new BigDecimal("1"));
        p1.setAxisY(new BigDecimal("1"));

        Punto p2 = new Punto();
        p2.setAxisX(new BigDecimal("0"));
        p2.setAxisY(new BigDecimal("0"));

        FuncionCuadratica fun = new FuncionCuadratica(p1, p2);
        BigDecimal y = fun.getValorY(new BigDecimal("10"));

        assertEquals(10.0, y.doubleValue(), 0.1);

        p1 = new Punto();
        p1.setAxisX(new BigDecimal("25"));
        p1.setAxisY(new BigDecimal("22000"));

        p2 = new Punto();
        p2.setAxisX(new BigDecimal("32"));
        p2.setAxisY(new BigDecimal("27600"));

        fun = new FuncionCuadratica(p1, p2);
        y = fun.getValorY(new BigDecimal("0"));
        assertEquals(2000.0, y.doubleValue(), 0.1);
    }

}
