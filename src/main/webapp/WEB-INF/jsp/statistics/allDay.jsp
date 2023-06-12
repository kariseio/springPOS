<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>전체 통계</title>
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
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #dddddd;
        }

        th {
            background-color: #f2f2f2;
        }

        h3 {
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center;
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
    <h3>전체 통계 - 통합 판매 정보</h3>
    <table>
        <thead>
        <tr>
            <th>상품명</th>
            <th>판매일</th>
            <th>판매량</th>
            <th>매출</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sale" items="${salesList}">
            <tr>
                <td>${sale.s_pname}</td>
                <td>${sale.s_date}</td>
                <td>${sale.s_quantity}</td>
                <td name="price">${sale.s_price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3>최다 판매 제품: ${bestSeller}</h3>
    <h3 id="SaleProfit"></h3>
    <div class="back">
        <a href="statistics">뒤로가기</a>
    </div>
</div>
<script>
    let SaleProfit = document.getElementById("SaleProfit");
    let prices = document.getElementsByName("price");
    let sum = 0;

    for (let i=0; i<prices.length; i++){
        sum += parseInt(prices[i].textContent);
    }
    SaleProfit.textContent = ("통합 판매 수익: " + sum + " 원");
</script>
</body>
</html>
