<%-- 
    Document   : home
    Created on : Oct 20, 2024, 8:32:01 PM
    Author     : Admin
--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/home.css">
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
            <li><a href="/PRJ-Assignment/productionplan/list">ProductionPlan</a></li>
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
