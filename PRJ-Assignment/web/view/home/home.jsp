<%-- 
    Document   : home
    Created on : Oct 20, 2024, 8:32:01 PM
    Author     : Admin
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<%
    // Kiểm tra xem người dùng đã đăng nhập hay chưa
    model.auth.User account = (model.auth.User) session.getAttribute("account");
    if (account == null) {
        // Nếu chưa đăng nhập, chuyển hướng về trang login
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <style>
        /* Style cho header */
        header {
            background-color: #f2f2f2;
            padding: 20px;
            text-align: center;
            font-size: 24px;
        }

        /* Style cho menu */
        nav {
            margin: 20px 0;
            text-align: center;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
        }

        nav ul li {
            display: inline;
            margin: 0 15px;
        }

        nav ul li a {
            text-decoration: none;
            font-size: 18px;
            color: #333;
        }

        nav ul li a:hover {
            color: #007BFF;
        }

        /* Style cho phần hiển thị bài báo */
        .articles {
            margin: 20px auto;
            width: 80%;
            border: 1px solid #ddd;
            padding: 20px;
        }

        .article {
            margin-bottom: 20px;
            border-bottom: 1px solid #ddd;
            padding-bottom: 15px;
        }

        .article h3 {
            font-size: 22px;
            color: #333;
        }

        .article p {
            font-size: 16px;
            color: #666;
        }
    </style>
</head>
<body>

    <!-- Header trống -->
    <header>
        <h1>Trang chủ</h1>
    </header>

    <!-- Thanh menu với các mục ProductionPlan, Employee, Attendant -->
    <nav>
        <ul>
            <li><a href="#">ProductionPlan</a></li>
            <li><a href="/PRJ-Assignment/employee/filter">Employee</a></li>
            <li><a href="#">Attendant</a></li>
        </ul>
    </nav>

    <!-- Khung hiển thị các bài báo -->
    <div class="articles">
        <div class="article">
            <h3>Tiêu đề bài báo 1</h3>
            <p>Nội dung tóm tắt của bài báo 1 sẽ được hiển thị ở đây...</p>
        </div>
        <div class="article">
            <h3>Tiêu đề bài báo 2</h3>
            <p>Nội dung tóm tắt của bài báo 2 sẽ được hiển thị ở đây...</p>
        </div>
        <!-- Bạn có thể thêm nhiều bài báo hơn tại đây -->
    </div>

</body>
</html>
