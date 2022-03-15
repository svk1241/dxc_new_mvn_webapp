package com.dxc.spwebmvcdemo;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dxc.spwebmvcdemo.config.ApplicationConfig;
//public class MyWebApplicationInitializer implements WebApplicationInitializer
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
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
   /* @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
    	//XmlWebApplicationContext container = new XmlWebApplicationContext();
    	AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
        container.register(ApplicationConfig.class);
        container.scan("com.dxc.spwebmvcdemo");
    	//container.setConfigLocation("WEB-INF/springconfig/abc-config.xml");
    	ServletRegistration.Dynamic register = servletContext.addServlet("DS",new DispatcherServlet(container));
    	register.addMapping("/");
    	register.setLoadOnStartup(1);
    }
}*/