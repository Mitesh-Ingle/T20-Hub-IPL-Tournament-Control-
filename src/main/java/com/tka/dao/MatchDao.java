package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Matches;

@Repository
public class MatchDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Matches save(Matches matches) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(matches);
			transaction.commit();
			return matches;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Matches findById(Long id) {
		Session session = sessionFactory.openSession();
		return session.get(Matches.class, id);
	}

	public List<Matches> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		return criteria.list();

	}

	public boolean deleteMatchById(long id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Matches match = session.get(Matches.class, id);
			session.delete(match);
			session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}
}
