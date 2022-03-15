package com.dxc.spwebmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.spwebmvcdemo.bean.Person;
import com.dxc.spwebmvcdemo.exception.MySpringWebMvcException;

@Controller
public class PersonController 
{
	@GetMapping("/personForm")
	public String getPersonForm(Model model)
	{
		model.addAttribute("command", new Person());
		return "PersonDetails";
	}
	@PostMapping("/showPerson")
	//@ExceptionHandler(MySpringWebMvcException.class)
	public String showPersonDetails(@ModelAttribute Person person,Model model)
	{
		if(person.getAge() < 25) throw new MySpringWebMvcException("Age is less than 25 years...not Allowed");
		String message ="Ssn is "+person.getSsn()+"<br>Name is "+person.getName()+"<br>Age is"+person.getAge();
		message=message+"<br>Gender is"+person.getGender()+"<br>Education is";
		for (String s : person.getEducation())
			message=message+s+" ";
				
				model.addAttribute("message",message);
		return "Display";
	}
	/*public String PersonCrudOperations(@RequestParam("personbutton") String personbutton,Model model,@RequestParam("ssn") int ssn,@RequestParam String name,
			@RequestParam int age,@RequestParam char gender,@RequestParam String education)
	{
		model.addAttribute("person",new Person(0,"",0,"",""))
	}*/
	@ExceptionHandler(MySpringWebMvcException.class)
	public ModelAndView xyz(MySpringWebMvcException ex)
	{
		return new ModelAndView("ExceptionHandler1","exception",ex);
	}

}
