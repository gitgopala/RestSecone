package com.slokam.oauth.RestSec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service
public class clientDetailsServiceImpl implements ClientDetailsService
{

	@Autowired
	private AppclientRepo appclientRepo;
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		
		
		System.out.println("Client details verfication----"+clientId);
	AppClientDetails acp =	appclientRepo.findByClientId(clientId);
		System.out.println("===client id==="+acp.getClientId()+"===client secret ==="+acp.getSecret());
		BaseClientDetails clientDetails = new BaseClientDetails(
				acp.getClientId(),
				null, 
				"read,write", 
				"password", 
				"ROLE_CLIENT");
		clientDetails.setClientSecret("{noop}"+acp.getSecret());
		System.out.println("------"+clientDetails);
		//appclientRepo.findByClientId(clientId);
		return clientDetails;
	}

}
