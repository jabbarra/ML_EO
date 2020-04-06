package com.obarra.forecast.service.impl;

import com.obarra.forecast.dto.DayDTO;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.mapper.WeatherMapper;
import com.obarra.forecast.mapper.DiaMapper;
import com.obarra.forecast.mapper.entity.DiaEntity;
import com.obarra.forecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    private WeatherMapper climaMapper;
    private DiaMapper diaMapper;

    @Autowired
    public WeatherServiceImpl(final WeatherMapper climaMapper,
                              final DiaMapper diaMapper) {
        this.climaMapper = climaMapper;
        this.diaMapper = diaMapper;
    }

    /**
     * {@inheritDoc}
     * @return List of all Weather.
     */
    @Override
    public List<WeatherDTO> findAll() {
        return climaMapper.findWeather();
    }

    /**
     * {@inheritDoc}
     * @param day
     * @return A day with its weather.
     */
    @Override
    public DayDTO findByDay(final Long day) {
        final DiaEntity diaEntity = diaMapper.findByDia(day);
        final DayDTO dayDTO = new DayDTO();
        if (diaEntity != null) {
            dayDTO.setDay(diaEntity.getNumero());

            final WeatherDTO weatherDTO = new WeatherDTO();
            weatherDTO.setName(diaEntity.getClima());

            dayDTO.setWeather(weatherDTO);
        }

        return dayDTO;
    }
}
