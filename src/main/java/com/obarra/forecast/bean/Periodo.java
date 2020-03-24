package com.obarra.forecast.bean;

import lombok.Data;

import java.util.List;

@Data
public class Periodo {
    private Long value;
    private List<ClimaEstado> climaEstados;
}
