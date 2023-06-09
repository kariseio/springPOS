<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>새 상품 추가</title>
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
    <h2>새 상품 추가</h2>
    <form action="#" method="post">
        <div>
            <label for="p_code">상품 코드:</label>
            <input type="text" id="p_code" name="p_code" required>
        </div>
        <div>
            <label for="p_name">상품 이름:</label>
            <input type="text" id="p_name" name="p_name" required>
        </div>
        <div>
            <label for="p_quantity">개수:</label>
            <input type="text" id="p_quantity" name="p_quantity" required>
        </div>
        <div>
            <label for="p_price">가격:</label>
            <input type="text" id="p_price" name="p_price" required>
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

