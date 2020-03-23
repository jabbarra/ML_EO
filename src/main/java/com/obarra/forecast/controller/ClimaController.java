package com.obarra.forecast.controller;

import com.obarra.forecast.bean.Clima;
import com.obarra.forecast.bean.ClimaEstado;
import com.obarra.forecast.bean.Informe;
import com.obarra.forecast.service.ClimaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/clima")
public class ClimaController {

    private final ClimaService climaService;

    @Autowired
    public ClimaController(final ClimaService climaService){
        this.climaService = climaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ClimaEstado getClimaByDia(
            final @RequestParam(value = "dia", required = true) Long dia) {
        return climaService.getClimaDelDia(dia);
    }

    @RequestMapping(value = "/climas", method = RequestMethod.GET)
    public List<Clima> getClimas() {
        return climaService.getClimas();
    }

    @RequestMapping(value = "/sequias", method = RequestMethod.GET)
    public Informe getSequias() {
        return  climaService.getPeriodosSequia();
    }

    @RequestMapping(value = "/lluvias", method = RequestMethod.GET)
    public Informe getLLuvias() {
        return climaService.getPeriodoLLuvia();
    }

    @RequestMapping(value = "/ideales", method = RequestMethod.GET)
    public Informe getIdeales() {
        return climaService.getCondicionesOptimas();
    }
}
