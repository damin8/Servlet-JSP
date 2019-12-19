### Eclipse를 이용한 Servlet Programming

Project 안에 있는 WebContent가 홈 디렉터리이다.

Project를 개발할 때 Root에 해당되는 프로젝트는 Context명을 갖지 않는게 좋다.

~~~
Project 우클릭 -> Web Project Settings -> Context root : / 로 변경

이때! 켜져있던 Tomcat Server 껐다가 다시 켜주기!
~~~

### Annotation으로 Servlet Mapping 설정

web.xml -> web-app 에 있는 metadata-complet = "true" 에서 "false"로 변경해주기

후에 클래스 위에 Annotation 설정!

~~~
@WebServlet("/hi") 써주기!!

Annotation을 이용하면 협업에도 훨씬 도움이 된다!
~~~

### Servlet 출력 형식 지정

Java를 예를 들어보자

~~~
OutputStream out = new OuptputStream();

for(int i=0;i<100;i++)
  out.println("hi");
~~~

이런식으로 코드가 작성이 되어 있을 때

크롬 브라우저로 켰을 때와

Microsoft Edge 브라우저로 켰을 때 다르게 표시된다.

왜?

Microsoft Edge 브라우저는 html로 해석하고

크롬 브라우저는 text로 해석하기 때문이다.

이를 보면, 각 브라우저들이 컨텐츠 형식을 알려주지 않은 경우에는 자의적인 해석을 하는 것을 볼 수 있다.

~~~
PrintWriter out = rep.getWriter();

for(int i=0;i<100;i++)
  out.println("hi<br >");
~~~

따라서 이렇게 코드를 치면

이번에는 Microsoft Edge 브라우저는 잘 뜨지만

크롬 브라우저는 이상하게 뜨게 된다.

#### 따라서 출력 형식을 지정해줘야 한다!

### 한글과 콘텐츠 형식 출력하기

기본적으로 웹서버에서 클라이언트로 보내는 Encoding 방식은 ISO-8859-1 이다.

이런 방식은 1Byte씩 보내게 되는데, 한글은 2Byte씩 보내서 표현을 해야 한다.

(이런 방식은 ??가 뜨게 된다.)

UTF-8 은 2Byte씩 보내지만 웹 브라우저가 다른 코드로 잘못 해석한 경우

(이런 방식은 띏뗅똟 가 뜨게 된다.)

#### 어떻게 하면 한글을 보낼 수 있을까?

~~~
HttpServletResponse 파라미터를 이용하자!

public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse rep) throws IOException, ServletException
	{
	  rep.setCharacterEncoding("UTF-8"); // 사용자가 보내는 코딩 방식을 결정!
    rep.setContentType("text/html; charset=UTF-8"); // 받았을 때 어떤 방식으로 해석할거냐 결정
	}
}
~~~

이렇게 한글을 출력 할 수 있다.

### 입력(Query String)

URL에 

1. http://localhost/hello

2. http://localhost/hello?cnt=3

이렇게 올 수 있다.

여기서 ?cnt=3 이 QueryString이 된다!

이 부분은 Request 입력 부분을 활용하자!

~~~
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse rep) throws IOException, ServletException
	{
	  rep.setCharacterEncoding("UTF-8"); // 사용자가 보내는 코딩 방식을 결정!
    rep.setContentType("text/html; charset=UTF-8"); // 받았을 때 어떤 방식으로 해석할거냐 결정
    
    int cnt = Integer.parseInt(req.getParameter("cnt")); // 서로 약속을 해야 한다 (서버는 cnt를 보낼 것을 알고 있어야 한다.)
              // 문자열이 오니까 parseInt를 이용해 Int로 변환
              
    for(int i=0;i<cnt;i++)
      //이렇게 활용 가능
	}
}
~~~

기본값도 설정해줘야 한다.

URL에 위의 코드를 적용하면

1. http://localhost/hello?cnt=3 -> "3" 이 올 것이고

2. http://localhost/hello?cnt= -> ""이 올 것이고

3. http://localhost/hello? -> null

4. http://localhost/hello -> null

가 올 수 있다.

따라서

~~~
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse rep) throws IOException, ServletException
	{
	  rep.setCharacterEncoding("UTF-8"); // 사용자가 보내는 코딩 방식을 결정!
    rep.setContentType("text/html; charset=UTF-8"); // 받았을 때 어떤 방식으로 해석할거냐 결정
    
    String count = req.getParameter("cnt");
    int cnt = 3;
    if(count != null && count.equals(""))
      cnt = Integer.parseInt(count); // 서로 약속을 해야 한다 (서버는 cnt를 보낼 것을 알고 있어야 한다.)
              // 문자열이 오니까 parseInt를 이용해 Int로 변환
              
    for(int i=0;i<cnt;i++)
      //이렇게 활용 가능
	}
}

~~~
