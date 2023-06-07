<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
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
            background-color: #45a049;
        }

        .signup {
            text-align: center;
            margin-top: 16px;
        }

        .signup a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>회원가입</h2>
    <form action="registerSuccess" method="post">
        <div>
            <label for="id">아이디:</label>
            <input type="text" id="id" name="id" required>
        </div>
        <div>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="email">이메일:</label>
            <input type="text" id="email" name="email" required>
        </div>
        <div>
            <button type="submit">가입하기</button>
        </div>
    </form>
    <div class="signup">
        이미 계정이 있으신가요? <a href="login">로그인</a>
    </div>
</div>
</body>
</html>

