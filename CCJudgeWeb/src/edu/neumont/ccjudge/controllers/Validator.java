package edu.neumont.ccjudge.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;


public class Validator {
	public static final int NONE = -1;
	public static final int STRIP_TAGS = 1;
	public static final int ENTITIES = 2;
	
	public int validateInt(String i) throws ValidationException {
		int ret = 0;
		try {
			ret = Integer.parseInt(i);
		}
		catch(Exception e) {
			throw new ValidationException("Invalid id provided.  The id must be an integer greater than 0.", e);
		}
		return ret;
	}
	
	public double validateDouble(String i) throws ValidationException {
		double ret = 0;
		try {
			ret = Double.parseDouble(i);
		}
		catch(Exception e) {
			throw new ValidationException("Invalid double provided.", e);
		}
		return ret;
	}

	public String validateString(String s, int processing, int length) throws ValidationException {
		if (s==null) s = "";
		if (processing==STRIP_TAGS) s = s.replaceAll("<[^>]+>", "");
		else if (processing==ENTITIES) s = StringEscapeUtils.escapeHtml(s);
		if (length>-1) {
			if (s.length()>length) throw new ValidationException("String is longer than required length of "+length);
		}
		return s;
	}
	
	public String validateString(String s) throws ValidationException {
		return validateString(s, ENTITIES, 255);
	}
	
	public String validateText(String s) throws ValidationException {
		return validateString(s, ENTITIES, -1);
	}

	public Date validateDate(Map<String, String> parts) throws ValidationException {
		Calendar cal = Calendar.getInstance();
		try {
			if (parts.get("day")!=null) {
				int day = Integer.parseInt(parts.get("day"));
				cal.set(Calendar.DAY_OF_MONTH, day);
			}
			if (parts.get("month")!=null) {
				int month = Integer.parseInt(parts.get("month"));
				cal.set(Calendar.MONTH, month-1);
			}
			if (parts.get("year")!=null) {
				int day = Integer.parseInt(parts.get("year"));
				cal.set(Calendar.YEAR, day);
			}
			if (parts.get("hour")!=null) {
				int day = Integer.parseInt(parts.get("hour"));
				cal.set(Calendar.HOUR_OF_DAY, day);
			}
			if (parts.get("minute")!=null) {
				int day = Integer.parseInt(parts.get("minute"));
				cal.set(Calendar.MINUTE, day);
			}
		}
		catch(Exception e) {
			throw new ValidationException("Invalid data provided.", e);
		}
		
		return cal.getTime();
	}
}
