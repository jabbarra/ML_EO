package com.obarra.forecast.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Punto {
    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal z;

}
