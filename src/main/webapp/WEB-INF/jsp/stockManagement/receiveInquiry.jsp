<%@ page import="com.example.springpos.entity.Receive" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>입고 조회</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 4px;
            padding: 20px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            text-align: left;
        }

        th {
            background-color: #f1f1f1;
            border: 1px solid #dddddd;
            border-bottom-width: 2px;
        }

        td {
            border: 1px solid #dddddd;
            padding: 8px;
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
    <h2>입고 조회</h2>
    <%-- Model 에서 List<Receive> 가져오기 --%>
    <% List<Receive> receiveList = (List<Receive>) request.getAttribute("receiveList"); %>
    <% if (receiveList != null && !receiveList.isEmpty()) { %>
    <table>
        <thead>
        <tr>
            <th>입고 코드</th>
            <th>상품 코드</th>
            <th>입고일</th>
            <th>수량</th>
        </tr>
        </thead>
        <tbody>
        <% for (Receive receive : receiveList) { %>
        <tr>
            <td><%= receive.getRe_code() %></td>
            <td><%= receive.getP_code() %></td>
            <td><%= receive.getRe_date() %></td>
            <td><%= receive.getRe_quantity() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>입고된 내역이 없습니다.</p>
    <% } %>
    <div class="back">
        <a href="stockManagement">뒤로가기</a>
    </div>
</div>
</body>
</html>
