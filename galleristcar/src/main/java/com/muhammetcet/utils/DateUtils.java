package com.muhammetcet.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;

public class DateUtils {

	public static String getCurrentDate(Date date) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		
		return simpleDateFormat.format(date);
	}
	
}
