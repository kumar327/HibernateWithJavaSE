package com.aks.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aks.pojo.Registration;

public class TestApplicationForGet {

	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Registration r = null;
		try {
			cfg = new Configuration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			r = (Registration) session.get(Registration.class, 9);
			System.out.println(r.geteId() + " " + r.geteName() + " " + r.geteSalary() + " " + r.geteAge());
			session.clear();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
