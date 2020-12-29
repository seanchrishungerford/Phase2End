package com.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.objectweb.asm.attrs.Annotation;

public class HibernateUtility {
	private static SessionFactory sf;
	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session = sf.openSession();
		return session;
	}
}
