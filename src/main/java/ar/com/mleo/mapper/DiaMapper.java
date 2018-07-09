package ar.com.mleo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ar.com.mleo.mapper.entity.DiaEntity;


@Mapper
public interface DiaMapper {

	@Select("select d.numero as numero, c.nombre as clima from public.dias as d, public.climas as c where d.id_climas = c.id and d.numero = #{dia}")
	DiaEntity findByDia(@Param("dia") Long dia);

	@Select("select d.numero as numero from public.dias as d where d.id_climas = #{idClima}  order by numero ASC")
	List<DiaEntity> findDiasByClima(int idClima);
	
	@Select("SELECT d.numero as numero FROM public.dias as d where d.intensidad_lluvia = (SELECT MAX(dd.intensidad_lluvia)FROM public.dias as dd where dd.id_climas = 1)")
	DiaEntity findDiaMaximaIntensidad();

}
