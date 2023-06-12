<%@ page import="com.example.springpos.entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>POS 시스템</title>
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

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .greeting {
            font-weight: bold;
        }

        .logout, .login {
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 8px 12px;
            border-radius: 4px;
        }

        .logout:hover, .login:hover {
            background-color: #45a049;
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

        .time {
            position: absolute;
            top: 20px;
            left: 20px;
        }
    </style>
</head>

<body>
<%@ include file="layout/header.jsp" %>
<div class="container">
    <div class="header">
        <%-- 로그인 했을 때 --%>
        <%
            Member member = (Member)session.getAttribute("Member");
            if(member != null) {
        %>
        <div class="greeting">
            <span id="memberName"> ${Member.getName()} </span>님 안녕하세요.
        </div>
        <a href="logout" class="logout">로그아웃</a>
        <%-- 로그인 안했을 때 --%>
        <% } else { %>
        <div class="greeting">
            <span>로그인을 해주세요.</span>
        </div>
        <a href="login" class="login">로그인</a>
        <% } %>
    </div>


    <div class="buttons">
        <a href="statistics" class="button">통계</a>
        <a href="stockManagement" class="button">재고 관리</a>
        <a href="sale" class="button">상품 판매</a>
        <a href="account" class="button">계정 관리</a>
    </div>

    <%
        if(member == null) {
    %>
    <script>
        const buttons = document.querySelectorAll('.button');

        buttons.forEach(button => {
            button.removeAttribute("href");
            button.style.backgroundColor = "#808080"; // 회색
            button.style.pointerEvents = "none";
            button.style.cursor = "not-allowed";
        });
    </script>

    <%
        }
    %>

</div>
<div class="time">
    <script>
        function updateTime() {
            let now = new Date();
            let hours = now.getHours();
            let minutes = now.getMinutes();
            let timeString = hours.toString().padStart(2, '0') + ':' + minutes.toString().padStart(2, '0');
            document.getElementById('currentTime').innerText = timeString;
        }

        setInterval(updateTime, 1000);
    </script>
    현재 시간: <span id="currentTime"></span>
</div>
</body>
</html>

