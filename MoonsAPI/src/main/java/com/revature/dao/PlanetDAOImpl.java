package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Planet;
import com.revature.util.HibernateUtil;

public class PlanetDAOImpl implements PlanetDAO {
	
	@Override
	public List<Planet> getAllPlanets() {
		List<Planet> planets = new ArrayList<>();
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			planets = s.createQuery("from Planet").getResultList();
			tx.commit();
		}
		return planets;
	}

	@Override
	public Planet getPlanetById(int id) {
	
		Planet p = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			p = s.get(Planet.class, id);
			tx.commit();
		}
		return p;
	}

}
