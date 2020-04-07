package com.obarra.forecast.service;

import com.obarra.forecast.dto.ReportDTO;

public interface ForecastService {
    ReportDTO getDroughtPeriods();

    ReportDTO getRainPeriods();

    ReportDTO getOptimumPeriods();
}
