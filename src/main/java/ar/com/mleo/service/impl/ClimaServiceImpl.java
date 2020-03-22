package ar.com.mleo.service.impl;

import ar.com.mleo.bean.Clima;
import ar.com.mleo.bean.ClimaEstado;
import ar.com.mleo.bean.Informe;
import ar.com.mleo.bean.Periodo;
import ar.com.mleo.mapper.ClimaMapper;
import ar.com.mleo.mapper.DiaMapper;
import ar.com.mleo.mapper.entity.ClimaEntity;
import ar.com.mleo.mapper.entity.DiaEntity;
import ar.com.mleo.service.ClimaService;
import ar.com.mleo.utils.ClimaTipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimaServiceImpl implements ClimaService {

    @Autowired
    private ClimaMapper climaMapper;

    @Autowired
    private DiaMapper diaMapper;

    @Override
    public List<Clima> getClimas() {
        List<ClimaEntity> climasE = climaMapper.findClimas();

        List<Clima> climas = new ArrayList<Clima>();
        Clima c = new Clima();
        for (ClimaEntity climaEntity : climasE) {
            c = new Clima();
            c.setNombre(climaEntity.getNombre());
            climas.add(c);
        }

        return climas;
    }

    @Override
    public ClimaEstado getClimaDelDia(final Long dia) {
        ClimaEstado climaEstado = new ClimaEstado();
        climaEstado.setClima(ClimaTipos.INDEFINIDO.getValorS());
        climaEstado.setDia(dia);

        DiaEntity diaE = diaMapper.findByDia(dia);
        if (diaE != null) {
            climaEstado.setClima(diaE.getClima());
            climaEstado.setDia(diaE.getNumero());
        }
        return climaEstado;
    }

    @Override
    public Informe getPeriodoLLuvia() {
        List<DiaEntity> dias = diaMapper
                .findDiasByClima(ClimaTipos.LLUVIA_I.getValorI());
        DiaEntity diaMaximaIntensidad = diaMapper.findDiaMaximaIntensidad();

        Informe informe = generarInformedeClima(ClimaTipos.LLUVIA.getValorS(), dias);

        String titulo = informe.getTitulo();
        titulo = titulo + " El pico máximo de lluvia será el día: "
                + diaMaximaIntensidad.getNumero();
        informe.setTitulo(titulo);

        return informe;
    }


    @Override
    public Informe getPeriodosSequia() {
        List<DiaEntity> dias = diaMapper.findDiasByClima(ClimaTipos.SEQUIA_I.getValorI());

        return this.generarInformedeClima(ClimaTipos.SEQUIA.getValorS(), dias);
    }

    @Override
    public Informe getCondicionesOptimas() {
        List<DiaEntity> dias = diaMapper.findDiasByClima(ClimaTipos.IDEAL_I.getValorI());

        return this.generarInformedeClima(ClimaTipos.IDEAL.getValorS(), dias);
    }

    private Informe generarInformedeClima(final String tipoClima, final List<DiaEntity> dias) {
        Informe informe = new Informe();

        ClimaEstado clima = null;
        long diaAnterior = -1;
        long contadorPeriodos = 0;

        Periodo periodo = null;

        for (int i = 0; i < dias.size(); i++) {
            DiaEntity dia = dias.get(i);
            if (diaAnterior == -1 || (diaAnterior + 1) != dia.getNumero()) {
                contadorPeriodos++;
                periodo = new Periodo();
                periodo.setPeriodo(contadorPeriodos);
                periodo.setListaClimas(new ArrayList<ClimaEstado>());
                informe.getListaPeriodos().add(periodo);

                clima = new ClimaEstado();
                clima.setClima(tipoClima);
                clima.setDia(dia.getNumero());
                periodo.getListaClimas().add(clima);
            } else {
                clima = new ClimaEstado();
                clima.setClima(tipoClima);
                clima.setDia(dia.getNumero());
                periodo.getListaClimas().add(clima);
            }
            diaAnterior = dia.getNumero();
        }

        informe.setTitulo("Habrá " + contadorPeriodos
                + " períodos de " + tipoClima + ".");

        return informe;
    }

}
