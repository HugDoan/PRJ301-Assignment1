<%-- 
    Document   : create
    Created on : Oct 16, 2024, 11:19:35 AM
    Author     : sonnt-local
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Production Plan List</title>
    <style>
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .delete-button {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 5px;
            cursor: pointer;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <h2>Production Plan List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>StartDate</th>
            <th>EndDate</th>
            <th>Quantity</th>
            <th>Product</th>
            <th>Estimation</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="plan" items="${productionPlans}">
            <tr>
                <td>${plan.plan.id}</td>
                <td><a href="details.jsp?pid=${plan.plan.id}">${plan.plan.name}</a></td>
                <td>${plan.plan.start}</td>
                <td>${plan.plan.end}</td>
                <td>${plan.quantity}</td>
                <td>${plan.product.name}</td>
                <td>${plan.estimatedeffort}</td>
                <td>
                    <form action="deletePlan" method="post" style="display:inline;">
                        <input type="hidden" name="planId" value="${plan.plan.id}">
                        <button type="submit" class="delete-button">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
