package com.aks.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aks.pojo.Registration;

public class TestApplicationForSave {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Registration r = null;
		Transaction tx = null;
		try {

			cfg = new Configuration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();

			r = new Registration();
			r.seteId(12);
			r.seteName("H Hi");
			r.seteSalary(45);
			r.seteAge(45);

			tx = session.beginTransaction();
			int results = (Integer) session.save(r);

			tx.commit();
//			if (results == 10) {
//				System.out.println("Inserted");
//			} else {
//				System.out.println("Failed");
//			}
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
