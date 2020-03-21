package ar.com.mleo.controller;

import ar.com.mleo.bean.Clima;
import ar.com.mleo.bean.ClimaEstado;
import ar.com.mleo.bean.Informe;
import ar.com.mleo.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/clima")
public class ClimaController {


    @Autowired
    private ClimaService climaService;


    @GetMapping("/test")
    public String test() {
        return "It's ok";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ClimaEstado getClimaByDia(@RequestParam(value = "dia", required = true) Long dia) {
        ClimaEstado climaEstado = climaService.getClimaDelDia(dia);
        return climaEstado;
    }

    @RequestMapping(value = "/climas", method = RequestMethod.GET)
    public List<Clima> getClimas() {
        List<Clima> climas = new ArrayList<Clima>();
        try {
            climas = climaService.getClimas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return climas;
    }

    @RequestMapping(value = "/sequias", method = RequestMethod.GET)
    public Informe getSequias() {
        Informe informe = new Informe();
        try {
            informe = climaService.getPeriodosSequia();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informe;
    }

    @RequestMapping(value = "/lluvias", method = RequestMethod.GET)
    public Informe getLLuvias() {
        Informe informe = new Informe();
        try {
            informe = climaService.getPeriodoLLuvia();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informe;
    }

    @RequestMapping(value = "/ideales", method = RequestMethod.GET)
    public Informe getIdeales() {
        Informe informe = new Informe();
        try {
            informe = climaService.getCondicionesOptimas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informe;
    }

}
