package com.proyect.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.proyect.main.model.Usuario;

@Mapper
public interface UserMapper {

	@Select("select * from heroku_52a908aab878403.usuario")
	List<Usuario>  findAll();
	
	
	@Select("select * from usuario where email=#{email}")
	Usuario  findAllByEmail(String email);
	
	
	@Insert("insert into usuario values(null,#{nombre},#{email},#{imagen})")
	int insert(Usuario usu);
	
	
	
	
	
}
