<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>헤더</title>
    <style>
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #f1f1f1;
        }

        .logo {
            text-align: center;
            flex-grow: 1;
        }

        .logo h1 {
            margin: 0;
        }


        h1 {
            font-weight: bold;
        }
        .header_a {
            text-decoration: none;
            color: #000000;
        }
    </style>
</head>
<body>
<header>
    <div class="logo">
        <a href="/" class="header_a"> <h1>POS System</h1> </a>
    </div>
</header>

</body>
</html>
