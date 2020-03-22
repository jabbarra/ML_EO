package com.obarra.forecast.bean;

import lombok.Data;

import java.util.List;

@Data
public class Periodo {
    private Long periodo;
    private List<ClimaEstado> listaClimas;
}
