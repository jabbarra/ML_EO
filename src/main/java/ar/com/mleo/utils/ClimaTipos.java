package ar.com.mleo.utils;

public enum ClimaTipos {
    LLUVIA("LLuvia"),
    SEQUIA("Sequía"),
    IDEAL("Ideal")
    ;

    private String valorS;

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


}
