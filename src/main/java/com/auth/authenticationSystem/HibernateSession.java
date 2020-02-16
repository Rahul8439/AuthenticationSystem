package com.auth.authenticationSystem;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSession {
	public static Session gethibernateSession() {
		Session session=null;
		SessionFactory factory=null;
		if(factory!=null)
			 session = factory.openSession();
		else {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
			session = factory.openSession();
		}
		return session;
		}
}
