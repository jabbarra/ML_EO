package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.mapper.WeatherMapper;
import com.obarra.forecast.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WeatherServiceImplTest {

    private WeatherMapper weatherMapper;

    @BeforeEach
    void setUp() {
        weatherMapper = mock(WeatherMapper.class);
    }
    @Test
    void findAll() {

    }

    @Test
    void findByDayWhenItIsOK() {
        Weather weather = new Weather();
        weather.setId(1L);
        weather.setName("Rain");
        doReturn(weather).when(weatherMapper).findByDay(256L);
        WeatherService weatherService = new WeatherServiceImpl(weatherMapper);

        WeatherDTO result = weatherService.findByDay(256L);

        WeatherDTO expected = new WeatherDTO();
        expected.setDay(256L);
        expected.setWeather(weather);

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(WeatherDTO.class, result.getClass()),
                () -> assertEquals(expected, result));
        verify(weatherMapper).findByDay(256L);
    }

    @Test
    void findByDayWhenThereIsNotWeatherForADay() {
        doReturn(null).when(weatherMapper).findByDay(anyLong());
        WeatherService weatherService = new WeatherServiceImpl(weatherMapper);

        WeatherDTO result = weatherService.findByDay(256L);

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(WeatherDTO.class, result.getClass()),
                () -> assertEquals(new WeatherDTO(), result));
        verify(weatherMapper).findByDay(anyLong());
    }

    @Test
    void findByDayWhenTheDayIsNull() {
        doReturn(null).when(weatherMapper).findByDay(null);
        WeatherService weatherService = new WeatherServiceImpl(weatherMapper);

        WeatherDTO result = weatherService.findByDay(null);

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(WeatherDTO.class, result.getClass()),
                () -> assertEquals(new WeatherDTO(), result));
        verify(weatherMapper).findByDay(null);
    }
}