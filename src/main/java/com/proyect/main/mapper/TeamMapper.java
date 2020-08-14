package com.proyect.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.proyect.main.model.Team;
import com.proyect.main.model.Usuario;

@Mapper
public interface TeamMapper {

	
	@Select("select * from team where id_team=#{id_team}")
	Team team(int id_team);
	
	
	@Select("select*from team t join usuario u on t.id_team=u.id_team where id_usu=#{id_usu}")
	List<Team> listaTeam(int id_usu);
	
	@Insert("insert into team values(#{id_team},#{nombre_team})")
	int registrarTeam(Team team);
		
	
	@Update("update usuario set id_team=#{id_team} where id_usu=#{id_usu}")
	int unir_team(Usuario usu);
	
}
