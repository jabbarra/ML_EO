package ar.com.mleo.service;

import ar.com.mleo.bean.Clima;
import ar.com.mleo.bean.ClimaEstado;
import ar.com.mleo.bean.Informe;

import java.util.List;


public interface ClimaService {
    List<Clima> getClimas();

    ClimaEstado getClimaDelDia(Long dia);

    Informe getPeriodosSequia();

    Informe getPeriodoLLuvia();

    Informe getCondicionesOptimas();
}
