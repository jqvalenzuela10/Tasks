package com.proyect.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.main.mapper.TeamMapper;
import com.proyect.main.model.Team;
import com.proyect.main.model.Usuario;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/rest")
public class TeamRest {

	@Autowired
	private TeamMapper teamMapper;
	
	
	@PostMapping("/team")
	public ResponseEntity<Team> registrarTeam(@RequestBody Team team,Model model) {
		
		teamMapper.registrarTeam(team);
		//tareas en team
		
		
		return new ResponseEntity<Team>(HttpStatus.OK);
	}
	
	
	
	@PutMapping("/team")
	public String unirTeam(@RequestBody Usuario usu) {
		Team team =teamMapper.team(usu.getId_team());
		String response="";
		if(team!=null) {
			teamMapper.unir_team(usu);
			response="ok";
			
		}else {
			response="error";
		}
		
		
		
		return response;
	}
}
