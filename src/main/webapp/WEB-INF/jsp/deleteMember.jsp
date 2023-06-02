<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>계정 삭제 완료</title>
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

        .success-message {
            text-align: center;
            margin-bottom: 20px;
        }

        .login-button {
            text-align: center;
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
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>계정 삭제 완료</h2>
    <div class="success-message">
        <p>계정이 성공적으로 삭제되었습니다.</p>
    </div>
    <div class="login-button">
        <a href="login.jsp"><button>Login</button></a>
    </div>
</div>
</body>
</html>
