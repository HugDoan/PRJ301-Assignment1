
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border = "1px">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>SalaryLevelID</td>
            </tr>
            <c:forEach items="${requestScope.emps}" var="e">
                <tr>
                    <td>${e.employeeID}</td>
                    <td>${e.employeeName}</td>
                    <td>${e.salaryLevelID}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
