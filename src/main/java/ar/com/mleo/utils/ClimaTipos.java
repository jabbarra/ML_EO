package ar.com.mleo.utils;

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

    ClimaTipos(int valorI) {
        this.valorI = valorI;
    }

    ClimaTipos(String valorS) {
        this.valorS = valorS;
    }

    /**
     * @return the valorS
     */
    public String getValorS() {
        return valorS;
    }

    /**
     * @param valorS the valorS to set
     */
    public void setValorS(String valorS) {
        this.valorS = valorS;
    }

    /**
     * @return the valorI
     */
    public int getValorI() {
        return valorI;
    }

    /**
     * @param valorI the valorI to set
     */
    public void setValorI(int valorI) {
        this.valorI = valorI;
    }


}
