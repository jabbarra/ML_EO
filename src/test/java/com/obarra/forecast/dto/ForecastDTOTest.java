package com.obarra.forecast.dto;

import com.obarra.forecast.bean.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForecastDTOTest {

    @Test
    void equalWhenAreEqual() {
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

        ForecastDTO forecastDTOOtherOther = new ForecastDTO();
        forecastDTOOtherOther.setQuantityPeriods(Long.MAX_VALUE);
        weather = new Weather();
        weather.setId(Long.MAX_VALUE);
        weather.setName("Something");
        forecastDTOOtherOther.setWeather(weather);

        assertTrue(forecastDTO.equals(forecastDTO));

        assertTrue(forecastDTO.equals(forecastDTOOther));

        assertTrue(forecastDTOOther.equals(forecastDTOOtherOther));
        assertTrue(forecastDTO.equals(forecastDTOOtherOther));
    }

    @Test
    void equalWhenAreNotEqual() {
        ForecastDTO forecastDTO = new ForecastDTO();
        forecastDTO.setQuantityPeriods(Long.MAX_VALUE);
        Weather weather = new Weather();
        weather.setId(Long.MAX_VALUE);
        weather.setName("Something");
        forecastDTO.setWeather(weather);

        assertFalse(forecastDTO.equals(null));
        assertFalse(forecastDTO.equals(Long.MIN_VALUE));

        ForecastDTO forecastDTODifferent = new ForecastDTO();
        forecastDTODifferent.setQuantityPeriods(Long.MIN_VALUE);
        weather = new Weather();
        weather.setId(Long.MAX_VALUE);
        weather.setName("Something");
        forecastDTODifferent.setWeather(weather);
        assertFalse(forecastDTO.equals(forecastDTODifferent));


        forecastDTODifferent.setQuantityPeriods(Long.MAX_VALUE);
        weather = new Weather();
        weather.setId(Long.MIN_VALUE);
        weather.setName("Something");
        forecastDTODifferent.setWeather(weather);
        assertFalse(forecastDTO.equals(forecastDTODifferent));
    }

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