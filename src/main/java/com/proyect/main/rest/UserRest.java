package com.proyect.main.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.main.mapper.TeamMapper;
import com.proyect.main.mapper.UserMapper;
import com.proyect.main.model.Usuario;

@RestController
@RequestMapping("/rest")
public class UserRest {

	@Autowired UserMapper usuarioMapper;
	
	@Autowired TeamMapper teamMapper;
	
	
	/*
	@PutMapping("/user")
	public String putUser(@RequestBody Usuario usu,Model model) {
		
		usuarioMapper.actualizar(usu);
		
		//tareas en team
		model.addAttribute("teamList",teamMapper.listaTeam(usu.getId_usu()));
	
		return "";
	}
	
	*/
}
