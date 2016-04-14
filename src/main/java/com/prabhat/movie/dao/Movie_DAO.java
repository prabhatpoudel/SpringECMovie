package com.prabhat.movie.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

//import com.ecmovie.control.HibernateUtil;
import com.prabhat.movie.domain.Movie;


@Transactional
public class Movie_DAO {
	SessionFactory sessionFactory;
	Movie movie;

	public Movie_DAO()
	{
	}
	public Movie_DAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovie() {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			Query criteria = sessionFactory.getCurrentSession()
					.createQuery("From Movie mov ");
			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	public void addMovie(Movie movie) throws Exception {
		try {
			System.out.println("I am here");
			sessionFactory.getCurrentSession().persist(movie);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovie(String movie_name) {
		List<Movie> movies = new ArrayList<Movie>();
		try {
			Query criteria = sessionFactory.getCurrentSession()
					.createQuery("From Movie mov where mov.title like :movie_name");
			criteria.setParameter("movie_name", "%"+movie_name+"%");

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByGenere(String movie_genere) {
		List<Movie> movies = new ArrayList<Movie>();

		try {
			Query criteria = sessionFactory.getCurrentSession()
					.createQuery("From movie mov where :movie_genere in elements(mov.genere)");
			criteria.setParameter("movie_genere", movie_genere);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByRating(String movie_rating) {
		List<Movie> movies = new ArrayList<Movie>();

		try {
			Query criteria = sessionFactory.getCurrentSession()
					.createQuery("From movie mov where mov.rating= :movie_rating");
			criteria.setParameter("movie_rating", movie_rating);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByYear(String movie_year) {
		List<Movie> movies = new ArrayList<Movie>();

		try {
			Query criteria = sessionFactory.getCurrentSession()
					.createQuery("From Movie mov where mov.year like :movie_year");
			criteria.setParameter("movie_year", "%"+movie_year+"%");
			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public List<Movie> searchMovieByArtistName(String artist_name) {
		List<Movie> movies = new ArrayList<Movie>();

		try {
			Query criteria = sessionFactory.getCurrentSession()
					.createQuery("SELECT mov From Movie mov join mov.artist a where a.name like :artist_name");
			criteria.setParameter("artist_name", "%"+artist_name+"%");

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	// This method don't work as of now since character field is not defined in
	// the artist
	public List<Movie> searchMovieByCharacterName(String character_name) {
		List<Movie> movies = new ArrayList<Movie>();

		try {

			Query criteria = sessionFactory.getCurrentSession()
					.createQuery("From movie mov where mov.artist.charctername=:character_name");
			criteria.setParameter("character_name", character_name);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public List<Movie> searchMovieByDirector(String director_name) {
		
		@SuppressWarnings("unused")
		Transaction tx = null;
		List<Movie> movies = new ArrayList<Movie>();

		try {

		
			Query criteria = sessionFactory.getCurrentSession().createQuery("From movie mov where mov.director.name=:director_name");
			criteria.setParameter("director_name", director_name);

			movies = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public Movie retriveMovie(int id) throws Exception {

		

		try {

		
			Movie movie = (Movie) sessionFactory.getCurrentSession().get(Movie.class, id);
			return movie;

		} catch (Exception e) {
			
				e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void modifyMovie(Movie mov) throws Exception {


		try {

			sessionFactory.getCurrentSession().merge(mov);
			
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void deleteMovie(Movie mov) throws Exception {

		try {
			sessionFactory.getCurrentSession().delete(mov);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
