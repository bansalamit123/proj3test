package com.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.DeveloperDTO;

public class DeveloperModel {
	public void add(DeveloperDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();

	}

	public void update(DeveloperDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();

	}

	public void delete(DeveloperDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();

	}

	public DeveloperDTO findByPk(int pk) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		DeveloperDTO dto = (DeveloperDTO) session.get(DeveloperDTO.class, pk);
		session.close();
		return dto;

	}

	public List search(DeveloperDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(DeveloperDTO.class);
		List list = criteria.list();
		session.close();
		return list;

	}

}
