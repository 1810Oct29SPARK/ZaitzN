package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Moon;
import com.revature.util.HibernateUtil;

public class MoonDAOImpl implements MoonDAO {

	@Override
	public List<Moon> getAllMoons() {
		List<Moon> moons = new ArrayList<>();
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			moons = s.createQuery("from Moon").getResultList();
			tx.commit();
			s.close();
		}
		return moons;
	}

	@Override
	public Moon getMoonById(int id) {
		
		Moon m = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			m = s.get(Moon.class, id);
			tx.commit();
			s.close();
		}
		return m;
	}
	

}
