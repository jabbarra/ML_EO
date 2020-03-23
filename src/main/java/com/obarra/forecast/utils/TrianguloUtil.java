package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;

import java.math.BigDecimal;

public final class TrianguloUtil {
    private TrianguloUtil() {
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
        BigDecimal primerTermino = (a.getAxisX()
                .subtract(c.getAxisX())).multiply((b.getAxisY().subtract(c.getAxisY())));
        BigDecimal segundoTermino = (a.getAxisY()
                .subtract(c.getAxisY())).multiply((b.getAxisX().subtract(c.getAxisX())));

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
        double terminoUno = Math.pow((b.getAxisX().subtract(a.getAxisX())).doubleValue(), 2);
        double terminoDos = Math.pow((b.getAxisY().subtract(a.getAxisY())).doubleValue(), 2);
        double ab = Math.sqrt(terminoUno + terminoDos);

        terminoUno = Math.pow((c.getAxisX().subtract(a.getAxisX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getAxisY().subtract(a.getAxisY())).doubleValue(), 2);
        double ac = Math.sqrt(terminoUno + terminoDos);

        terminoUno = Math.pow((c.getAxisX().subtract(b.getAxisX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getAxisY().subtract(b.getAxisY())).doubleValue(), 2);
        double bc = Math.sqrt(terminoUno + terminoDos);

        double semiperimetro = (ab + ac + bc) / 2;

        return Math.sqrt(semiperimetro
                * (semiperimetro - ab)
                * (semiperimetro - ac)
                * (semiperimetro - bc));
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
        double terminoUno = Math.pow((b.getAxisX().subtract(a.getAxisX())).doubleValue(), 2);
        double terminoDos = Math.pow((b.getAxisY().subtract(a.getAxisY())).doubleValue(), 2);
        double ab = Math.sqrt(terminoUno + terminoDos);
        ab = ab < 0 ? -ab : ab;

        terminoUno = Math.pow((c.getAxisX().subtract(a.getAxisX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getAxisY().subtract(a.getAxisY())).doubleValue(), 2);
        double ac = Math.sqrt(terminoUno + terminoDos);
        ac = ac < 0 ? -ac : ac;

        terminoUno = Math.pow((c.getAxisX().subtract(b.getAxisX())).doubleValue(), 2);
        terminoDos = Math.pow((c.getAxisY().subtract(b.getAxisY())).doubleValue(), 2);
        double bc = Math.sqrt(terminoUno + terminoDos);
        bc = bc < 0 ? -bc : bc;

        return ab + ac + bc;
    }
}
