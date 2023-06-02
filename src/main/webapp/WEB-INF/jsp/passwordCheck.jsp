<!DOCTYPE html>
<html>
<head>
    <title>비밀번호 확인</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }
        
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 4px;
            margin-top: 50px;
        }
        
        h2 {
            text-align: center;
            margin-bottom: 30px;
        }
        
        label {
            font-weight: bold;
        }
        
        input[type=password] {
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
    </style>
</head>
<body>
    <div class="container">
        <h2>비밀번호 확인</h2>
        <form action="passwordChange.jsp" method="post">
            <div>
                <label for="password">현재 비밀번호:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <button type="submit">확인</button>
            </div>
        </form>
    </div>
</body>
</html>
