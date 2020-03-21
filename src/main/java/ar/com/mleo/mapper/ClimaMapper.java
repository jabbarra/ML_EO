package ar.com.mleo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import ar.com.mleo.mapper.entity.ClimaEntity;


@Mapper
public interface ClimaMapper {

    @Select("select id,nombre from public.climas order by nombre ASC")
    List<ClimaEntity> findClimas();

}
