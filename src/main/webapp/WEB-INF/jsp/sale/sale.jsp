<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <label for="s_pname">상품 명 :</label>
            <select id="s_pname" name="s_pname" onchange="fillProductInfo()" required>
                <option value="" selected>상품 명을 선택하세요</option>
                <%-- model 에서 상품명 가져오기 --%>
                <c:forEach var="product" items="${productlist}" varStatus="status">
                    <option value="${product.p_name}">${product.p_name}</option>
                </c:forEach>
            </select>
        </div>

        <!--상품 리스트를 script 에서 참조하기 위해-->
        <c:forEach var="product" items="${productlist}" varStatus="status">
            <input type="hidden" name="productNames" value="${product.p_name}">
            <input type="hidden" name="productPrices" value="${product.p_price}">
            <input type="hidden" name="productQuantities" value="${product.p_quantity}">
        </c:forEach>

        <div class="column">
            <label for="p_quantity">재고 :</label>
            <input type="text" id="p_quantity" name="p_quantity" readonly>
        </div>

        <div class="column">
            <label for="p_price">상품 가격 :</label>
            <input type="text" id="p_price" name="p_price" readonly>
        </div>

        <div class="column">
            <label for="s_quantity">판매 수량 :</label>
            <input type="text" id="s_quantity" name="s_quantity" required>
        </div>

        <div class="column">
            <label for="s_date">판매일 :</label>
            <input type="text" id="s_date" name="s_date" value="<%= new Timestamp(System.currentTimeMillis()) %>">
        </div>

        <div class="column">
            <label for="s_price">판매가 : (최종 결제 금액)</label>
            <input type="text" id="s_price" name="s_price" value="">
        </div>

        <button id="calculateBtn" onclick="calculateTotal()" type="button">가격 계산하기</button>

        <button id="paymentBtn" type="submit" onclick="showProductInfo()">결제하기</button>
    </form>
</div>

<script>
    function fillProductInfo() {
        let select = document.getElementById("s_pname").value; // 사용자가 고른 상품 명
        let price = document.getElementById("p_price"); // 상품 가격 -> 설정해야함
        let quantity = document.getElementById("p_quantity"); // 재고 -> 설정해야함

        let productNameList = document.getElementsByName("productNames");
        let productPriceList = document.getElementsByName("productPrices");
        let productQuantityList = document.getElementsByName("productQuantities");

        for (let i = 0; i < productNameList.length; i++) {
            if (productNameList[i].value == select) { // 상품명이 같은지 비교
                price.value = productPriceList[i].value;
                quantity.value = productQuantityList[i].value;
                return;
            }
        }
        price.value = '상품을 골라주세요.';
        quantity.value = '상품을 골라주세요.';
    }

    function calculateTotal() {
        let quantityInput = document.getElementById("s_quantity");
        let priceInput = document.getElementById("p_price");
        let pQuantityInput = document.getElementById("p_quantity");
        let totalPriceInput = document.getElementById("s_price");

        let quantity = parseInt(quantityInput.value, 10); // 판매 수량
        let price = parseFloat(priceInput.value); // 상품 가격
        let pQuantity = parseInt(pQuantityInput.value, 10); // 재고

        if (isNaN(quantity) || isNaN(price) || isNaN(pQuantity)) {
            alert("판매수량 : 올바른 숫자 값을 입력해주세요.");
            totalPriceInput.value = "";
            return;
        }

        if (quantity > pQuantity) {
            alert("재고가 부족합니다!\n수량을 다시 설정해주시거나 추가입고가 필요합니다.");
            totalPriceInput.value = "";
            return;
        }

        let totalAmount = quantity * price;
        totalPriceInput.value = totalAmount;
    }

    function showProductInfo() {
        let date = document.getElementById("s_date").value;
        let name = document.getElementById("s_pname").value;
        let quantity = document.getElementById("s_quantity").value;
        let price = document.getElementById("s_price").value;

        let productInfo = "상품 판매가 완료되었습니다.\n상품 명: " + name + "\n수량: " + quantity +"\n판매일: " + date + "\n결제액: " + price;
        alert(productInfo);
    }


</script>

</body>
</html>
