<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
  <title>비밀번호 변경 완료</title>
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

    .main-button {
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
<%@ include file="../layout/header.jsp" %>
<div class="container">
  <h2>비밀번호 변경 완료</h2>
  <div class="success-message">
    <p>비밀번호가 성공적으로 변경되었습니다.</p>
  </div>
  <div class="main-button">
    <a href="/"><button>POS Main</button></a>
  </div>
</div>
</body>
</html>
