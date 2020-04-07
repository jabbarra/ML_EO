package com.obarra.forecast.dto;

import lombok.Data;

@Data
public class RainReportDTO extends ReportDTO {
    /**
     * Day of the maximum intensity rain.
     */
    private Long maximumIntensityDay;
}
