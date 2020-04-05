package com.obarra.forecast.controller;

import com.obarra.forecast.bean.ClimaEstado;
import com.obarra.forecast.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public final class WeatherController {

    /**
     * Weather Service.
     */
    private final ClimaService climaService;

    /**
     * Constructor.
     * @param climaService
     */
    @Autowired
    public WeatherController(final ClimaService climaService) {
        this.climaService = climaService;
    }

    /**
     * Finds the weather of day passed by parameter.
     * @param day Numeric value of de day
     * @return Weather of day passed by parameter
     */
    @GetMapping
    public ClimaEstado findByDay(final @RequestParam("day") Long day) {
        return climaService.getClimaDelDia(day);
    }
}
