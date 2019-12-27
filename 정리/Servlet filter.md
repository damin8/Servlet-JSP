### Servlet filter

#### 개념

WAS (Web Application Server)에서 Servlet Container로 갈 때

사전, 사후 조건을 처리해 주는 Filter

Servlet filter를 이용해 Servlet을 실행시킬 수도 있고

Servlet filter를 이용해 Servlet을 실행시키지 않을 수도 있다.

사전, 사후 조건을 처리해 주기 때문에

자신의 프로그램이 사전, 사후 조건이 필요하다 싶으면 Servlet filter를 사용한다.

- Tomcat이 처음 실행될 때도 실행이 된다.

~~~
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request
			, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Before filter");
		chain.doFilter(request, response);
		System.out.println("After filter");
	}

}
~~~

chain.doFilter를 이용해 흐름을 그냥 넘겨서, 다음 servlet을 실행 시킨다.

시나리오

1. 요청이 온다.

2. Before filter를 출력한다.

3. 다음 filter 혹은 다음 servlet 실행 (doFilter = 흐름 그냥 보내기)

4. After filter를 출력한다.
