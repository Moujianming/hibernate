package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;

public class TestCategory {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("∑÷¿‡“ª");
		s.save(c);
		s.getTransaction().commit();
		s.close();
		sf.close();
	
	}
}
