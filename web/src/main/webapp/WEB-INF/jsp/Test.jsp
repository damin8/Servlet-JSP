<%--
  Created by IntelliJ IDEA.
  User: damin
  Date: 2020-06-07
  Time: 오후 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/create" method="post"> 제목 : <input type="text" name="title"/> <br/>
    작가 : <input type="text" name="author"/> <br/>
    가격 : <input type="text" name="price"/> <br/>
    <input type="submit" value="서버전달"/> </form>
</body>
</html>
