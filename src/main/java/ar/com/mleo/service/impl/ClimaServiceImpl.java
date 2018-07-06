package ar.com.mleo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mleo.bean.Clima;
import ar.com.mleo.dao.ClimaMapper;
import ar.com.mleo.dao.entity.ClimaEntity;
import ar.com.mleo.service.ClimaService;

@Service
public class ClimaServiceImpl implements ClimaService{
	
	@Autowired
	private ClimaMapper climaMapper;

	@Override
	public List<Clima> getClimas() {
		List<ClimaEntity> climasE = climaMapper.findClimas();
		
		List<Clima> climas = new ArrayList<Clima>();
		Clima c = new Clima();
		for (ClimaEntity climaEntity : climasE) {
			c = new Clima();
			c.setNombre(climaEntity.getNOMBRE());
			climas.add(c);

		}

		return climas;
	}

	@Override
	public void calcularPeriodoSequia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcularPeriodoLLuvia() {
		System.out.println("HOY LLUEVE");

	}

	@Override
	public void calcularPicoIntensidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcularCondicionesOptimas() {
		// TODO Auto-generated method stub
		
	}

}
