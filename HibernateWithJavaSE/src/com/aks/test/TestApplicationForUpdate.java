package com.aks.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aks.pojo.Registration;

public class TestApplicationForUpdate {

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
			r.seteId(13);
			r.seteName("455");
			r.seteSalary(450);
			r.seteAge(4);

			tx = session.getTransaction();
			tx.begin();
//			session.update(r);
			session.saveOrUpdate(r);

			tx.commit();
			System.out.println("Updated Successfully");
//		if (results == 10) {
//			System.out.println("Inserted");
//		} else {
//			System.out.println("Failed");
//		}
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
