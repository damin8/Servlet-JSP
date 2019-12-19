package com.Damin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse rep) throws IOException, ServletException
	{
	  rep.setCharacterEncoding("UTF-8"); // 사용자가 보내는 코딩 방식을 결정!
	  rep.setContentType("text/html; charset=UTF-8"); // 받았을 때 어떤 방식으로 해석할거냐 결정
	  PrintWriter out = rep.getWriter();
	  for(int i=1;i<=100;i++) {
		  out.println((i)+" : 성경준 병신<br >");
	  }
	}
}
