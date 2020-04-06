package com.obarra.forecast.dto;

import lombok.Data;

@Data
public class DayDTO {
    /**
     * Numeric value of the day.
     */
    private Long day;
    /**
     * Weather of the day.
     */
    private WeatherDTO weather;
}
