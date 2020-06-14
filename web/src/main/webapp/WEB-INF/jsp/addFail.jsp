<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/index.css?version=20121221"/>

    <link rel="stylesheet" type="text/css" href="resources/css/header.css?version=20121221"/>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>꿈가득도서관</title>
</head>
<body onpageshow="init()">
<div class="header header-trans">
    <div class="container">
        <div id="home-logo" onclick="goToLink('index')">
            <img id="logo-house" src="resources/img/accent-house.png" />
            <img id="logo-main" src="resources/img/accent-logo.png" />
        </div>
        <div id="nav-menu">
            <span onclick="goToLink('index')">홈</span>
            <span onclick="goToLink('list')">목록</span>
            <span onclick="goToLink('sortedList')">대여량 기준 정렬</span>
            <span onclick="goToLink('alreadyBorrow')">대여 된 책</span>
            <span onclick="goToLink('borrowAble')">대여 가능한 책</span>
            <span onclick="goToLink('borrow')">대여</span>
            <span onclick="goToLink('return')">반납</span>
            <span id="select" onclick="goToLink('add')">추가</span>
            <span onclick="search()">검색</span>
        </div>
        <div class="serach-field">
            <div class="search-box">
                <div class="option-box">
                    <select id="search-option">
                        <option value="title">이름</option>
                        <option value="author">저자</option>
                    </select>
                </div>
                <div class="input-box">
                    <input
                            id="search-input"
                            type="text"
                            placeholder="검색어를 입력하세요"
                            onKeypress="javascript:if(event.keyCode==13) {searchSumbit()}"
                    />
                </div>
                <div class="cancle-box" onclick="nav()">
                    X
                </div>
            </div>
        </div>
    </div>
</div>
<div class="article">
    <div class="article-wrapper">
        <div class="container">
            <div class="content">
                <div class="content-header">
                    도서 추가 실패<span id="header-descript"
                ><br/>도서 추가에 실패하였습니다 id가 중복되지는 않았을까요?</span
                >
                </div>
                <div class="content-main">
                    <div class="return-home">
                        <a href="list">돌아가기</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"/>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/header.js?version=20121221"></script>
</html>
