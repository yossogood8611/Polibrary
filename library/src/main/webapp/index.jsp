<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>모드 선택</title>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: sans-serif;
        }

        .box {
            width: 200px;
            height: 200px;
            border: 2px solid black;
            border-radius: 10px;
            padding: 15px;
            text-align: center;
            transition: border-color 0.3s, box-shadow 0.3s, transform 0.3s;
        }

        .box:hover {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
            transform: scale(1.01);
            margin-bottom: 10px;
            cursor: pointer;
        }

        .box-title {
            font-weight: bold;
            margin-top: 10px;
            margin-bottom: 20px;
            position: relative;
        }

        .box-title::after {
            content: "";
            position: absolute;
            left: calc(50% - 50%);
            width: calc(100%);
            bottom:-10px;
            border-bottom: 1px solid black;
        }

        .box-item {
            margin-top: 5px;
            margin-bottom: 5px;
            color: #999;
            text-align: left;
        }

        .box-item:before {
            content: "-";
            margin-right: 5px;
        }

        .box + .box {
            margin-left: 15px;
        }

        a {
            text-decoration: none; /* 밑줄 제거 */
            color: inherit; /* 상위 요소의 색상 상속 */
        }
        a:hover {
            color: inherit; /* 상위 요소의 색상 상속 */
        }
    </style>
</head>
<body>
<div class="container">
    <a href="${pageContext.request.contextPath}/main-page">
        <div class="box">
            <h2 class="box-title">관리자 모드</h2>
            <div class="box-item">도서 조회</div>
            <div class="box-item">도서 입고</div>
            <div class="box-item">도서 폐기</div>
        </div>
    </a>
    <div class="box">
        <h2 class="box-title">이용자 모드</h2>
        <div class="box-item">도서 조회</div>
        <div class="box-item">도서 구매/판매</div>
        <div class="box-item">도서 대여/반납</div>
        <div class="box-item">새로 입고된 책 보기</div>
    </div>
</div>
</body>
</html>


</style>
</head>
<body>
<div class="container">
    <div class="box">
        <h2 class="box-title">관리자 모드</h2>
        <div class="box-item">도서 조회</div>
        <div class="box-item">도서 입고</div>
        <div class="box-item">도서 폐기</div>
    </div>
    <div class="box">
        <h2 class="box-title">이용자 모드</h2>
        <div class="box-item">도서 조회</div>
        <div class="box-item">도서 구매/판매</div>
        <div class="box-item">도서 대여/반납</div>
        <div class="box-item">새로 입고된 책 보기</div>
    </div>
</div>
</body>
</html>
