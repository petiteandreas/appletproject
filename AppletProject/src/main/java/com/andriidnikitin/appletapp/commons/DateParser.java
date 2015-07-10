package com.andriidnikitin.appletapp.commons;

import java.util.Date;

import com.andriidnikitin.appletapp.commons.exceptions.InvalidArgumentUiException;

public class DateParser {

	@SuppressWarnings("deprecation")
	public static String unparseDate(Date d){
		
		if (d==null){
			throw new IllegalArgumentException("Date cannot be null."); 
		}
		String str = d.toGMTString().replace(',', '@');
		return str;
	}
	
	@SuppressWarnings("deprecation")
	public static Date parseDate(String str) throws InvalidArgumentUiException{
		Date d = null;
		try{
			d = new Date(str.replace('@', ','));
		} catch (Exception e){
			throw new InvalidArgumentUiException("Invalid data:" + str);
		}
		return d;
	}

}
