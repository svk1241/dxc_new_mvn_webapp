package com.dxc.form.service;

import com.dxc.form.bean.WebForm;
import com.dxc.form.dao.FormDAO;

public class FormService 
{
	FormDAO fdao = new FormDAO();
	public boolean addDetails(WebForm f)
	{
		return fdao.insertFormDetails(f);
		
	}

}
