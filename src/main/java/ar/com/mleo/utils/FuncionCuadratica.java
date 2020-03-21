package ar.com.mleo.utils;

import ar.com.mleo.bean.Punto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author omar_barra
 */
public class FuncionCuadratica {
    private BigDecimal pendiente;
    private BigDecimal ordenadaOrigen;

    /**
     * Crea una funcion cuadratica con los dos puntos pasados por parametro
     *
     * @param p1
     * @param p2
     */
    public FuncionCuadratica(Punto p1, Punto p2) {
        this.pendiente = (p2.getY().subtract(p1.getY())).divide((p2.getX().subtract(p1.getX())), 8, RoundingMode.HALF_UP);
        this.ordenadaOrigen = p1.getY().subtract((pendiente.multiply(p1.getX())));
    }

    /**
     * Se obtiene la respuesta de la funcion cuadratica en funcion de x
     *
     * @param x
     * @return
     */
    public BigDecimal getValorY(BigDecimal x) {
        BigDecimal y = (pendiente.multiply(x)).add(ordenadaOrigen);
        return y;
    }


}
