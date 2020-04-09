package com.obarra.forecast.mapper;

import com.obarra.forecast.bean.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeatherMapper {
    /**
     * Finds all Weather, and maps to DTO.
     *
     * @return List of Weather.
     */
    @Select("select weather_type_id id, name from weather_type order by name ASC")
    List<Weather> findWeathers();

    @Select("select t.weather_type_id id, "
            + "t.name "
            + "from weather_day d "
            + "inner join weather_type t on d.weather_type_id = t.weather_type_id "
            + "where d.day = #{day}")
    Weather findByDay(@Param("day") Long day);

    @Select("select t.weather_type_id id, "
            + "t.name "
            + "from weather_type t "
            + "where t.weather_type_id = #{id}")
    Weather findById(@Param("id") Long id);
}
