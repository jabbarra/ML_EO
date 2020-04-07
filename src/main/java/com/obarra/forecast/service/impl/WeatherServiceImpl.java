package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.mapper.WeatherMapper;
import com.obarra.forecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    /**
     * This interacts with data base and maps the results.
     */
    private final WeatherMapper weatherMapper;

    /**
     * Constructor.
     *
     * @param weatherMapper
     */
    @Autowired
    public WeatherServiceImpl(final WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
    }

    @Override
    public Weather findById(Long id) {
        return weatherMapper.findById(id);
    }

    /**
     * {@inheritDoc}
     *
     * @return List of all Weather.
     */
    @Override
    public List<Weather> findAll() {
        return weatherMapper.findWeather();
    }

    /**
     * {@inheritDoc}
     *
     * @param day
     * @return A day with its weather.
     */
    @Override
    public WeatherDTO findByDay(final Long day) {
        final WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setDay(day);

        final Weather weatherBD = weatherMapper.findByDia(day);
        weatherDTO.setWeather(weatherBD);

        return weatherDTO;
    }
}
