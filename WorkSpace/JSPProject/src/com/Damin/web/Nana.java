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
	  rep.setCharacterEncoding("UTF-8"); // ����ڰ� ������ �ڵ� ����� ����!
    rep.setContentType("text/html; charset=UTF-8"); // �޾��� �� � ������� �ؼ��Ұų� ����
    PrintWriter out = rep.getWriter();
    String count = req.getParameter("cnt");
    int cnt = 3;
    if(count != null && !count.equals(""))
      cnt = Integer.parseInt(count); // ���� ����� �ؾ� �Ѵ� (������ cnt�� ���� ���� �˰� �־�� �Ѵ�.)
              // ���ڿ��� ���ϱ� parseInt�� �̿��� Int�� ��ȯ
              
    for(int i=0;i<cnt;i++) {
    	out.println((i+1) +" �ȳ��ϼ��� <br>");
    }
      //�̷��� Ȱ�� ����
	}
}
