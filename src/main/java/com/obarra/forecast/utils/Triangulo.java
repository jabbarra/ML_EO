package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class Triangulo {
    private Triangulo() {
    }

    /**
     * Devuelve true si el triangulo generado
     * por los tres puntos pasados por parametro esta orientados positivamente.
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean esOrientacionPositiva(final Punto a,
                                                final Punto b,
                                                final Punto c) {
        boolean esPositivo = false;
        BigDecimal primerTermino = (a.getX()
                .subtract(c.getX())).multiply((b.getY().subtract(c.getY())));
        BigDecimal segundoTermino = (a.getY()
                .subtract(c.getY())).multiply((b.getX().subtract(c.getX())));

        BigDecimal orientacion = primerTermino.subtract(segundoTermino);
        if (orientacion.doubleValue() >= 0) {
            esPositivo = true;
        }
        return esPositivo;
    }

    /**
     * Devuelve true si el punto @param p esta dentro
     * del triangulo generado por los puntos @param a, @param b, @param c.
     *
     * @param a
     * @param b
     * @param c
     * @param p
     * @return
     */
    public static boolean esPuntoInteriorTriangulo(final Punto a,
                                                   final Punto b,
                                                   final Punto c,
                                                   final Punto p) {
        boolean esInterior = false;
        if (esOrientacionPositiva(a, b, c)
                && esOrientacionPositiva(a, b, p)
                && esOrientacionPositiva(a, p, c)
                && esOrientacionPositiva(p, b, c)) {
            esInterior = true;
        } else if (!esOrientacionPositiva(a, b, c)
                && !esOrientacionPositiva(a, b, p)
                && !esOrientacionPositiva(a, p, c)
                && !esOrientacionPositiva(p, b, c)) {
            esInterior = true;
        }

        return esInterior;
    }

    /**
     * Devuelve el area del triangulo generado
     * por los tres puntos pasados por parametro.
     * Para calcular el area utiliza la formula de heron.
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double getArea(final Punto a,
                                 final Punto b,
                                 final Punto c) {
        double terminoUno = Math.pow((b.getX().subtract(a.getX())).doubleValue(), 2);
        double terminoDos = Math.pow((b.getY().subtract(a.getY())).doubleValue(), 2);
        double ab = Math.sqrt(terminoUno + terminoDos);

        terminoUno = Math.pow((c.getX().subtract(a.getX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getY().subtract(a.getY())).doubleValue(), 2);
        double ac = Math.sqrt(terminoUno + terminoDos);

        terminoUno = Math.pow((c.getX().subtract(b.getX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getY().subtract(b.getY())).doubleValue(), 2);
        double bc = Math.sqrt(terminoUno + terminoDos);

        double semiperimetro = (ab + ac + bc) / 2;

        double dividendo = ab + ac + bc;

        BigDecimal aux = new BigDecimal(dividendo, MathContext.DECIMAL64);
        aux = aux.divide(new BigDecimal(2), 8, RoundingMode.HALF_UP);

        double area = Math.sqrt(semiperimetro
                * (semiperimetro - ab)
                * (semiperimetro - ac)
                * (semiperimetro - bc));
        return area;
    }

    /**
     * Devuelve el perimetro del triangulo generado
     * por los tres puntos pasados por parametro.
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double getPerimetro(final Punto a,
                                      final Punto b,
                                      final Punto c) {
        double terminoUno = Math.pow((b.getX().subtract(a.getX())).doubleValue(), 2);
        double terminoDos = Math.pow((b.getY().subtract(a.getY())).doubleValue(), 2);
        double ab = Math.sqrt(terminoUno + terminoDos);
        ab = ab < 0 ? -ab : ab;

        terminoUno = Math.pow((c.getX().subtract(a.getX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getY().subtract(a.getY())).doubleValue(), 2);
        double ac = Math.sqrt(terminoUno + terminoDos);
        ac = ac < 0 ? -ac : ac;

        terminoUno = Math.pow((c.getX().subtract(b.getX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getY().subtract(b.getY())).doubleValue(), 2);
        double bc = Math.sqrt(terminoUno + terminoDos);
        bc = bc < 0 ? -bc : bc;

        double perimetro = ab + ac + bc;

        return perimetro;
    }
}
