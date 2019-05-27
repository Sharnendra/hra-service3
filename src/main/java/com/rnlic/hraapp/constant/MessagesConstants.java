package com.rnlic.hraapp.constant;

import org.springframework.beans.factory.annotation.Value;

public class MessagesConstants {
	
	@Value("${USER_NOT_AUTHORIZE}")
	public static String USER_NOT_AUTHORIZE;
	@Value("${ILLEGAL_ANNOTATION_ACCESS}")
	public static String ILLEGAL_ANNOTATION_ACCESS;

}
