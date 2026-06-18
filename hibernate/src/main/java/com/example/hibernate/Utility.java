package com.example.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class Utility {
	static private SessionFactory sf = new Configuration()
			.configure()
			.addAnnotatedClass(com.example.hibernate.Product.class)
			.buildSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
	public static void terminate() {
		sf.close();
	}
}
