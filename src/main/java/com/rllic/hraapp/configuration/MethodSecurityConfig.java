package com.rllic.hraapp.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.rllic.hraapp.configurables.MethodAuthorization;

@Configuration
@ConfigurationProperties(prefix="methodsecurity")
@EnableConfigurationProperties
@Component
public class MethodSecurityConfig implements InitializingBean{

	private List<MethodAuthorization> securitymap = new ArrayList<MethodAuthorization>();
	private Map<String,List<String>> roleBasedSecurity = new HashMap<String,List<String>>();
	private String secret;
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public List<MethodAuthorization> getSecuritymap() {
		return securitymap;
	}
	
	public void setSecuritymap(List<MethodAuthorization> securitymap) {
		this.securitymap = securitymap;
	}
	
	public Map<String, List<String>> getRoleBasedSecurity() {
		return roleBasedSecurity;
	}
	
	public void setRoleBasedSecurity(Map<String, List<String>> roleBasedSecurity) {
		this.roleBasedSecurity = roleBasedSecurity;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.err.println(toString());
		
		setRoleBasedSecurity(securitymap.stream()
						.collect(
						   Collectors.toMap(MethodAuthorization::getServiceId,MethodAuthorization::getRolesAllowed)
						));
	}

	@Override
	public String toString() {
		return "MethodSecurityConfig [securitymap=" + securitymap + ", roleBasedSecurity=" + roleBasedSecurity
				+ ", secret=" + secret + "]";
	}
	
	
}
