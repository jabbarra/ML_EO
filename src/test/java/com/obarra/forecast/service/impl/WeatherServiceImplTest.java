package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.mapper.WeatherMapper;
import com.obarra.forecast.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WeatherServiceImplTest {
    private WeatherMapper weatherMapper;
    private Weather weather;
    private WeatherDTO weatherDTOExpected;

    @BeforeEach
    void setUp() {
        weatherMapper = mock(WeatherMapper.class);
        weather = new Weather();
        weather.setId(1L);
        weather.setName("Rain");
        weatherDTOExpected = new WeatherDTO();
        weatherDTOExpected.setDay(256L);
        weatherDTOExpected.setWeather(weather);
    }

    @Test
    void findAllWhenItIsOK() {
        doReturn(Arrays.asList(weather)).when(weatherMapper).findWeathers();
        WeatherService weatherService = new WeatherServiceImpl(weatherMapper);

        List<Weather> result = weatherService.findAll();

        assertAll(() -> assertNotNull(result),
                () -> assertIterableEquals(Arrays.asList(weather), result));
        verify(weatherMapper).findWeathers();
    }

    @Test
    void findAllWhenThereIsRuntimeException() {
        doThrow(RuntimeException.class).when(weatherMapper).findWeathers();
        WeatherService weatherService = new WeatherServiceImpl(weatherMapper);

        assertThrows(RuntimeException.class,
                () -> weatherService.findAll());
        verify(weatherMapper).findWeathers();
    }

    @Test
    void findByDayWhenItIsOK() {
        doReturn(weather).when(weatherMapper).findByDay(256L);
        WeatherService weatherService = new WeatherServiceImpl(weatherMapper);

        WeatherDTO result = weatherService.findByDay(256L);

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(WeatherDTO.class, result.getClass()),
                () -> assertEquals(weatherDTOExpected, result));
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

    @Test
    void findByDayWhenThereIsRuntimeException() {
        doThrow(RuntimeException.class).when(weatherMapper).findByDay(anyLong());
        WeatherService weatherService = new WeatherServiceImpl(weatherMapper);
        assertThrows(RuntimeException.class,
                () -> weatherService.findByDay(1L));
    }
}