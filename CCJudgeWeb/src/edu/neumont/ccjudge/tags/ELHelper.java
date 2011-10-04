package edu.neumont.ccjudge.tags;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.tecnick.htmlutils.htmlentities.HTMLEntities;

@SuppressWarnings("unchecked")
public class ELHelper {
	
	public static boolean listContains(List list, Object o) {
		return list.contains(o);
	}
	
	public static int collectionSize(Collection list) {
		return list.size();
	}
	
	public static Date now() {
		return new Date();
	}
	
	public static int compareDates(Date d1, Date d2) {
		return d1.compareTo(d2);
	}
	
	public static String htmlentities(String s) {
		return HTMLEntities.htmlentities(s);
	}
}
