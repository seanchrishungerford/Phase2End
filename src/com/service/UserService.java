package com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.UserDao;
import com.model.Registration;
import com.utility.HibernateUtility;

public class UserService implements UserDao {

	@Override
	public void registration(Registration reg) {
		System.out.println("inside service");

		try {
			Session session = HibernateUtility.getSession();
			Transaction tx = session.beginTransaction();
			session.save(reg);
			tx.commit();
			System.out.println(("user is registered"));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

}
