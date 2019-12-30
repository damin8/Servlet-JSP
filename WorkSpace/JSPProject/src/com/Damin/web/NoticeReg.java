package com.Damin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse rep) 
			throws IOException, ServletException
	{
	  rep.setCharacterEncoding("UTF-8"); // ����ڰ� ������ �ڵ� ����� ����!
	  rep.setContentType("text/html; charset=UTF-8"); // �޾��� �� � ������� �ؼ��Ұų� ����
	  PrintWriter out = rep.getWriter();
	  String title = req.getParameter("title");
	  String content = req.getParameter("content");
	  // �̰� Ȱ���ؼ� DB�� ���� �ְų�, ���� ����� Ȱ��
	  out.println(title);
	  out.println(content);
	}
}
