Servlet을 import 시켜줘야 하는데

프로젝트 build path에서 libraries 설정해주면 된다. (External Jars)

~~~
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloWorld extends HttpServlet 
{
	public void service(HttpServletRequest request
			,HttpServletResponse response) 
					throws IOException,ServletException
	{
		OutputStream os = response.getOutputStream();
		PrintStream out = new PrintStream(os,true);
		// 원래 버퍼를 다 채워야 보내는데, 내가 다 버퍼를 채우지 못하더라도 보내라!!! = true
		out.println("Hello Servlet!!");
		// 이렇게 되면 사용자에게 Hello Servlet!! 표시 
    
    더 간단하게
    OutputStream os = response.getOutputStream();
		PrintStream out = new PrintStream(os,true);
    
    -> PrintWriter out = response.getWriter(); 로 바꿔줄 수 있다.
	}
}

~~~
