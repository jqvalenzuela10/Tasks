package com.proyect.main.resource;



import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.proyect.main.mapper.TareaMapper;
import com.proyect.main.mapper.TeamMapper;
import com.proyect.main.mapper.UserMapper;
import com.proyect.main.model.Tarea;
import com.proyect.main.model.Team;
import com.proyect.main.model.Usuario;

@Controller
public class tareaResource {

	@Autowired
	private TareaMapper tareaMapper;
	
	
	@Autowired
	private UserMapper usuarioMapper;
	
	@Autowired
	private TeamMapper teamMapper;
	
	
	
	public tareaResource(TareaMapper c) {
		this.tareaMapper=c;
	}
	
	
	
	
	
	
	
	@GetMapping("/tareas")
	public String listTareas(Model model,Principal p,HttpServletRequest request){
		
		//the problem is here
		Map<String , Object> userDetails = ((DefaultOidcUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAttributes();
		//si no existe el usuario lo guardamos en la bd
		Usuario emailBd=usuarioMapper.findAllByEmail(userDetails.get("email").toString());

		if(emailBd==null) {
					
					Usuario u=new Usuario();
					
					u.setNombre(userDetails.get("name").toString());
					u.setEmail(userDetails.get("email").toString());
					u.setImagen(userDetails.get("picture").toString());
					
					usuarioMapper.insert(u);
					
				}
		
				
				Usuario emailBdUltimo=usuarioMapper.findAllByEmail(userDetails.get("email").toString());		
				int id_usu=emailBdUltimo.getId_usu();
		//tareas personales
		model.addAttribute("tareaListPersonal",tareaMapper.findByIdUser(id_usu,false));
		
		
		
		
		
		
		
		model.addAttribute("tarea", new Tarea());
		model.addAttribute("id_usu", id_usu);
		model.addAttribute("nombre",userDetails.get("name"));
		model.addAttribute("fotoPerfil",userDetails.get("picture"));	
		
		
		
		//tareas en team
		
		List<Team> u=teamMapper.listaTeam(id_usu);
		
		if(!u.isEmpty()) {
			model.addAttribute("teamList",u);
			model.addAttribute("tareaListTeam",tareaMapper.findByTaskTeam(true,u.get(0).getId_team()));
		}
		else {
			model.addAttribute("teamList",u);
			model.addAttribute("tareaListTeam",tareaMapper.findByTaskTeam(true,123123));
		}
		
		
		
		return "index";
	}
	


	
	
	
	@PostMapping("/save")
	public String save(Tarea tarea) {
		
		tareaMapper.insert(tarea);
		return "redirect:/tareas";
	}
	
	@GetMapping("/delete/{id}/{id_usu}")
	public String delete(@PathVariable int id,@PathVariable int id_usu) {
		
		tareaMapper.deleteFindById(id,id_usu);
		return "redirect:/tareas";
	}
}
