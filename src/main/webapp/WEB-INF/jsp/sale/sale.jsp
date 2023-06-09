<%@ page import="com.example.springpos.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품 판매</title>
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

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .column {
            margin-bottom: 20px;
        }

        .column label {
            font-weight: bold;
        }

        .column select,
        .column input[type=text] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 4px;
        }

        #totalAmount {
            font-weight: bold;
            text-align: center;
            margin-top: 30px;
        }

        #calculateBtn,
        #paymentBtn {
            display: block;
            margin: 30px auto 0;
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
            font-weight: bold;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        #calculateBtn:hover,
        #paymentBtn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <h2>상품 판매</h2>

    <form action="sale" method="post">
        <div class="column">
            <label for="p_code">상품 코드 :</label>
            <select id="p_code" name="p_code" onchange="fillProductInfo()" required>
                <option value="" selected>상품 코드를 선택하세요</option>
                <%-- 상품 코드 옵션 생성 --%>
                <% List<Product> productList = (List<Product>) request.getAttribute("productList"); %>
                <% for (Product product : productList) { %>
                <option value="<%= product.getP_code() %>"><%= product.getP_code() %></option>
                <% } %>
            </select>
        </div>

        <div class="column">
            <label for="p_name">상품 명 :</label>
            <input type="text" id="p_name" name="p_name" readonly>
        </div>

        <div class="column">
            <label for="p_price">가격 :</label>
            <input type="text" id="p_price" name="p_price" readonly>
        </div>

        <div class="column">
            <label for="p_quantity">수량 :</label>
            <input type="text" id="p_quantity" name="p_quantity" required>
        </div>

        <div id="totalAmount"></div>

        <button id="calculateBtn" onclick="calculateTotal()">가격 계산하기</button>

        <button id="paymentBtn" type="submit">결제하기</button>
    </form>
</div>

<script>
    function fillProductInfo() {
        let select = document.getElementById("p_code");
        let productName = document.getElementById("p_name");
        let price = document.getElementById("p_price");

        // 선택한 상품 코드에 맞는 상품명과 가격 가져오기
        let selectedProduct = select.options[select.selectedIndex].value;
        let productList = <%= productList %>;

        for (let i = 0; i < productList.length; i++) {
            if (productList[i].code === selectedProduct) {
                productName.value = productList[i].p_name;
                price.value = productList[i].p_price;
                break;
            }
        }
    }

    function calculateTotal() {
        let quantity = document.getElementById("p_quantity").value;
        let price = document.getElementById("p_price").value;
        let totalAmount = quantity * price;
        document.getElementById("totalAmount").innerText = '총액 : ' + totalAmount + '원';
    }

</script>

</body>
</html>
