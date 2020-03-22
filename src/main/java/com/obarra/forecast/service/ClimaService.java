package com.obarra.forecast.service;

import com.obarra.forecast.bean.Clima;
import com.obarra.forecast.bean.ClimaEstado;
import com.obarra.forecast.bean.Informe;

import java.util.List;


public interface ClimaService {
    List<Clima> getClimas();

    ClimaEstado getClimaDelDia(Long dia);

    Informe getPeriodosSequia();

    Informe getPeriodoLLuvia();

    Informe getCondicionesOptimas();
}
