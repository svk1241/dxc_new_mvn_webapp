package com.dxc.spwebmvcdemo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.spwebmvcdemo.bean.Book;
import com.dxc.spwebmvcdemo.bean.Member;
import com.dxc.spwebmvcdemo.dao.MemberDAO;

@Controller
public class MemberController
{
	@Autowired
	MemberDAO mdao;
	public void setMemberDAO(MemberDAO mdao) { this.mdao=mdao;}
	
	@GetMapping("/memberForm")
     public String  getMemberForm(Model model)
     {
		model.addAttribute("member",new Member(0,"","",0,""));
		return "MemberDetails";
	  }
	@PostMapping("/memberCrud")
	public String memberCrudOperations(@RequestParam("memberbutton") String memberbutton,Model model,@RequestParam("memberId") int memberId,@RequestParam String name,
			@RequestParam String aadharNo,@RequestParam long phone,@RequestParam String emailId)
	{
		model.addAttribute("member",new Member(0,"","",0,""));
		switch(memberbutton)
		{
		case "Add":
			mdao.insertMemberDetails(new Member(memberId,name,aadharNo,phone,emailId));
			break;
		case "Modify":
			mdao.modifyMemberDetails(new Member(memberId,name,aadharNo,phone,emailId));
			break;
		case "Delete":
			mdao.deleteMemberDetails(memberId);
			break;
		case "Show":
			Member m =mdao.getMemberDetails(memberId);
			model.addAttribute("member",m);
			break;
		case "ShowAll":
			ArrayList<Member> memberList = mdao.getAllMemberDetails();
			model.addAttribute("memberList",memberList);
		}
		return "MemberDetails";
	}
	
	

}
