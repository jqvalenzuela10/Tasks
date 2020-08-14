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

	@Select("select*from tarea")
	List<Tarea> findAll();
	
	
	@Select("select*from tarea where id_usu=#{id_usu} and personal=#{personal}")
	List<Tarea> findByIdUser(int id_usu,boolean personal);
	
	@Select("select*from tarea t join usuario u on t.id_usu=u.id_usu where  personal=#{personal} and u.id_team=#{id_team}")
	List<Tarea> findByTaskTeam(boolean personal, int id_team);
	
	
	@Delete("delete from tarea where id =#{id} and id_usu=#{id_usu}")
	int deleteFindById(int id,int id_usu);
	
	
	@Insert("insert into tarea values(null,#{descripcion},false,#{personal},#{id_usu})")
	public int insert(Tarea tarea);
	
	
	@Update("update tarea set descripcion=#{descripcion}  ,hecho=#{hecho}  where id=#{id}")
	public int update(Tarea tarea);
}