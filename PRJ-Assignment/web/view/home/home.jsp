<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ - Quản lý</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/home.css">
    <style>
        /* Body and General Layout */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            color: #333;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #28a745;
            color: #fff;
            padding: 20px;
            text-align: center;
            font-size: 26px;
            font-weight: bold;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }

        /* Navigation Styling */
        nav {
            background-color: #333;
            padding: 10px 0;
            text-align: center;
            margin-top: 80px;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        nav ul li {
            margin: 0 15px;
        }

        nav ul li a {
            color: #ffffff;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
            transition: color 0.3s ease;
        }

        nav ul li a:hover {
            color: #3c4e8a;
        }

        /* Main Content Area */
        .content {
            max-width: 1100px;
            margin: 120px auto 0;
            padding: 20px;
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }

        .card {
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            padding: 20px;
            flex: 1 1 300px;
            min-width: 300px;
            transition: transform 0.3s;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card h3 {
            color: #28a745;
            font-size: 20px;
            margin: 0 0 10px;
            font-weight: 600;
        }

        .card p {
            color: #666;
            font-size: 14px;
            margin: 5px 0 10px;
        }

        .btn-group {
            display: flex;
            gap: 10px;
            justify-content: flex-end;
        }

        .btn {
            background-color: #28a745;
            color: #ffffff;
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #2d3c69;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .content {
                flex-direction: column;
            }

            .card {
                min-width: 100%;
            }
        }
    </style>
</head>
<body>

<header>
    <h1>Home</h1>
</header>

<nav>

</nav>

<div class="content">
    <!-- Card for Employee List -->
    <div class="card">
        <h3>List Employee</h3>
        <p>Search employee information easily.</p>
        <br>
        <div class="btn-group">
            
            <button class="btn"><a href="/PRJ-Assignment/employee/filter">View All</a></button>
        </div>
    </div>
    
    <!-- Card for Production Plan -->
    <div class="card">
        <h3>Production Plan</h3>
        <p>Manage employee salaries with options for updates and detailed views.</p>
        <div class="btn-group">
            <button class="btn"><a href="/PRJ-Assignment/productionplan/create">Create</a></button>
            <button class="btn"><a href="/PRJ-Assignment/productionplan/list">View Production Plans</a></button>
        </div>
    </div>
    
    <!-- Card for Attendance -->
    <div class="card">
        <h3>Attendance</h3>
        <p>Manage employee attendance records and monitor company attendance status.</p>
        <div class="btn-group">
            <button class="btn">View Report</button>
            <button class="btn">Update Attendance</</button>
        </div>
    </div>
</div>

</body>
</html>
