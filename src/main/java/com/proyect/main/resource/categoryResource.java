package com.proyect.main.resource;



import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.proyect.main.mapper.CategoryMapper;
import com.proyect.main.model.Category;

@Controller
public class categoryResource {

	
	private CategoryMapper categoryMapper;
	
	
	public categoryResource(CategoryMapper c) {
		this.categoryMapper=c;
	}
	
	@GetMapping("/")
	public String listAll(Model model){
		
		model.addAttribute("categoryList",categoryMapper.findAll());
		
		return "login";
	}
	
	@GetMapping("/restricted")
	public String restricted(Principal p,Model model) {
		String userName = p.getName();
		System.out.println("User Name: " + userName);
		
		UserDetails loginedUser = (UserDetails) ((Authentication) p).getPrincipal();
		String userInfo = com.proyect.main.utils.WebUtils.toString(loginedUser);
		System.out.println(userInfo);
		model.addAttribute("userInfo", userInfo);
		return "index";
	}
}
