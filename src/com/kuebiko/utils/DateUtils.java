package com.kuebiko.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {
	
	public static Date dateFromString(String dateInString) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		 Date date=null;
	        try {
	             date = formatter.parse(dateInString);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date;
	}

}
