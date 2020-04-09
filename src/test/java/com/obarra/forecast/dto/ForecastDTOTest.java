package com.obarra.forecast.dto;

import com.obarra.forecast.bean.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForecastDTOTest {

    @Test
    void testHashCode() {
        ForecastDTO forecastDTO = new ForecastDTO();
        forecastDTO.setQuantityPeriods(Long.MAX_VALUE);
        Weather weather = new Weather();
        weather.setId(Long.MAX_VALUE);
        weather.setName("Something");
        forecastDTO.setWeather(weather);

        ForecastDTO forecastDTOOther = new ForecastDTO();
        forecastDTOOther.setQuantityPeriods(Long.MAX_VALUE);
        weather = new Weather();
        weather.setId(Long.MAX_VALUE);
        weather.setName("Something");
        forecastDTOOther.setWeather(weather);

        assertTrue(forecastDTO.equals(forecastDTOOther));
        assertTrue(forecastDTO.hashCode() == forecastDTOOther.hashCode());
    }

    @Test
    void testToString() {
        ForecastDTO forecastDTO = new ForecastDTO();
        forecastDTO.setQuantityPeriods(1L);
        assertEquals("ForecastDTO{weather=null, quantityPeriods=1}",
                forecastDTO.toString());
    }
}