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
    String count = req.getParameter("cnt");
    int cnt = 3;
    if(count != null && !count.equals(""))
      cnt = Integer.parseInt(count); // 서로 약속을 해야 한다 (서버는 cnt를 보낼 것을 알고 있어야 한다.)
              // 문자열이 오니까 parseInt를 이용해 Int로 변환
              
    for(int i=0;i<cnt;i++) {
    	out.println((i+1) +" 안녕하세요 <br>");
    }
      //이렇게 활용 가능
	}
}
