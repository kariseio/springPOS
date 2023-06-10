<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>일일 통계</title>
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

        h3 {
            text-align: center;
            margin-bottom: 20px;
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

        h4 {
            font-weight: bold;
            margin-bottom: 0;
        }
    </style>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h3>일일 통계 - 일일 판매 정보</h3>
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
    <h4>최다 판매 제품: ${bestSeller}</h4>
    <h4 id="daySaleProfit"></h4>
</div>
<script>
    let daySaleProfit = document.getElementById("monthSaleProfit");
    let prices = document.getElementsByName("price");
    let sum = 0;

    for (let i=0; i<prices.length; i++){
        sum += prices[i].value;
    }
    daySaleProfit.value = ("월간 판매 수익: " + sum);
</script>
</body>
</html>
