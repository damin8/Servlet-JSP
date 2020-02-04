package com.Damin.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ServletContext application = request.getServletContext();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		String exp = "";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		String v = request.getParameter("value");
		String op = request.getParameter("operator");
		String dot = request.getParameter("dot");

		if (op != null && op.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (op != null && op.equals("C")) {
			exp = "";
		} else {
			exp += (v == null) ? "" : v;
			exp += (op == null) ? "" : op;
			exp += (dot == null) ? "" : dot;
		}
		Cookie expCookie = new Cookie("exp", exp);
		if (op != null && op.equals("C"))
			expCookie.setMaxAge(0);
		expCookie.setPath(""); // 이거 안해주면 루트에 저장된다 -> 모든 url에 저장 된다
		response.addCookie(expCookie);
		response.sendRedirect("calcpage");
	}
}
