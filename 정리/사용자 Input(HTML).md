### HTML 작성 (Get)

~~~
<body>
  <div>
    <form action="hello"> // hello는 servlet mapping 주소 -> http://.../hello
      <div>
        <label>"안녕하세요"를 몇 번 듣고 싶으세요?</label>
      </div>
      <div>
        <input type="text" name="cnt" /> // text 형식의 이름은 cnt -> http://.../hello?cnt=n
        <input type="submit" value="출력" /> // submit 버튼
      </div>
    </form>
  </div>
</body>
~~~

무조건 form 태그 안에!

Form 태그를 이용하여 사용자로 하여금 Request를 받아

Response를 해주는 방식

hello라는 문서에 query(cnt)

### HTML 작성 (Post)

~~~
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div>
    <form action="notice-reg"> 
      <div>
        <label>제목 :</label><input name="title" type="text"> // 쿼리 문의 title
      </div>
      <div>
       	<label>내용 :</label>
       	<textarea name="content"></textarea> // 쿼리 문의 content
      </div>
      <div>
        <input type="submit" value="등록" /> 
      </div>
    </form>
  </div>
</body>
</html>
~~~

이렇게 되면 문제점이 있다.

textarea의 무수히 많은 타자를 치게 된다면

URL의 길이가 한계가 있고, 여러가지 문제가 더 있다.

문서 (ex. notice-reg)의 전달 방식은 크게 2가지가 있다.

1. 그냥 default 방식으로 아무것도 쓰지 않는 것.

- 이렇게 되면 query들이 알아서 뒤에 붙게 된다.

2. 메서드를 붙인다.

- <form action="notice-reg"> -> <form action="notice-reg" method="post">

- 이렇게 되면 url에 아무것도 없다. (보안에 좋다)

- F12를 눌러서 확인할 수 있다.

