package com.obarra.forecast.controller;

import com.obarra.forecast.bean.Informe;
import com.obarra.forecast.service.ClimaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/clima")
public final class ClimaController {

    private final ClimaService climaService;

    @Autowired
    public ClimaController(final ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping(value = "/droughts")
    public Informe getSequias() {
        return climaService.getPeriodosSequia();
    }

    @GetMapping(value = "/rains")
    public Informe getLLuvias() {
        return climaService.getPeriodoLLuvia();
    }

    @GetMapping(value = "/idealDays")
    public Informe getIdeales() {
        return climaService.getCondicionesOptimas();
    }
}
