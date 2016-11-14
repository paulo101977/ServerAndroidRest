package com.android.rest.api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoJPA extends JpaRepository<Video, Long>{
	
	
}
