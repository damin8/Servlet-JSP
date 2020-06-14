<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/index.css?version=20121221" />
        <link rel="stylesheet" type="text/css" href="resources/css/header.css?version=20121221" />
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>꿈가득도서관</title>
        <!-- 합쳐지고 최소화된 최신 CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />

        <!-- 부가적인 테마 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css" />
    </head>
    <body>
    <div class="header">
        <div class="container">
            <img id="logo-house" src="resources/img/white-house.png" />
            <img id="logo-main" src="resources/img/white-logo.png" />
            <span id="nav-menu">
                    <span onclick="goToLink('list')">목록</span>
                    <span onclick="goToLink('sortedList')">대여량 기준 정렬</span>
                    <span onclick="goToLink('alreadyBorrow')">대여 된 책</span>
                    <span onclick="goToLink('borrowAble')">대여 가능한 책</span>
                    <span onclick="goToLink('borrow')">대여</span>
                    <span onclick="goToLink('return')">반납</span>
                    <span onclick="goToLink('add')">추가</span>
                </span>
        </div>
    </div>
        <div class="banner">
            <div class="black-mask">
                <div class="container">
                    <div class="content">
                        <span id="title"
                        >꿈이 가득한 새로운<br />
                            인터넷 도서관</span
                        >
                        <div class="text-box">
                            <p>
                                Book is&nbsp;
                                <span class="word wisteria">tasty.</span>
                                <span class="word belize">wonderful.</span>
                                <span class="word pomegranate">fancy.</span>
                                <span class="word green">beautiful.</span>
                                <span class="word midnight">cheap.</span>
                            </p>
                        </div>
                        <br />

                        <br /><br />
                        <span id="descript">
                            경험해보세요! <br />
                            대출, 반납, 신청 까지 집에서 뚝딱! 꿈가득입니다
                        </span>

                        <br />
                        <br />
                        <br />
                        <a href="list" id="get-started"> 시작하기</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/header.js?version=20121221"></script>
        <script src="resources/js/index.js?version=20121221"></script>
    </body>
</html>
