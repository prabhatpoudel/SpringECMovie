package com.prabhat.movie.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.prabhat.movie.domain.Director;

public class Director_DAO {
	SessionFactory sessionFactory;
	Director director;

	public Director_DAO(SessionFactory sessionFactory, Director director) {
		this.sessionFactory = sessionFactory;
		this.director = director;
	}

	public void addDirector(Director director) throws Exception {

		try {
			sessionFactory.getCurrentSession().persist(director);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);

		}
	}

	public Director retriveMovie(int id) throws Exception {
		try {

			Director direct = (Director) sessionFactory.getCurrentSession().get(Director.class, id);
			return direct;

		} catch (Exception e) {
				e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void modifyMovie(Director direct) throws Exception {

		try {
			sessionFactory.getCurrentSession().merge(direct);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void deleteMovie(Director direct) throws Exception {
		try {
			sessionFactory.getCurrentSession().delete(direct);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
