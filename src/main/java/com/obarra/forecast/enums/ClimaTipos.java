package com.obarra.forecast.enums;

public enum ClimaTipos {
    LLUVIA("LLuvia"),
    SEQUIA("Sequía"),
    IDEAL("Ideal"),
    LLUVIA_I(1),
    SEQUIA_I(2),
    IDEAL_I(3),
    INDEFINIDO("Indefinido");

    private String valorS;
    private int valorI;

    ClimaTipos(final int valorI) {
        this.valorI = valorI;
    }

    ClimaTipos(final String valorS) {
        this.valorS = valorS;
    }

    /**
     * @return the valorS
     */
    public String getValorS() {
        return valorS;
    }
    /**
     * @return the valorI
     */
    public int getValorI() {
        return valorI;
    }

}
