package com.obarra.forecast.dto;

import com.obarra.forecast.bean.Weather;
import java.util.Objects;

public class ForecastDTO {
    private Weather weather;
    private Long quantityPeriods;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForecastDTO reportDTO = (ForecastDTO) o;
        return Objects.equals(weather, reportDTO.weather) &&
                Objects.equals(quantityPeriods, reportDTO.quantityPeriods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weather, quantityPeriods);
    }

    @Override
    public String toString() {
        return "ForecastDTO{" +
                "weather=" + weather +
                ", quantityPeriods=" + quantityPeriods +
                '}';
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Long getQuantityPeriods() {
        return quantityPeriods;
    }

    public void setQuantityPeriods(Long quantityPeriods) {
        this.quantityPeriods = quantityPeriods;
    }
}
