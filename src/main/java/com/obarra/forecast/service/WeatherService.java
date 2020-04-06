package com.obarra.forecast.service;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;

import java.util.List;

public interface WeatherService {
    Weather findById(Long id);
    List<Weather> findAll();
    WeatherDTO findByDay(Long day);
}
