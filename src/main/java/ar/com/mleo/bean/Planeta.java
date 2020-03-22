package ar.com.mleo.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Planeta {
    private String nombre;
    private BigDecimal radio;
    private BigDecimal periodo;
    private BigDecimal angulo;
    private BigDecimal circunferencia;
    private BigDecimal peridoSideral;
    private BigDecimal peridoSinodico;

    public Planeta(final String nombre,
                   final String angulo,
                   final String periodo,
                   final String radio) {

        Double anguloRad = Math.toRadians(Double.parseDouble(angulo));
        this.angulo = new BigDecimal(anguloRad.toString());
        this.periodo = new BigDecimal(periodo);
        this.radio = new BigDecimal(radio);
        this.nombre = nombre;
    }

}
