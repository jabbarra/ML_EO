package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.ClimaEstado;
import com.obarra.forecast.bean.Informe;
import com.obarra.forecast.bean.Periodo;
import com.obarra.forecast.mapper.ClimaMapper;
import com.obarra.forecast.mapper.DiaMapper;
import com.obarra.forecast.mapper.entity.DiaEntity;
import com.obarra.forecast.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.obarra.forecast.enums.ClimaTipos.IDEAL;
import static com.obarra.forecast.enums.ClimaTipos.IDEAL_I;
import static com.obarra.forecast.enums.ClimaTipos.LLUVIA;
import static com.obarra.forecast.enums.ClimaTipos.LLUVIA_I;
import static com.obarra.forecast.enums.ClimaTipos.SEQUIA;
import static com.obarra.forecast.enums.ClimaTipos.SEQUIA_I;

@Service
public class ClimaServiceImpl implements ClimaService {

    private final ClimaMapper climaMapper;
    private final DiaMapper diaMapper;

    /**
     * {@inheritDoc}
     * @param climaMapper
     * @param diaMapper
     */
    @Autowired
    public ClimaServiceImpl(final ClimaMapper climaMapper,
                            final DiaMapper diaMapper) {
        this.climaMapper = climaMapper;
        this.diaMapper = diaMapper;
    }



    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Informe getPeriodoLLuvia() {
        final List<DiaEntity> dias = diaMapper
                .findDiasByClima(LLUVIA_I.getValorI());
        final DiaEntity diaMaximaIntensidad = diaMapper.findDiaMaximaIntensidad();

        final Informe informe = generarInformedeClima(LLUVIA.getValorS(), dias);

        final StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(informe.getTitulo())
                .append(" El pico máximo de lluvia será el día: ")
                .append(diaMaximaIntensidad.getNumero());
        informe.setTitulo(stringBuilder.toString());

        return informe;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Informe getPeriodosSequia() {
        final List<DiaEntity> dias = diaMapper.findDiasByClima(SEQUIA_I.getValorI());

        return this.generarInformedeClima(SEQUIA.getValorS(), dias);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Informe getCondicionesOptimas() {
        final List<DiaEntity> dias = diaMapper.findDiasByClima(IDEAL_I.getValorI());

        return this.generarInformedeClima(IDEAL.getValorS(), dias);
    }

    private Informe generarInformedeClima(final String tipoClima, final List<DiaEntity> dias) {
        final Informe informe = new Informe();

        long diaAnterior = -1;
        long contadorPeriodos = 0;
        Periodo periodo = null;
        for (final DiaEntity dia : dias) {
            if (diaAnterior == -1 || (diaAnterior + 1) != dia.getNumero()) {
                contadorPeriodos++;
                periodo = new Periodo();
                periodo.setValue(contadorPeriodos);
                periodo.setClimaEstados(new ArrayList<ClimaEstado>());
                if (informe.getListaPeriodos() == null){
                    informe.setListaPeriodos(new ArrayList<>());
                }
                informe.getListaPeriodos().add(periodo);

                ClimaEstado clima = new ClimaEstado();
                clima.setClima(tipoClima);
                clima.setDia(dia.getNumero());
                periodo.getClimaEstados().add(clima);
            } else {
                ClimaEstado clima = new ClimaEstado();
                clima.setClima(tipoClima);
                clima.setDia(dia.getNumero());
                if (informe.getListaPeriodos() == null){
                    informe.setListaPeriodos(new ArrayList<>());
                }
                periodo.getClimaEstados().add(clima);
            }
            diaAnterior = dia.getNumero();
        }

        informe.setTitulo("Habrá " + contadorPeriodos
                + " períodos de " + tipoClima + ".");

        return informe;
    }
}
