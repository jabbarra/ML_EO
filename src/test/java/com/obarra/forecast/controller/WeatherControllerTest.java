package com.obarra.forecast.controller;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;
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

class WeatherControllerTest {
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService = mock(WeatherService.class);
    }

    @Test
    void findByDayWhenItIsOK() {
        WeatherDTO weatherDTO = new WeatherDTO();
        doReturn(weatherDTO).when(weatherService).findByDay(anyLong());
        WeatherController weatherController = new WeatherController(weatherService);

        WeatherDTO result = weatherController.findByDay(1L);

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(WeatherDTO.class, result.getClass()));
        verify(weatherService).findByDay(anyLong());
    }

    @Test
    void findByDayWhenDayIsNull() {
        WeatherDTO weatherDTO = new WeatherDTO();
        doReturn(null).when(weatherService).findByDay(null);
        WeatherController weatherController = new WeatherController(weatherService);

        WeatherDTO result = weatherController.findByDay(null);

        assertNull(result);
        verify(weatherService).findByDay(null);
    }

    @Test
    void findByDayWhenThereIsNullPointerException() {
        doThrow(NullPointerException.class).when(weatherService).findByDay(anyLong());
        WeatherController weatherController = new WeatherController(weatherService);

        assertThrows(NullPointerException.class,
                () -> weatherController.findByDay(1L));
        verify(weatherService).findByDay(anyLong());
    }

    @Test
    void listWhenItIsOK() {
        List<Weather> weathers = Arrays.asList(new Weather());
        doReturn(weathers).when(weatherService).findAll();
        WeatherController weatherController = new WeatherController(weatherService);

        List<Weather> result = weatherController.list();
        List<Weather> expected = Arrays.asList(new Weather());

        assertAll(() -> assertNotNull(result),
                () -> assertIterableEquals(expected, result));
        verify(weatherService).findAll();
    }

    @Test
    void listWhenThereIsIndexOutOfBoundsException() {
        List<Weather> weathers = Arrays.asList(new Weather());
        doThrow(IndexOutOfBoundsException.class).when(weatherService).findAll();
        WeatherController weatherController = new WeatherController(weatherService);

        List<Weather> expected = Arrays.asList(new Weather());

        assertThrows(IndexOutOfBoundsException.class,
                () -> weatherController.list());
        verify(weatherService).findAll();
    }
}