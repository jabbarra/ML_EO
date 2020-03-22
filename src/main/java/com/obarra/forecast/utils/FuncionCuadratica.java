package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author omar_barra
 */
public class FuncionCuadratica  {
    private BigDecimal pendiente;
    private BigDecimal ordenadaOrigen;

    /**
     * Crea una funcion cuadratica con los dos puntos pasados por parametro.
     *
     * @param p1
     * @param p2
     */
    public FuncionCuadratica(final Punto p1, final Punto p2) {
        this.pendiente = (p2.getY()
                .subtract(p1.getY()))
                .divide((p2.getX().subtract(p1.getX())),
                        8, RoundingMode.HALF_UP);
        this.ordenadaOrigen = p1.getY()
                .subtract((pendiente.multiply(p1.getX())));
    }

    /**
     * Se obtiene la respuesta de la funcion cuadratica en funcion de x.
     *
     * @param x
     * @return y
     */
    public BigDecimal getValorY(final BigDecimal x) {
        return (pendiente.multiply(x)).add(ordenadaOrigen);
    }
}
