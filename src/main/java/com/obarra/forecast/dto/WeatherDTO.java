package com.obarra.forecast.dto;

import lombok.Data;

@Data
public class WeatherDTO {
    /**
     * Identification of weather
     */
    private String id;

    /**
     * Name of weather.
     */
    private String name;
}
