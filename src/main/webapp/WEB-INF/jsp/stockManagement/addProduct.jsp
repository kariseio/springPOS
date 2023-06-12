<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <select id="p_code" name="p_code" required onchange="fillProductInfo()">
                <option value="" selected>상품 코드를 선택하세요</option>
                <%-- 상품 코드 가져오기 --%>
                <c:forEach var="product" items="${productlist}" varStatus="status">
                    <option value="${product.p_code}">${product.p_code}</option>
                </c:forEach>
            </select>
        </div>
        <!--상품 리스트 태그 저장 (Hidden) -->
        <c:forEach var="product" items="${productlist}" varStatus="status">
            <input type="hidden" name="productCodes" value="${product.p_code}">
            <input type="hidden" name="productNames" value="${product.p_name}">
        </c:forEach>
        <div>
            <label for="p_name">상품명:</label>
            <input type="text" id="p_name" name="p_name" readonly>
        </div>
        <div>
            <label for="re_date">입고일:</label>
            <input type="text" id="re_date" name="re_date" value="<%= new Timestamp(System.currentTimeMillis()) %>" required>
        </div>
        <div>
            <label for="re_quantity">수량:</label>
            <input type="text" id="re_quantity" name="re_quantity" required>
        </div>
        <div>
            <button type="submit" onclick="showProductInfo()">입고</button>
        </div>
    </form>
    <div class="back">
        <a href="stockManagement">뒤로가기</a>
    </div>
</div>
<script>
    function fillProductInfo() {
        let select = document.getElementById("p_code").value; // 사용자가 고른 상품 코드
        let name = document.getElementById("p_name"); // 상품 명

        let productNameList = document.getElementsByName("productNames");
        let productCodeList = document.getElementsByName("productCodes");

        for (let i = 0; i < productCodeList.length; i++) {
            if (productCodeList[i].value == select) { // 상품코드 비교
                name.value = productNameList[i].value;
                return;
            }
        }
        name.value = '상품을 골라주세요.'
    }
    function showProductInfo() {
        let date = document.getElementById("re_date").value;
        let name = document.getElementById("p_name").value;
        let quantity = document.getElementById("re_quantity").value;

        let productInfo = "상품 압고가 완료되었습니다.\n상품 명: " + name + "\n입고일: " + date + "\n수량: " + quantity;
        alert(productInfo);
    }
</script>
</body>
</html>

