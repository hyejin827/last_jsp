package com.last.jsp.factory;

import java.util.HashMap;
import java.util.Map;

import com.last.jsp.service.Service;
import com.last.jsp.service.impl.MenuServiceImpl;

public class ServiceFactory {
	
	private ServiceFactory() {
		
	}
	public static ServiceFactory getInstance() {
		return new ServiceFactory();
	}
	
	private static Map<String,Service> serviceMap;
	static {
		serviceMap = new HashMap<String,Service>();
	}
	
	private void initInstance(String serviceName) {
		if(serviceName.equals("menu")) {
			serviceMap.put("menu", new MenuServiceImpl());
		}
	}
	
	public Service getService(String serviceName) {
		if(!serviceMap.containsKey(serviceName)) { //containsKey: 이 키가 있닝?
			initInstance(serviceName);
		}
		return serviceMap.get(serviceName);
	}
}
