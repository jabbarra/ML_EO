package com.obarra.forecast.bean;

import lombok.Data;

@Data
public class Weather {
    /**
     * Identification of weather
     */
    private String id;

    /**
     * Name of weather.
     */
    private String name;
}
