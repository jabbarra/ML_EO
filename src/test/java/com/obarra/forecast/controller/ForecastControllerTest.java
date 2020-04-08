package com.obarra.forecast.controller;

import com.obarra.forecast.dto.ForecastDTO;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.service.ForecastService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ForecastControllerTest {
    private ForecastService forecastService;

    @BeforeEach
    void setUp() {
        forecastService = mock(ForecastService.class);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getDroughtWhenItIsOK() {
        ForecastDTO forecastDTO = new ForecastDTO();
        doReturn(forecastDTO).when(forecastService).getDroughtPeriods();
        ForecastController forecastController = new ForecastController(forecastService);

        ForecastDTO result = forecastController.getDrought();

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(ForecastDTO.class, result.getClass()));
        verify(forecastService).getDroughtPeriods();
    }

    @Test
    void getDroughtWhenThereIsNullPointerException() {
        doThrow(NullPointerException.class).when(forecastService).getDroughtPeriods();
        ForecastController forecastController = new ForecastController(forecastService);
        assertThrows(NullPointerException.class, () -> forecastController.getDrought());
    }

    @Test
    void getRainWhenItIsOK() {
        ForecastDTO forecastDTO = new ForecastDTO();
        doReturn(forecastDTO).when(forecastService).getRainPeriods();
        ForecastController forecastController = new ForecastController(forecastService);

        ForecastDTO result = forecastController.getRain();

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(ForecastDTO.class, result.getClass()));
        verify(forecastService).getRainPeriods();
    }

    @Test
    void getOptimumWhenItIsOK() {
        ForecastDTO forecastDTO = new ForecastDTO();
        doReturn(forecastDTO).when(forecastService).getOptimumPeriods();
        ForecastController forecastController = new ForecastController(forecastService);

        ForecastDTO result = forecastController.getOptimum();

        assertAll(() -> assertNotNull(result),
                () -> assertEquals(ForecastDTO.class, result.getClass()));
        verify(forecastService).getOptimumPeriods();
    }

    @Test
    void geRainWhenThereIsNullPointerException() {
        doThrow(NullPointerException.class).when(forecastService).getRainPeriods();
        ForecastController forecastController = new ForecastController(forecastService);
        assertThrows(NullPointerException.class, () -> forecastController.getRain());
    }

    @Test
    void getOptimumWhenThereIsNullPointerException() {
        doThrow(NullPointerException.class).when(forecastService).getOptimumPeriods();
        ForecastController forecastController = new ForecastController(forecastService);
        assertThrows(NullPointerException.class, () -> forecastController.getOptimum());
    }
}