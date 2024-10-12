<%-- 
    Document   : productionPlan
    Created on : Sep 27, 2024, 10:34:28 AM
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../master/shortprofile.jsp"></jsp:include> 
        
            <table border = "1px">
                <tr>
                    <td>Product ID</td>
                    <td>Product Name</td>
                    <td>Quantity(unit: piece)</td>
                </tr>
            <c:forEach items="${requestScope.pl}" var="p">
                <tr>
                    <td>${p.pId}</td>
                    <td>${p.pName}</td>
                    <td>${p.quantity}</td>
                </tr>
            </c:forEach>
        </table>

        <table border = "1px">
            <tr>
                <td>Date</td>
                <td>Product ID</td>
                <td>Product Name</td>
                <td>Shirft</td>
                <td>Quantity(unit: piece)</td>
                <td>Note</td>
            </tr>
            <c:forEach items="${requestScope.ppl}" var="pp">
                <tr>
                    <td>${pp.date}</td>
                    <td>${pp.pId}</td>
                    <td>${pp.pName}</td>
                    <td>${pp.shirftId}</td>
                    <td>${pp.quantity}</td>
                    <td>${pp.node}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
