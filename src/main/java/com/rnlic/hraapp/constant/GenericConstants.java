package com.rnlic.hraapp.constant;

import org.springframework.beans.factory.annotation.Value;

public class GenericConstants {
	
	public static String AUTHORIZATION="Authorization";
	@Value("${signinKey}")
	public static String SIGNING_KEY;

}
