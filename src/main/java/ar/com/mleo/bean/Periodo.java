package ar.com.mleo.bean;

import java.util.List;

public class Periodo {
	private Long periodo;
	private List<ClimaEstado> listaClimas;
	
	/**
	 * @return the periodo
	 */
	public Long getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}
	/**
	 * @return the listaClimas
	 */
	public List<ClimaEstado> getListaClimas() {
		return listaClimas;
	}
	/**
	 * @param listaClimas the listaClimas to set
	 */
	public void setListaClimas(List<ClimaEstado> listaClimas) {
		this.listaClimas = listaClimas;
	}
	
	
}
