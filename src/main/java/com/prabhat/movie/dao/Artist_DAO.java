package com.prabhat.movie.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prabhat.movie.domain.Artist;


public class Artist_DAO {
	SessionFactory sessionFactory;
	Artist artist;
	
	
	public Artist_DAO(SessionFactory sessionFactory, Artist artist)
	{
		this.sessionFactory=sessionFactory;
		this.artist=artist;
	}
	
	public void addArtist(Artist artist) throws Exception
	{
		
		try{
			
			sessionFactory.getCurrentSession().persist(artist);
			
		}
		catch(Exception e){
			e.printStackTrace();
		    throw new Exception(e);
		}
	}
	
    public Artist retriveartist(int id) throws Exception{
		
		try {
			Artist artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class, id);
			return artist;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
		
	public void modifyArtist(Artist art) throws Exception{
				
		try {			
			sessionFactory.getCurrentSession().merge(art);						
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);			
		}	
	}
	
	public void deleteArtist(Artist art)throws Exception{
		
		try {						
			sessionFactory.getCurrentSession().delete(art);					
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);			
		}
	}	

}
