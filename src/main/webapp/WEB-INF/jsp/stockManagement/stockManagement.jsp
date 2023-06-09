<%@ page import="com.example.springpos.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>재고 관리</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 4px;
            padding: 20px;
            position: relative;
        }

        h3 {
            text-align: center;
            margin-bottom: 30px;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }


        .buttons {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            grid-gap: 20px;
        }

        .button {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
            padding: 20px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #45a049;
        }

    </style>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <div class="header">
        <h3>상품의 재고를 관리합니다.</h3>
    </div>

    <div class="buttons">
        <a href="addProductDomain" class="button">새 상품 추가</a>
        <a href="updateProduct" class="button">상품 수정</a>
        <a href="receiveInquiry" class="button">입고 조회</a>
        <a href="addProduct" class="button">상품 입고</a>
    </div>
</div>
</body>
</html>
