package com.obarra.forecast.service;

import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.dto.DayDTO;

import java.util.List;

public interface WeatherService {
    List<WeatherDTO> findAll();
    DayDTO findByDay(Long day);
}
