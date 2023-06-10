<%@ page import="com.example.springpos.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.springpos.dao.ProductDao" %>
<%@ page import="com.example.springpos.service.ProductService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품 입고</title>
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

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        label {
            font-weight: bold;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            border-radius: 4px;
        }

        button:hover {
            background-color: #abf2ff;
        }

        .back {
            text-align: center;
            margin-top: 16px;
        }

        .back a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>상품 입고</h2>
    <form action="addProduct" method="post">
        <div>
            <label for="p_code">상품 코드:</label>
            <select id="p_code" name="p_code" required>
                <option value="" selected>상품 코드를 선택하세요</option>
                <%-- 상품 코드 가져오기 --%>
                <%
                    // Model 에서 상품리스트를 받아오기
                    List<Product> productList = (List<Product>)request.getAttribute("productList");
                    for (Product product : productList) {
                %>
                <option value="<%= product.getP_code() %>"><%= product.getP_code() %></option>
                <% } %>
            </select>
        </div>
        <div>
            <label for="re_date">입고일:</label>
            <input type="text" id="re_date" name="re_date" required>
        </div>
        <div>
            <label for="re_quantity">수량:</label>
            <input type="text" id="re_quantity" name="re_quantity" required>
        </div>
        <div>
            <button type="submit">입고</button>
        </div>
    </form>
    <div class="back">
        <a href="stockManagement">뒤로가기</a>
    </div>
</div>
</body>
</html>

