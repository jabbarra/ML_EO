package com.obarra.forecast.utils;

import com.obarra.forecast.bean.Punto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author omar_barra
 */
public class FuncionCuadratica {
    private BigDecimal pendiente;
    private BigDecimal ordenadaOrigen;

    /**
     * Crea una funcion cuadratica con los dos puntos pasados por parametro.
     *
     * @param p1
     * @param p2
     */
    public FuncionCuadratica(final Punto p1, final Punto p2) {
        this.pendiente = (p2.getAxisY()
                .subtract(p1.getAxisY()))
                .divide((p2.getAxisX().subtract(p1.getAxisX())),
                        8, RoundingMode.HALF_UP);
        this.ordenadaOrigen = p1.getAxisY()
                .subtract((pendiente.multiply(p1.getAxisX())));
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
