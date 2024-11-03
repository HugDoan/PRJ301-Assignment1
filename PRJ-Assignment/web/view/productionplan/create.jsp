<%-- 
    Document   : create
    Created on : Oct 16, 2024, 11:19:35 AM
    Author     : 
--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/create.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
    <div class="container">
        <h1>Create Production Plan</h1>
        <form action="create" method="POST">
            <label>Plan Name:</label>
            <input type="text" name="name" required /> 

            <label>From:</label>
            <input type="date" name="from" required />

            <label>To:</label>
            <input type="date" name="to" required />

            <label>Workshop:</label>
            <select name="did" required>
                <c:forEach items="${requestScope.depts}" var="d">
                    <option value="${d.id}">${d.name}</option>
                </c:forEach>
            </select>

            <table>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Estimated Effort</th>
                </tr>
                <c:forEach items="${requestScope.products}" var="p">
                    <tr>
                        <td>${p.name}<input type="hidden" name="pid" value="${p.id}"></td>
                        <td><input type="text" name="quantity${p.id}" required /></td>
                        <td><input type="text" name="effort${p.id}" required /></td>
                    </tr>    
                </c:forEach>
            </table>

            <input type="submit" value="Save" />
        </form>
    </div>
</body>
</html>
