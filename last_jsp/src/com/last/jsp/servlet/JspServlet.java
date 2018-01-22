package com.last.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.last.jsp.service.MenuService;
import com.last.jsp.service.impl.MenuServiceImpl;

@WebServlet("/view/*")
public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JspServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.getWriter().append("Served at: ").append(req.getRequestURI());
		doProcess(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/index.jsp");
		MenuService ms = new MenuServiceImpl();
		ms.getMenuList(req);
		/*List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(int i=1;i<=5;i++) {
			Map<String,String> m = new HashMap<String,String>();
			m.put("name", "이름"+i);
			m.put("age", ""+i);
			m.put("id", "ID"+i);
			list.add(m);
		}
		req.setAttribute("list", list); //list를 그냥 보낼수 없어서 request에 담아쥼*/
		rd.forward(req, res);
	}

}
