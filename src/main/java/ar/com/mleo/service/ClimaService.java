package ar.com.mleo.service;



import java.util.List;
import ar.com.mleo.bean.Clima;


public interface ClimaService {
	List<Clima> getClimas();
	void calcularPeriodoSequia(); 
	void calcularPeriodoLLuvia(); 
	void calcularPicoIntensidad();
	void calcularCondicionesOptimas(); 
}
