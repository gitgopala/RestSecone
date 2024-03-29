package com.slokam.oauth.RestSec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

//hello
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	@Qualifier("clientDetailsServiceImpl")
	private ClientDetailsService clientDetailsService;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		InMemoryTokenStore tokenStore = new InMemoryTokenStore();
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore).approvalStoreDisabled();;
		
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {     
	 
	
		
		security.allowFormAuthenticationForClients()
	    .checkTokenAccess("permitAll()");    
	    security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");
	    
	    
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.withClientDetails(clientDetailsService);
	
		
		/*
		 * clients.inMemory().withClient("slokamTech").secret("{noop}tech")
		 * .authorizedGrantTypes("client_credentials","password").scopes(
		 * "resource-server-read", "resource-server-write");
		 */
		
	}
	
	
	
	
	
}
