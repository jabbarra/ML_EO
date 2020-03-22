package com.obarra.forecast.mapper;


import com.obarra.forecast.mapper.entity.ClimaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ClimaMapper {

    @Select("select id,nombre from public.climas order by nombre ASC")
    List<ClimaEntity> findClimas();

}
