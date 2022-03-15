package com.dxc.form.service;

import com.dxc.form.bean.WebForm2;
import com.dxc.form.dao.FormDAO2;


public class Form2Service 
{
	FormDAO2 fdao = new FormDAO2();
	public boolean addDetails(WebForm2 f)
	{
		return fdao.insertFormDetails(f);
		
	}

}
