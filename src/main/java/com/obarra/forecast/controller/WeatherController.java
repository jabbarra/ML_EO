package com.obarra.forecast.controller;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public final class WeatherController {

    /**
     * Weather Service.
     */
    private final WeatherService weatherService;

    /**
     * Constructor.
     *
     * @param weatherService
     */
    @Autowired
    public WeatherController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Finds the weather of day passed by parameter.
     *
     * @param day Numeric value of de day
     * @return A day with its weather
     */
    @GetMapping
    public WeatherDTO findByDay(final @RequestParam("day") Long day) {
        return weatherService.findByDay(day);
    }

    /**
     * @return All weathers
     */
    @GetMapping("/list")
    public List<Weather> list() {
        return weatherService.findAll();
    }
}
