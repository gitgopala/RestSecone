package com.slokam.oauth.RestSec;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class OurUserServiceImp implements UserDetailsService{

	@Autowired
	private IuserRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	AppUser apu =	userrepo.findByUserName(userName);
		//return User.builder().username("abc").password("{noop}bca").roles("admin").build();
		return User.builder().username(apu.getUserName()).password("{noop}"+apu.getPassword()).roles("admin").build();

	}

	

}
