package com.slokam.oauth.RestSec;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IuserRepo extends JpaRepository<AppUser, Integer>{

	
	public abstract AppUser findByUserName(String name);
}
