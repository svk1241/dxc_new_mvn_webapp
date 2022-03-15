package com.dxc.studentdemo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dxc.studentdemo.config.ApplicationConfig;


public class MyWebApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ApplicationConfig.class};
	}
	@Override
	protected String[] getServletMappings() {
		return new  String[] {"/"};
	}

}
