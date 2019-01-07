package com.revature;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		CaveDAO cd = new CaveDAOImpl();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		funWithSessionMethods(sf);
		funWithNamedQueries(sf);
		
		
	}
	
	static void funWithNamedQueries(SessionFactory sf) {
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		/*
		Query q = s.getNamedQuery("getAllBears");
		List<Bear> bearList = q.getResultList();
		System.out.println(bearList.size());
		Iterator it = bearList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		*/
		
		
		
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Bear> c = builder.createQuery(Bear.class);
		Root<Bear> bearRoot = c.from(Bear.class);
		c.select(bearRoot);
		c.where(builder.equal(bearRoot.get("bearType"), 1));
		List<Bear> bl2 = s.createQuery(c).getResultList();
		for (Bear b : bl2) {
			System.out.println(b);
		}
		
		
		
		
		List<Bear> bl = s.getNamedQuery("getBearsByType").setParameter("id", 1).getResultList();
		Iterator it2 = bl.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		tx.commit();
		s.close();
		
	}
	
	static void funWithSessionMethods(SessionFactory sf) {
		
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		
		//get and load
		Cave c1 = s.get(Cave.class, 33); // this will be null
		System.out.println(c1);
		
		
//		Cave c2 = s.load(Cave.class, 35);
//		System.out.println(c2);
		
		Cave c3 = s.load(Cave.class, 1023);
		System.out.println(c3);
		
		//save and persist
		System.out.println(s.save(c3)) ; 
		
		tx.commit();
		s.close();
		
	}

}
