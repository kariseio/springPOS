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
    <form action="addProductDomain" method="post">
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
            <button id="addBtn" type="submit" onclick="showProductInfo()">상품 추가</button>
        </div>
    </form>
    <div class="back">
        <a href="stockManagement">뒤로가기</a>
    </div>
</div>
<script>
    function showProductInfo() {
        let price = document.getElementById("p_price").value;
        let name = document.getElementById("p_name").value;
        let quantity = document.getElementById("p_quantity").value;

        let productInfo = "새로운 상품 추가가 완료되었습니다.\n상품 명: " + name + "\n가격: " + price + "\n수량: " + quantity;
        alert(productInfo);
    }
</script>
</body>
</html>

