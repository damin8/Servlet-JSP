### Servlet Class

Servlet Class들은 ROOT/WEB-INF/classes/ 안에 넣기!

이것은 약속되어 있는 것.

규칙이 잘못된다면 class를 찾을 수 없음.

~~~
패키지 같은 부분은 폴더를 따로 또 만들어 주기!
~~~

Tomcat에서의 WEB INF는 특별한 의미를 갖는다.

1. 비공개 영역

2. 사용자로 하여금 절대 쓰지 못하게

#### 그러면 사용자로 하여금 어떻게 받는가?

GET 1/2/3/4 이런식으로 URL을 보내면

서버쪽에서는 그 URL과 매핑된 Servlet 코드를 찾아서 실행한다.

~~~
web.xml 수정!

web-app 밑으로 추가!

<servlet>
  <servlet-name>hw</servlet-name>
  <servlet-class>helloworld</servlet-class>
</servlet>

<servlet-mapping>
  <servlet-name>da</servlet-name>
  <url-pattern>/Damin</url-pattern>
</servlet-mapping>

HelloWorld라는 Class를 Damin으로 매핑!

http://localhost/Damin을 받게 되면

웹서버는 Damin을 찾아보고, 없다면 WAS(Tomcat)으로 넘긴다!

WAS(Tomcat)는 매핑되는 Class 찾는다!

HelloWorld Servlet Class를 실행시켜 준다.
~~~






















