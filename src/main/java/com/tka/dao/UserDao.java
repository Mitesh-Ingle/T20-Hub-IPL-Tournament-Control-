package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.User;

@Repository
public class UserDao {
	public UserDao() {
		System.err.println("In UserDao");
	}

	@Autowired
	private SessionFactory factory;

	public boolean loginUser(String username, String password) {
		try {
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(User.class);

			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));

			List list = criteria.list();
			if (!list.isEmpty()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
