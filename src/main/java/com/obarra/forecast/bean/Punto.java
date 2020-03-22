package com.obarra.forecast.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Punto {
    private BigDecimal axisX;
    private BigDecimal axisY;
    private BigDecimal axisZ;

}
