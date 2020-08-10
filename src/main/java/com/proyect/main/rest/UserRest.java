package com.proyect.main.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.main.mapper.TareaMapper;
import com.proyect.main.model.Tarea;

@RestController
@RequestMapping("/rest")
public class UserRest {

	@Autowired
	private TareaMapper tareaMapper;
	
	@GetMapping("/user")
	public ResponseEntity<Tarea> get() {
		List<Tarea> lista=tareaMapper.findAll();
		
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	@PutMapping(value = "/user")
	public String post(@RequestBody Tarea tarea) {
		System.out.println(tarea);
		tareaMapper.update(tarea);
		return "{'response':'actualizado correctamente'}";
	}
	
	
	@GetMapping("/restricted")
	public String restricted(OAuth2AuthenticationToken  p) {
		return "Hola"+p.getName();
	}
	
}
