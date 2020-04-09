package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.ForecastDTO;
import com.obarra.forecast.dto.ForecastRainDTO;
import com.obarra.forecast.mapper.DayMapper;
import com.obarra.forecast.mapper.WeatherMapper;
import com.obarra.forecast.service.ForecastService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class ForecastServiceImplTest {
    private DayMapper dayMapper;
    private WeatherMapper weatherMapper;
    private Weather weather;
    private ForecastDTO expectedForecastDTO;

    @BeforeEach
    void setUp() {
        weatherMapper = mock(WeatherMapper.class);
        dayMapper = mock(DayMapper.class);

        weather = new Weather();
        weather.setName("SomeWeather");
        weather.setId(9L);

        expectedForecastDTO = new ForecastDTO();
        expectedForecastDTO.setQuantityPeriods(10L);
        Weather expectedWeather = new Weather();
        expectedWeather.setName("SomeWeather");
        expectedWeather.setId(9L);
        expectedForecastDTO.setWeather(weather);
    }

    @Test
    void getDroughtPeriodsItIsOk() {
        doReturn(weather).when(weatherMapper).findById(2L);
        doReturn(10L).when(dayMapper).countPeriodsOfWeatherType(2L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        ForecastDTO result = forecastService.getDroughtPeriods();

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(expectedForecastDTO, result));
        verify(weatherMapper).findById(2L);
        verify(dayMapper).countPeriodsOfWeatherType(2L);
    }

    @Test
    void getDroughtPeriodsWhenWeatherDoesNotExist() {
        doReturn(null).when(weatherMapper).findById(2L);
        doReturn(0L).when(dayMapper).countPeriodsOfWeatherType(2L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        ForecastDTO result = forecastService.getDroughtPeriods();

        expectedForecastDTO.setWeather(null);
        expectedForecastDTO.setQuantityPeriods(0L);
        assertAll(() -> assertNotNull(result),
                () -> assertEquals(expectedForecastDTO, result));
        verify(weatherMapper).findById(2L);
        verify(dayMapper).countPeriodsOfWeatherType(2L);
    }

    @Test
    void getDroughtPeriodsWhenWeatherMapperThrowsException() {
        doThrow(RuntimeException.class).when(weatherMapper).findById(2L);
        doReturn(0L).when(dayMapper).countPeriodsOfWeatherType(2L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        assertThrows(RuntimeException.class, () -> forecastService.getDroughtPeriods());
        verify(weatherMapper).findById(2L);
        verify(dayMapper, never()).countPeriodsOfWeatherType(2L);
    }

    @Test
    void getDroughtPeriodsWhenDayMapperThrowsException() {
        doReturn(weather).when(weatherMapper).findById(2L);
        doThrow(RuntimeException.class).when(dayMapper).countPeriodsOfWeatherType(2L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        assertThrows(RuntimeException.class, () -> forecastService.getDroughtPeriods());
        verify(weatherMapper).findById(2L);
        verify(dayMapper).countPeriodsOfWeatherType(2L);
    }

    @Test
    void getOptimumPeriodsItIsOk() {
        doReturn(weather).when(weatherMapper).findById(3L);
        doReturn(10L).when(dayMapper).countPeriodsOfWeatherType(3L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        ForecastDTO result = forecastService.getOptimumPeriods();

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(expectedForecastDTO, result));
        verify(weatherMapper).findById(3L);
        verify(dayMapper).countPeriodsOfWeatherType(3L);
    }

    @Test
    void getOptimumPeriodsWhenWeatherDoesNotExist() {
        doReturn(null).when(weatherMapper).findById(3L);
        doReturn(0L).when(dayMapper).countPeriodsOfWeatherType(3L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        ForecastDTO result = forecastService.getOptimumPeriods();

        expectedForecastDTO.setWeather(null);
        expectedForecastDTO.setQuantityPeriods(0L);
        assertAll(() -> assertNotNull(result),
                () -> assertEquals(expectedForecastDTO, result));
        verify(weatherMapper).findById(3L);
        verify(dayMapper).countPeriodsOfWeatherType(3L);
    }

    @Test
    void getOptimumPeriodsWhenWeatherMapperThrowsException() {
        doThrow(RuntimeException.class).when(weatherMapper).findById(3L);
        doReturn(0L).when(dayMapper).countPeriodsOfWeatherType(3L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        assertThrows(RuntimeException.class, () -> forecastService.getOptimumPeriods());
        verify(weatherMapper).findById(3L);
        verify(dayMapper, never()).countPeriodsOfWeatherType(3L);
    }

    @Test
    void getOptimumPeriodsWhenDayMapperThrowsException() {
        doReturn(weather).when(weatherMapper).findById(3L);
        doThrow(RuntimeException.class).when(dayMapper).countPeriodsOfWeatherType(3L);
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        assertThrows(RuntimeException.class, () -> forecastService.getOptimumPeriods());
        verify(weatherMapper).findById(3L);
        verify(dayMapper).countPeriodsOfWeatherType(3L);
    }

    @Test
    void getRainPeriodsItIsOk() {
        doReturn(weather).when(weatherMapper).findById(1L);
        doReturn(10L).when(dayMapper).countPeriodsOfWeatherType(1L);
        doReturn(91L).when(dayMapper).findMaximumRainIntensityDay();
        ForecastService forecastService = new ForecastServiceImpl(weatherMapper, dayMapper);

        ForecastDTO result =  forecastService.getRainPeriods();

        ForecastRainDTO expected = new ForecastRainDTO();
        expected.setQuantityPeriods(expectedForecastDTO.getQuantityPeriods());
        expected.setWeather(expectedForecastDTO.getWeather());
        expected.setMaximumIntensityDay(91L);

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(ForecastRainDTO.class, result.getClass()),
                () -> assertEquals(expected, result));
        verify(weatherMapper).findById(1L);
        verify(dayMapper).countPeriodsOfWeatherType(1L);
        verify(dayMapper).findMaximumRainIntensityDay();
    }
}