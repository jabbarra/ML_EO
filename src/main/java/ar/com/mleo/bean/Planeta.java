package ar.com.mleo.bean;

import java.math.BigDecimal;

public class Planeta {
    private String nombre;
    private BigDecimal radio;
    private BigDecimal periodo;
    private BigDecimal angulo;
    private BigDecimal circunferencia;
    private BigDecimal peridoSideral;
    private BigDecimal peridoSinodico;

    public Planeta(String nombre, String angulo, String periodo, String radio) {

        Double anguloRad = Math.toRadians(Double.parseDouble(angulo));
        this.angulo = new BigDecimal(anguloRad.toString());
        this.periodo = new BigDecimal(periodo);
        this.radio = new BigDecimal(radio);
        this.nombre = nombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the radio
     */
    public BigDecimal getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(BigDecimal radio) {
        this.radio = radio;
    }

    /**
     * @return the periodo
     */
    public BigDecimal getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(BigDecimal periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the angulo
     */
    public BigDecimal getAngulo() {
        return angulo;
    }

    /**
     * @param angulo the angulo to set
     */
    public void setAngulo(BigDecimal angulo) {
        this.angulo = angulo;
    }

    /**
     * @return the circunferencia
     */
    public BigDecimal getCircunferencia() {
        return circunferencia;
    }

    /**
     * @param circunferencia the circunferencia to set
     */
    public void setCircunferencia(BigDecimal circunferencia) {
        this.circunferencia = circunferencia;
    }

    /**
     * @return the peridoSideral
     */
    public BigDecimal getPeridoSideral() {
        return peridoSideral;
    }

    /**
     * @param peridoSideral the peridoSideral to set
     */
    public void setPeridoSideral(BigDecimal peridoSideral) {
        this.peridoSideral = peridoSideral;
    }

    /**
     * @return the peridoSinodico
     */
    public BigDecimal getPeridoSinodico() {
        return peridoSinodico;
    }

    /**
     * @param peridoSinodico the peridoSinodico to set
     */
    public void setPeridoSinodico(BigDecimal peridoSinodico) {
        this.peridoSinodico = peridoSinodico;
    }

}
