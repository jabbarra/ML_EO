package com.obarra.forecast.dto;

import lombok.Data;

@Data
public class ForecastRainDTO extends ForecastDTO {
    /**
     * Day of the maximum intensity rain.
     */
    private Long maximumIntensityDay;
}
