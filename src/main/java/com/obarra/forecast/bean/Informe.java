package com.obarra.forecast.bean;

import lombok.Data;
import java.util.List;

@Data
public class Informe {
    private String titulo;
    private List<Periodo> listaPeriodos;
}
