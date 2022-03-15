package com.dxc.studentdemo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dxc.studentdemo.bean.Student;
import com.dxc.studentdemo.dao.HibStudentDAO;
import com.dxc.studentdemo.dao.StudentDAO;
@Controller
public class StudentController 
{
	@Autowired
	StudentDAO sdao;
	@Autowired
	HibStudentDAO hsdao;
	public void setStudentDAO(StudentDAO sdao) {this.sdao=sdao;}
	public void setHibBookDAO(HibStudentDAO sdao) { this.hsdao=hsdao;}
	
	@GetMapping("/StudentForm")
	public String getStudentForm(Model model)
	{
		model.addAttribute("student",new Student(0,"",0,"",0));
		return "StudentDetails";
	}
	@PostMapping("/studentCrud")
	public String bookCrudOperations(@RequestParam("studentSubmit") String studentSubmit,Model model,@RequestParam("srNo") int srNo,@RequestParam String name,
			@RequestParam int age,@RequestParam String address,@RequestParam long phone
			)
	{
		model.addAttribute("student",new Student(0,"",0,"",0));
		switch(studentSubmit)
		{
		case "Add":
			
			hsdao.insertStudent(new Student(srNo,name,age,address,phone));
			break;
	    case "Show":
			
			Student s = hsdao.getStudentById(srNo);
			model.addAttribute("student",s);
			break;
		
		}
		return "StudentDetails";
	}
	


}
