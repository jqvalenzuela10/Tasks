package com.proyect.main.resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginResource {

	@RequestMapping({"/","/login"})
	public String listAll(Model model){
		
		return "login";
	}
	

	
	
	@RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
   
        request.logout();
        request.getSession().invalidate();
        
        return "login";
    }
	
}
