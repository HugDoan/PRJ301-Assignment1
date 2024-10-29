<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Production Plan List</title>
    </head>
    <body>
        <h2>Production Plan List</h2>
        <table border="1px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Quantity</th>
                <th>Product</th>
                <th>Estimation</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="planHeader" items="${productionPlans}">
                <tr>
                    <!-- ProductionPlanHeader ID -->
                    <td>${planHeader.id}</td>
                    
                    <!-- Link to Production Plan details page using the ProductionPlan name -->
                    <td><a href="details.jsp?pid=${planHeader.plan.id}">${planHeader.plan.name}</a></td>
                    
                    <!-- Start and End dates from ProductionPlan -->
                    <td>${planHeader.plan.start}</td>
                    <td>${planHeader.plan.end}</td>
                    
                    <!-- Quantity and Estimated Effort from ProductionPlanHeader -->
                    <td>${planHeader.quantity}</td>
                    <td>${planHeader.product.name}</td>
                    <td>${planHeader.estimatedeffort}</td>
                    
                    <!-- Delete button with form submission -->
                    <td>
                        <form action="deletePlan" method="post" style="display:inline;">
                            <input type="hidden" name="planId" value="${planHeader.id}">
                            <button type="submit" class="delete-button">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
