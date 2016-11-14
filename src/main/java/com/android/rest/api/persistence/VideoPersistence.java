package com.android.rest.api.persistence;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component //bean
public class VideoPersistence implements Repository<Video, Long>{
	
	//@PersistenceContext
	private SessionFactory factory;
	private Transaction tx;
	private Session session;
	private List<Video> list;
	
	public VideoPersistence(){
		factory  = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	    tx = null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Video> findAll(){
		tx = session.beginTransaction();
		list = (List<Video>)session
				.createQuery("FROM com.android.rest.api.persistence.Video")
				.list();
		tx.commit(); 
		return list;
	}
	
	public Video save(Video video){
		tx = session.beginTransaction();
		session.save(video);
		tx.commit();
		return video;
	}
	
}
