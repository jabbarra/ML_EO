package com.obarra.forecast.controller;

import com.obarra.forecast.bean.Informe;
import com.obarra.forecast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast")
public final class ForecastController {

    /**
     * Forecast Service.
     */
    private final ForecastService forecastService;

    /**
     * Constructor.
     * @param forecastService
     */
    @Autowired
    public ForecastController(final ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/drought")
    public Informe getDrought() {
        return forecastService.getPeriodosSequia();
    }

    @GetMapping("/rain")
    public Informe getRain() {
        return forecastService.getPeriodoLLuvia();
    }

    @GetMapping("/optimum")
    public Informe getOptimum() {
        return forecastService.getCondicionesOptimas();
    }
}
