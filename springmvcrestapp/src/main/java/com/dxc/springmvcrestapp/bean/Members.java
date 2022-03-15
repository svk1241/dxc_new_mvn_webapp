package com.dxc.springmvcrestapp.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Members")
	public class Members 
	{
	   List<Member> members;
	   public void setMembers(List<Member> members)
	   {
		   this.members=members;
	   }
	   public List<Member> getMembers()
	   {
		   return members;
	   }

	}

