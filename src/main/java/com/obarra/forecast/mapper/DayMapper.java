package com.obarra.forecast.mapper;

import com.obarra.forecast.bean.DiaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DayMapper {

    @Select("select d.numero as numero "
            + "from public.dias as d "
            + "where d.id_climas = #{idClima}  order by numero ASC")
    List<DiaEntity> findDiasByClima(Long idClima);

    @Select("SELECT d.numero as numero "
            + "FROM public.dias as d "
            + "where d.intensidad_lluvia = (SELECT MAX(dd.intensidad_lluvia) "
            + "FROM public.dias as dd where dd.id_climas = 1)")
    DiaEntity findDiaMaximaIntensidad();
}
