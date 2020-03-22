package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.Clima;
import com.obarra.forecast.bean.ClimaEstado;
import com.obarra.forecast.bean.Informe;
import com.obarra.forecast.bean.Periodo;
import com.obarra.forecast.mapper.ClimaMapper;
import com.obarra.forecast.mapper.DiaMapper;
import com.obarra.forecast.mapper.entity.DiaEntity;
import com.obarra.forecast.service.ClimaService;
import com.obarra.forecast.utils.ClimaTipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClimaServiceImpl implements ClimaService {

    private ClimaMapper climaMapper;
    private DiaMapper diaMapper;

    @Autowired
    public ClimaServiceImpl(final ClimaMapper climaMapper,
                            final DiaMapper diaMapper){
        this.climaMapper = climaMapper;
        this.diaMapper = diaMapper;
    }

    @Override
    public List<Clima> getClimas() {
        return climaMapper.findClimas()
                .stream()
                .map(e -> {
                    final Clima clima = new Clima();
                    clima.setNombre(e.getNombre());
                    return clima;
                }).collect(Collectors.toList());
    }

    @Override
    public ClimaEstado getClimaDelDia(final Long dia) {
        final ClimaEstado climaEstado = new ClimaEstado();
        climaEstado.setClima(ClimaTipos.INDEFINIDO.getValorS());
        climaEstado.setDia(dia);

        final DiaEntity diaE = diaMapper.findByDia(dia);
        if (diaE != null) {
            climaEstado.setClima(diaE.getClima());
            climaEstado.setDia(diaE.getNumero());
        }
        return climaEstado;
    }

    @Override
    public Informe getPeriodoLLuvia() {
        final List<DiaEntity> dias = diaMapper
                .findDiasByClima(ClimaTipos.LLUVIA_I.getValorI());
        final DiaEntity diaMaximaIntensidad = diaMapper.findDiaMaximaIntensidad();

        final Informe informe = generarInformedeClima(ClimaTipos.LLUVIA.getValorS(), dias);

        final StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(informe.getTitulo())
                .append(" El pico máximo de lluvia será el día: ")
                .append(diaMaximaIntensidad.getNumero());
        informe.setTitulo(stringBuilder.toString());

        return informe;
    }


    @Override
    public Informe getPeriodosSequia() {
        final List<DiaEntity> dias = diaMapper.findDiasByClima(ClimaTipos.SEQUIA_I.getValorI());

        return this.generarInformedeClima(ClimaTipos.SEQUIA.getValorS(), dias);
    }

    @Override
    public Informe getCondicionesOptimas() {
        final List<DiaEntity> dias = diaMapper.findDiasByClima(ClimaTipos.IDEAL_I.getValorI());

        return this.generarInformedeClima(ClimaTipos.IDEAL.getValorS(), dias);
    }

    private Informe generarInformedeClima(final String tipoClima, final List<DiaEntity> dias) {
        final Informe informe = new Informe();

        ClimaEstado clima = null;
        long diaAnterior = -1;
        long contadorPeriodos = 0;

        Periodo periodo = null;

        for (final DiaEntity dia : dias) {
            if (diaAnterior == -1 || (diaAnterior + 1) != dia.getNumero()) {
                contadorPeriodos++;
                periodo = new Periodo();
                periodo.setValue(contadorPeriodos);
                periodo.setClimaEstados(new ArrayList<ClimaEstado>());
                informe.getListaPeriodos().add(periodo);

                clima = new ClimaEstado();
                clima.setClima(tipoClima);
                clima.setDia(dia.getNumero());
                periodo.getClimaEstados().add(clima);
            } else {
                clima = new ClimaEstado();
                clima.setClima(tipoClima);
                clima.setDia(dia.getNumero());
                periodo.getClimaEstados().add(clima);
            }
            diaAnterior = dia.getNumero();
        }

        informe.setTitulo("Habrá " + contadorPeriodos
                + " períodos de " + tipoClima + ".");

        return informe;
    }

}
