package com.dxc.library.hibdao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtility 
{
	public static SessionFactory getSessionFactory()
	{
		StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
    	MetadataSources sources =new MetadataSources(registry);
    	Metadata mdata =sources.getMetadataBuilder().build();
    	return mdata.getSessionFactoryBuilder().build();
	}

}
