package com.last.jsp.util;

public class URIParser {
	
	public static String getCommand(String uri, int type) {
		if(type==1) {
			return uri.substring(uri.lastIndexOf("/")+1);
		}
		return "";
	}
}
