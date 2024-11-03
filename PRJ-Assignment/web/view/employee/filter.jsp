<%-- 
    Document   : filter
    Created on : Oct 2, 2024, 11:06:11 AM
    Author     : sonnt-local
--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/style.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   
        <div class="container">
            <h1>Employee Filter</h1>

            <!-- Filter Form Section -->
            <form class="filter-form" action="filter" method="GET"> 
                <label class="form-label">Id:</label>
                <input type="text" name="eid" value="${param.eid}"/> 

                <label class="form-label">Name:</label>
                <input type="text" name="ename" value="${param.ename}"/> 

                <label class="form-label">Gender:</label>
                <input type="radio" ${param.gender ne null and param.gender eq "male"?"checked=\"checked\"":""} 
                       name="gender" value="male"/> Male
                <input type="radio" ${param.gender ne null and param.gender eq "female"?"checked=\"checked\"":""}
                       name="gender" value="female"/> Female
                <input type="radio" ${param.gender eq null or param.gender eq "both"?"checked=\"checked\"":""} 
                       name="gender" value="both"/> Both
                <br/>

                <label class="form-label">Dob - From:</label>
                <input type="date" name="from" value="${param.from}"/>
                <label>To:</label>
                <input type="date" name="to" value="${param.to}"/> 

                <label class="form-label">Address:</label>
                <input type="text" name="address" value="${param.address}"/> 

                <label class="form-label">Department:</label>
                <select name="did">
                    <option value="-1">ALL</option>
                    <c:forEach items="${requestScope.depts}" var="d">
                        <option ${param.did ne null and param.did eq d.id ?"selected=\"selected\"":""} 
                            value="${d.id}">${d.name}</option>
                    </c:forEach>
                </select>
                <br/>

                <label class="form-label">Phone Number:</label>
                <input type="text" name="phonenumber" value="${param.phonenumber}"/> 

                <input type="submit" value="Search"/>
            </form>

            <!-- Result Table Section -->
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Dob</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <th>Department</th>
                    <th>Salary</th>
                </tr>
                <c:forEach items="${requestScope.emps}" var="e">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.name}</td>
                        <td><c:choose>
                                <c:when test="${e.gender == true}">Male</c:when>
                                <c:when test="${e.gender == false}">Female</c:when>
                            </c:choose></td>
                        <td>${e.dob}</td>
                        <td>${e.address}</td>
                        <td>${e.phonenumber}</td>
                        <td>${e.dept.name}</td>
                        <td>${e.sals.salary}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>

</html>
