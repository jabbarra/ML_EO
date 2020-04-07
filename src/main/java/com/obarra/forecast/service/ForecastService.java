package com.obarra.forecast.service;

import com.obarra.forecast.dto.ForecastDTO;

public interface ForecastService {
    ForecastDTO getDroughtPeriods();

    ForecastDTO getRainPeriods();

    ForecastDTO getOptimumPeriods();
}
