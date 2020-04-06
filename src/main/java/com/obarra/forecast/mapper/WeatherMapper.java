package com.obarra.forecast.mapper;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.WeatherDTO;
import com.obarra.forecast.entity.DiaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface WeatherMapper {
    /**
     * Finds all Weather, and maps to DTO
     * @return List of Weather
     */
    @Select("select id,nombre as name from public.climas order by nombre ASC")
    List<Weather> findWeather();

    @Select("select c.id, "
            + "c.nombre as name "
            + "from public.dias d "
            + "inner join public.climas c on d.id_climas = c.id "
            + "where d.numero = #{dia}")
    Weather findByDia(@Param("dia") Long dia);

    @Select("select c.id, "
            + "c.nombre as name "
            + "from public.climas c "
            + "where c.id = #{id}")
    Weather findById(@Param("id") Long id);
}
