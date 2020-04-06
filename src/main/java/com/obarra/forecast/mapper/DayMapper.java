package com.obarra.forecast.mapper;

import com.obarra.forecast.entity.DiaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DayMapper {

    @Select("select d.numero as numero "
            + "from public.dias as d "
            + "where d.id_climas = #{idClima}  order by numero ASC")
    List<DiaEntity> findDiasByClima(int idClima);

    @Select("SELECT d.numero as numero "
            + "FROM public.dias as d "
            + "where d.intensidad_lluvia = (SELECT MAX(dd.intensidad_lluvia) "
            + "FROM public.dias as dd where dd.id_climas = 1)")
    DiaEntity findDiaMaximaIntensidad();
}
