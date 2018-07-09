package ar.com.mleo.bean;

import java.util.ArrayList;
import java.util.List;

public class Informe {
	private String titulo;
	private List<Periodo> listaPeriodos;
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the listaPeriodos
	 */
	public List<Periodo> getListaPeriodos() {
		if(this.listaPeriodos == null){
			this.listaPeriodos = new ArrayList<Periodo>();
		}
		return listaPeriodos;
	}
	
}
