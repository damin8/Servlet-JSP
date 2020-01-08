package com.Damin.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc")
public class Calc extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String v = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v_ = 0;
		if(!v.equals("")) v_ = Integer.parseInt(v);
		
		if(op.equals("=")) {
			//int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v_;
			int result = 0;
			String op_ = (String)session.getAttribute("op");
			//String op_ = (String)application.getAttribute("op");
			if(op.equals("+")) result = x + y;
			else result = x - y;
		}
		else {
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			session.setAttribute("value", v);
			session.setAttribute("op", op);
		}
	}

}
