package com.dxc.spwebmvcdemo.config;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.dxc.spwebmvcdemo"}) //context:component
public class ApplicationConfig implements WebMvcConfigurer
{
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/svk");
		dataSource.setUsername("root");
		dataSource.setPassword("1999");
	   return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean()
	{
		Properties props = new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		props.put("hibernate.show_sql","true");
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setPackagesToScan("com.dxc.spwebmvcdemo.bean");
		sessionFactoryBean.setHibernateProperties(props);
		return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager()
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactoryBean().getObject());
		return transactionManager;	
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg)
	{
		reg.addResourceHandler("static/**").addResourceLocations("WEB-INF/staticresources/");
	}
}