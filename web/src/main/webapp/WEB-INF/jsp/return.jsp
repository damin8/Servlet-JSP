<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/index.css" />

        <link rel="stylesheet" type="text/css" href="resources/css/header.css" />
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>꿈가득도서관</title>
    </head>
    <script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
    </script>
    <body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
        <div class="header header-trans">
            <div class="container">
                <img id="logo-house" src="resources/img/accent-house.png" />
                <img id="logo-main" src="resources/img/accent-logo.png" />
                <span id="nav-menu">
                    <span onclick="goToLink('index')">홈</span>
                    <span onclick="goToLink('list')">목록</span>
                    <span onclick="goToLink('sortedList')">대여량 기준 정렬</span>
                    <span onclick="goToLink('alreadyBorrow')">대여 된 책</span>
                    <span onclick="goToLink('borrowAble')">대여 가능한 책</span>
                    <span onclick="goToLink('borrow')">대여</span>
                    <span id="select" onclick="goToLink('return')">반납</span>
                    <span onclick="goToLink('add')">추가</span>
                </span>
            </div>
        </div>
        <div class="article">
            <div class="article-wrapper">
                <div class="container">
                    <div class="content">
                        <div class="content-header">
                            반납 <span id="header-descript"><br />성실한 반납은 의무입니다!</span>
                        </div>
                        <div class="content-main">
                            <div class="table">
                                <div class="book-return">
                                    <div class="book-header">
                                        <div class="book-header-col" id="id">아이디</div>
                                        <div class="book-header-col" id="name">이름</div>
                                        <div class="book-header-col" id="author">저자</div>
                                        <div class="book-header-col" id="price">가격</div>
                                        <div class="book-header-col" id="borrow-flag">대여 가능 여부</div>
                                        <div class="book-header-col" id="borrow-count">대여 횟수</div>
                                    </div>
                                    <!-- 아이템을 여기다가 넣으면 됩니다 -->
                                    <c:forEach var="book" items="${books }">
                                        <div class="book-item">
                                            <div class="book-item-col" id="id">${book._id }</div>
                                            <div class="book-item-col" id="name">${book.title }</div>
                                            <div class="book-item-col" id="author">${book.author }</div>
                                            <div class="book-item-col" id="price">${book.price }</div>
                                            <div class="book-item-col" id="borrow-flag">${book.rent }</div>
                                            <div class="book-item-col" id="borrow-count">${book.rentCount }</div>
                                            <div class="book-item-col" id="return" onclick="handleReturn(this)">반납</div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css" />

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/header.js"></script>
    <script src="resources/js/return.js"></script>
</html>
