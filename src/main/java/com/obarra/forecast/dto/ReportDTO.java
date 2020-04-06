package com.obarra.forecast.dto;

import com.obarra.forecast.bean.Weather;
import lombok.Data;

@Data
public class ReportDTO {
    private Weather weather;
    private Long quantityPeriods;
}
