package com.rnlic.hraapp.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rnlic.hraapp.configuration.MethodSecurityConfig;
import com.rnlic.hraapp.constant.GenericConstants;
import com.rnlic.hraapp.rbac.Secured;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Aspect
@Component
public class ServiceAspect {
	
	@Autowired
	private MethodSecurityConfig configMethodSecurity;

	@Before(value = "args(httpServletRequest) && @annotation(com.rllic.hraapp.rbac.Secured)")
	public void afterAdvice(JoinPoint joinPoint,HttpServletRequest httpServletRequest) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(Secured.class)) 
        {
        	Annotation annotation = method.getAnnotation(Secured.class);
            Secured secured = (Secured) annotation;
            
        	if(configMethodSecurity.getRoleBasedSecurity().containsKey(secured.indentify().trim()))
    		{
        		String header = httpServletRequest.getHeader(GenericConstants.AUTHORIZATION);
        		Claims body = Jwts.parser()
                        .setSigningKey(configMethodSecurity.getSecret())
                        .parseClaimsJws(header)
                        .getBody();
        		
        		List<String> identifier=configMethodSecurity.getRoleBasedSecurity().get(secured.indentify().trim());
        		//if(identifier.stream().filter(tag->tag.equalsIgnoreCase((String)body.get("role"))).count()<=0)
        		if(identifier.stream().filter(new Predicate<String>() {

					@Override
					public boolean test(String tag) {
						Boolean flag=false;
						
						if(tag.contains(".*"))
						{
							String tagRepo=tag.replace(".*", "");
							if(((String)body.get("role")).contains("."))
							{
								String roles=((String)body.get("role"));
								if(tagRepo.equalsIgnoreCase(roles.substring(0, roles.indexOf("."))))
								{
									flag= true;
								}
							}
							else if(tagRepo.equalsIgnoreCase((String)body.get("role")))
							{
								flag= true;
							}
						}
						
						else if(tag.equalsIgnoreCase((String)body.get("role")))
						{
							flag= true;
						}
						
						return flag;
					}
				
        		}).count()<=0)
    			{
    				throw new RuntimeException("USER IS NOT AUTHORIZED TO ACCESS THIS METHOD!!");
    			} 
    		}
        	else
        	{
        		throw new RuntimeException("ILLEGAL USE OF ANNOTATION SECURED AS NO ROLES OR AUTHORIZATION OF ROLES IS BEEN SPECIFIED!!");
        	}
        }
	}
	
}
