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
import com.proyect.main.model.Tarea;

@Controller
public class tareaResource {

	@Autowired
	private TareaMapper tareaMapper;
	
	
	public tareaResource(TareaMapper c) {
		this.tareaMapper=c;
	}
	
	
	
	
	
	
	
	@GetMapping("/tareas")
	public String listTareas(Model model,Principal p,HttpServletRequest request){
		
		
		Map<String , Object> userDetails = ((DefaultOidcUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAttributes();
		System.out.println(userDetails.get("picture"));
		System.out.println(request.getUserPrincipal());
		model.addAttribute("tareaList",tareaMapper.findAll());
		model.addAttribute("tarea", new Tarea());
		model.addAttribute("nombre",userDetails.get("name"));
		model.addAttribute("fotoPerfil",userDetails.get("picture"));
		return "index";
	}
	
	

	
	
	
	@GetMapping("/actualizarTarea")
	public String actualizar(Tarea tarea) {
		
		return "redirect:/tareas";
	}
	
	
	
	@PostMapping("/save")
	public String save(Tarea tarea) {
		
		tareaMapper.insert(tarea);
		return "redirect:/tareas";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		
		tareaMapper.deleteFindById(id);
		return "redirect:/tareas";
	}
}
