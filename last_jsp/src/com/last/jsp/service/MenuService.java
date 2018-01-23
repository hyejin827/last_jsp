package com.last.jsp.service;

import javax.servlet.http.HttpServletRequest;

public interface MenuService extends Service{
	public void getMenuList(HttpServletRequest req);
}
