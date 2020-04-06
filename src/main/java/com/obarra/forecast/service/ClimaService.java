package com.obarra.forecast.service;

import com.obarra.forecast.bean.Informe;


public interface ClimaService {

    Informe getPeriodosSequia();

    Informe getPeriodoLLuvia();

    Informe getCondicionesOptimas();
}
