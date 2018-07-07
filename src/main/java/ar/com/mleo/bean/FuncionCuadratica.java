package ar.com.mleo.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FuncionCuadratica {
	private BigDecimal pendiente;
	private BigDecimal ordenadaOrigen;
	
	public FuncionCuadratica(Punto p1, Punto p2) {
		this.pendiente = (p2.getY().subtract(p1.getY())).divide((p2.getX().subtract(p1.getX())), 8, RoundingMode.HALF_UP);
		this.ordenadaOrigen = p1.getY().subtract((pendiente.multiply(p1.getX())));
	}
	
	public BigDecimal getValorY(BigDecimal x){
		BigDecimal y = (pendiente.multiply(x)).add(ordenadaOrigen);
		return y;
	}
	

}
