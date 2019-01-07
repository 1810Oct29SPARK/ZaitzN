package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (HibernateUtil.sessionFactory == null) {
			//if no SessionFactory has been created, create one
			Configuration c = new Configuration();
			c.setProperty("hibernate.connection.username", "admin_raruiz");
			c.setProperty("hibernate.connection.password", "Revature");
			c.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@spark-demo-raruiz.ckf2wqynyucl.us-east-2.rds.amazonaws.com:1521:orcl");
			c.configure(); //by default, looks for hibernate.cfg.xml in src/main/resources
			HibernateUtil.sessionFactory = c.buildSessionFactory();
		}
		return HibernateUtil.sessionFactory;
	}
}
