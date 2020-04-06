package com.obarra.forecast.service;

import com.obarra.forecast.bean.Informe;


public interface ForecastService {

    Informe getPeriodosSequia();

    Informe getPeriodoLLuvia();

    Informe getCondicionesOptimas();
}
