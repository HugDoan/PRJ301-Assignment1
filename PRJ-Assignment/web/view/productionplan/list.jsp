<%-- 
    Document   : listdetail
    Created on : Nov 3, 2024, 9:13:22 PM
    Author     : Admin
--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/plist.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Production Plan List</title>
</head>

<body>
    <div class="container">
        <h1>Production Plan List</h1>
        <a href="/PRJ-Assignment/productionplan/create" class="create-button">Create</a>
        <table border="1px">
            <tr>
                <th class="table-header"><span class="label">ID</span></th>
                <th class="table-header"><span class="label">Plan Name</span></th>
                <th class="table-header"><span class="label">Start Date</span></th>
                <th class="table-header"><span class="label">End Date</span></th>
                <th class="table-header"><span class="label">Quantity</span></th>
                <th class="table-header"><span class="label">Product Name</span></th>
                <th class="table-header"><span class="label">Estimated Effort</span></th>
            </tr>

            <!-- Initialize a counter variable for the ID -->
            <c:set var="counter" value="1" scope="page" />

            <c:forEach items="${requestScope.plans}" var="p">
                <c:forEach var="i" begin="0" end="${p.headers.size()-1}">
                    <tr>
                        <c:if test="${i == 0}">
                            <!-- Use the counter variable for ID and increment it after each plan -->
                            <td rowspan="${p.headers.size()}">${counter}</td>
                            <td rowspan="${p.headers.size()}"><a href="detail?plid=${p.id}">${p.name}</a></td>
                            <td rowspan="${p.headers.size()}">${p.start}</td>
                            <td rowspan="${p.headers.size()}">${p.end}</td>
                            <!-- Increment the counter only once per plan -->
                            <c:set var="counter" value="${counter + 1}" />
                        </c:if>
                        <td class="quantity">${p.headers[i].quantity}</td>
                        <td class="product">${p.headers[i].product.name}</td>
                        <td class="estimated-effort">${p.headers[i].estimatedeffort}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
</body>
</html>


