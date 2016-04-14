package com.prabhat.movie.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//import com.ecmovie.control.HibernateUtil;
import com.prabhat.movie.domain.Picture;

public class Picture_DAO {
	SessionFactory sessionFactory;
	Picture pic;

	public Picture_DAO(SessionFactory sessionFactory, Picture pic) {

	}

	public void addPicture(Picture pic) throws Exception {

		try {
			sessionFactory.getCurrentSession().persist(pic);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public Picture retriveMovie(int id) throws Exception {

		try {
			Picture pic = (Picture) sessionFactory.getCurrentSession().get(Picture.class, id);
			return pic;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void modifyPicture(Picture pic) throws Exception {

		try {
			sessionFactory.getCurrentSession().merge(pic);
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void deletePicture(Picture pic) throws Exception {
		try {
			sessionFactory.getCurrentSession().delete(pic);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
