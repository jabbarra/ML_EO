package com.obarra.forecast.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DayMapper {
    /**
     * @param weatherType type of weather.
     * @return Quantity of Periods.
     */
    @Select("select count(*) "
            + "from (select distinct period "
            + "from weather_day "
            + "where weather_type_id = #{weatherType}) diff_periodC")
    Long countPeriodsOfWeatherType(Long weatherType);

    /**
     * @return Day with the maximum intensity of rain.
     */
    @Select("SELECT d.day "
            + "FROM weather_day d "
            + "where d.rain_intensity = (SELECT MAX(dd.rain_intensity) "
            + "FROM weather_day dd where dd.weather_type_id = 1)")
    Long findMaximumRainIntensityDay();
}
