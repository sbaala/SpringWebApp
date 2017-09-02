package com.freebies.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freebies.model.User;
import com.freebies.service.user.UserService;

/**
 * 
 * @author Bala
 *
 */
@Controller
public class DashboardController extends BaseController{

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model m , HttpServletResponse resp, HttpServletRequest req) {
		
		User user = userService.findByUserId("admin");
		
		System.out.println(user.getFirstName());
			
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model , HttpServletResponse resp, HttpServletRequest req) {
		return "login";
	}
}
