<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>계정 관리</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }

        .container {
            max-width: 400px;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 4px;
            margin: 50px auto 0;
        }

    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>계정 관리</h2>
    <div class="message">
        <p>계정을 관리합니다.</p>
    </div>
    <div class="buttons">
        <a href="statistics" class="button">로그아웃</a>
        <a href="stockManagement" class="button">비밀번호 변경</a>
        <a href="POSMain" class="button">POS Main</a>
    </div>
</div>
</body>
</html>
