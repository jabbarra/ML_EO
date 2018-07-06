package ar.com.mleo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mleo.bean.Clima;
import ar.com.mleo.bean.ClimaEstado;
import ar.com.mleo.service.ClimaService;





@RestController
@RequestMapping("/clima")
public class ClimaController {

	
	@Autowired
	private ClimaService climaService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClimaEstado getLocalidadesByCliente(@PathVariable(value="id") Long  id) {
		ClimaEstado  clima = new ClimaEstado();
		clima.setDia(566);
		clima.setClima("lluvia");
		return clima;
    }
	
	@RequestMapping(value = "/climas", method = RequestMethod.GET)
	public List<Clima> getClimas() {
		
		List<Clima> climas = new ArrayList<Clima>();
		try {
			climas = climaService.getClimas();
			climaService.calcularPeriodoLLuvia();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return climas;
	}

	@RequestMapping(method = RequestMethod.GET)
    public String getDia() {
		return "HOY";
		
    }

}
