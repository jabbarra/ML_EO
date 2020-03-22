package ar.com.mleo.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Punto {
    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal z;

}
