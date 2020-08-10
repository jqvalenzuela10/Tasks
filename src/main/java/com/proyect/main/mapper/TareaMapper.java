package com.proyect.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.proyect.main.model.Tarea;


@Mapper
public interface TareaMapper {

	@Select("select*from tarea;")
	List<Tarea> findAll();
	
	@Delete("delete from tarea where id =#{user}")
	int deleteFindById(int id);
	
	
	@Insert("insert into tarea values(null,#{descripcion},false)")
	public int insert(Tarea tarea);
	
	
	@Update("update tarea set descripcion=#{descripcion}  ,hecho=#{hecho}  where id=#{id}")
	public int update(Tarea tarea);
}