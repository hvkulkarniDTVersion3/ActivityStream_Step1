package com.stackroute.activitystream.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		try {
			config.configure("hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * build the sessionFactory object based on the parameters from
	 * hibernate.cfg.xml file. Also, handle exception if the session factory
	 * object can't be created
	 */}