동영상 Reference : [Java & Servlet](https://www.youtube.com/watch?v=jp7vtbLin-s&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd&index=8)

개념 Reference : [About Servlet](https://mangkyu.tistory.com/14)
               : [About_JSP](https://galid1.tistory.com/488)

개념 정리 된 글 : [Servlet/JSP](https://damin8.github.io/archive/?tag=Servlet_JSP)

### Servlet

- 웹 프로그래밍에서 클라이언트의 요청을 처리

- 결과를 다시 클라이언트에게 전송

- Servlet클래스의 규현 규칙을 지킨 자바 프로그래밍 기술

간단하게, Servlet = 자바를 사용하여 웹을 만들기 위해 필요한 기술

### Servlet 특징

- 클라이언트의 요청에 대해 **동적**으로 작동하는 웹 어플리케이션 컴포넌트

- html을 사용하여 요청에 응답

- Java Thread를 이용하여 동작

- MVC(Model View Controller) 패턴에서 Controller로 이용된다.

- UDP 보다 속도가 느리다.

- HTML 변경 시 Servlet을 재컴파일해야 하는 단점이 있다.

### JSP

- HTML에 Java 코드를 삽입하여 동적인 웹페이지를 만들 수 있는 기술

- MVC(Model View Controller) 패턴에서 View로 이용된다.

- Jsp로 작성된 프로그램은 JVM 상에서 처리되기 위해 서블릿 컨테이너(Tomcat)에 의해 Servlet으로 변환되어 필요한 작업 수행한 뒤 순수 HTML을 만들어 낸다.

### JSP 특징

- Servlet의 단점을 보완하고자 만든 Servlet 기반의 스크립트 기술

- Servlet 만으로 웹 프로그래밍을 할 수 있지만, View를 위해 너무 많은 코드 필요하는 현상 발생

- Jsp 파일이 Servlet으로 변환되는 과정은 오직 한번

- 따라서 많은 사용자의 요청이 있더라도 처리속도는 거의 유지된다.

- Jsp 파일에 대한 Servlet 객체가 있다면 재활용

### 왜 둘 다 쓰는지?

Servlet으로 JSP의 역학을 할 수 있고, 역도 성립한다.

그럼 왜 둘을 혼용하지? 라는 생각이 들었다.

오직 한 가지만 사용한다면 단점이 분명히 존재한다.

- 유지 보수가 힘들어진다.

- View Logic 과 Control Logic이 혼합되어서 혼잡해진다.

둘 을 나눠서 쓰게 된다면

- 유지 보수 및 확장 용이

- 개발자와 디자이너의 분업 용이

개발자에게 가장 중요한 유지 보수 및 확장이 용이하다는 점이 가장 매력있다고 생각한다.


