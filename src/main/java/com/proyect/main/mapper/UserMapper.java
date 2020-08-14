package com.proyect.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.proyect.main.model.Usuario;

@Mapper
public interface UserMapper {

	@Select("select * from usuario")
	List<Usuario>  findAll();
	
	
	@Select("select * from usuario where email=#{email}")
	Usuario  findAllByEmail(String email);
	
	
	
	
	@Insert("insert into usuario values(null,#{nombre},#{email},#{imagen},null)")
	int insert(Usuario usu);
	
	
	@Update("update usuario set id_team=#{id_team} where id_usu=#{id_usu}")
	int actualizar(Usuario usuario);
	
	
}
