package com.dxc.springmvcrestapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.springmvcrestapp.bean.Book;
import com.dxc.springmvcrestapp.bean.Books;
import com.dxc.springmvcrestapp.bean.Member;
import com.dxc.springmvcrestapp.bean.Members;
import com.dxc.springmvcrestapp.dao.HibMemberDAO;
@RestController  
@RequestMapping("/member")
public class MemberController 
{
	@Autowired
	HibMemberDAO hibMemberDAO;
	public void setHibMemberDAO(HibMemberDAO hibMemberDAO) {this.hibMemberDAO=hibMemberDAO;}
	@GetMapping(value="/{memberId}",produces= {"application/json","application/xml"})
	public Member getMemberById1(@PathVariable int memberId)
	{
		return hibMemberDAO.getMemberid(memberId);
	}
	@GetMapping(value="/all",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Members getAllMembers()
	{
		
		Members members = new Members();
		members.setMembers(hibMemberDAO.getAllMembers());
		return  members;
	}
	@PostMapping(consumes="application/json")   //http://localhost:8089/springmvcrestapp/member
	public void addMemberDetails(@RequestBody Member member)
	{
		hibMemberDAO.insertMember(member);
	}
	@DeleteMapping("/{memberId}")  //http://localhost:8089/springmvcrestapp/member/1241
	public void deleteMemberDetails(@PathVariable int memberId)
	{
		hibMemberDAO.deleteMember(memberId);
	}
	@PutMapping(consumes="application/json")   //http://localhost:8089/springmvcrestapp/member
	public void modifyMemberDetails(@RequestBody Member member)
	{
		hibMemberDAO.modifyMember(member);
	}
	
	}


