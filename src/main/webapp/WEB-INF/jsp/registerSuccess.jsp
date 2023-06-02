<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>회원가입 완료</title>
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

    .welcome-message {
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
  <h2>회원가입 완료</h2>
  <div class="welcome-message">
    <p>회원가입이 성공적으로 완료되었습니다. 환영합니다!</p>
  </div>
  <div class="login-button">
    <a href="login.jsp"><button>로그인하기</button></a>
  </div>
</div>
</body>
</html>

