package com.obarra.forecast.mapper;

import com.obarra.forecast.dto.WeatherDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface WeatherMapper {

    /**
     * Finds all Weather, and maps to DTO
     * @return List of Weather
     */
    @Select("select id,nombre as name from public.climas order by nombre ASC")
    List<WeatherDTO> findWeather();
}
