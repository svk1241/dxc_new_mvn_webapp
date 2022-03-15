package com.dxc.spwebmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.spwebmvcdemo.bean.Users;
import com.dxc.spwebmvcdemo.dao.UsersDAO;

@Controller
public class FirstController
{
	@Autowired
	UsersDAO udao;
	public void setUsersDAO(UsersDAO udao) { this.udao=udao;}
	//@RequestMapping("/wishmessage")
	@GetMapping("/wishmessage")
	//public ModelAndView wishUser()
	//public String wishUser(@RequestParam("username") String name,Model model)
	public String wishUser(@RequestParam String username,Model model)
	{
		
		//ModelAndView mv = new ModelAndView("Display","message","Hello User");
		model.addAttribute("message","Hello "+ username);
		//return mv;
		return "Display";
		
	}
	//@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	@PostMapping("/validateUser")
	public String authenticateUser(@RequestParam String username,@RequestParam String password,Model model)
	{
		Users u = new Users(username,password);
		String message="Invalid Username / Password..!";
		//if(username.equalsIgnoreCase("admin@dxc.com") && password.contentEquals("Faculty"))
		if(udao.validateUser(u))
			//message ="Spring MVC  WELCOME YOU";
			return "redirect:static/menu.html";
		model.addAttribute("message",message);
		return "Display";
	}
	@GetMapping("/loginForm")
	public String getLoginForm()
	{
		return "redirect:static/login.html";
	}

}