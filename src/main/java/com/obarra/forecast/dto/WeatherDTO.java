package com.obarra.forecast.dto;

import com.obarra.forecast.bean.Weather;
import lombok.Data;

/**
 * This class represents Information of the weather of a day.
 */
@Data
public class WeatherDTO {
    /**
     * Numeric value of the day.
     */
    private Long day;
    /**
     * Weather of the day.
     */
    private Weather weather;
}
