package com.slokam.oauth.RestSec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppclientRepo extends JpaRepository<AppClientDetails, Integer>{

	
	public abstract AppClientDetails findByClientId(String clientId);
}
