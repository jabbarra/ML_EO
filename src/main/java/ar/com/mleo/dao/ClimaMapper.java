package ar.com.mleo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import ar.com.mleo.dao.entity.ClimaEntity;


@Mapper
public interface ClimaMapper {


	@Select("select id,nombre from public.clima order by nombre ASC")
	 List<ClimaEntity> findClimas();

}
