package com.android.rest.api.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class VideoPersistence implements Repository<Video, Long>{
	
	//@PersistenceContext
    private EntityManager manager;
	
	public VideoPersistence(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Videos");
		this.manager = factory.createEntityManager();
	}
	
	public List<Video> findAll(){
		return (List<Video>)
				manager.createQuery("select v from videos v").getResultList();
	}
	
}
