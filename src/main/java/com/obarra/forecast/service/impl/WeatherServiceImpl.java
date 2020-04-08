package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.mapper.WeatherMapper;
import com.obarra.forecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        final Weather weather = weatherMapper.findByDay(day);
        if(Objects.isNull(weather)) {
            return new WeatherDTO();
        }

        final WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setWeather(weather);
        weatherDTO.setDay(day);

        return weatherDTO;
    }
}
