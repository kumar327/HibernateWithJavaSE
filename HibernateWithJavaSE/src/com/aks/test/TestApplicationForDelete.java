package com.aks.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aks.pojo.Registration;

public class TestApplicationForDelete {

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
			tx = session.getTransaction();
			tx.begin();

			session.delete(r);
			tx.commit();
			System.out.println("Deleted ");
			session.clear();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
