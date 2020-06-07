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
<c:forEach var="n" items="${books }">
    <tr>
        <td>${n.price }</td>
        <td class="title indent text-align-left">${n.title}
            <span></span>
        </td>
        <td>${n.author }</td>
    </tr>
</c:forEach>
</body>
</html>
