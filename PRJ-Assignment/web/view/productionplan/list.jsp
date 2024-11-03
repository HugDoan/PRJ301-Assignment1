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
        <h1>Danh sách Kế hoạch Sản xuất</h1>
        <table border="1px">
            <tr>
                <td style="font-weight: bold">ID</td>
                <td style="font-weight: bold">Tên kế hoạch</td>
                <td style="font-weight: bold">Ngày bắt đầu</td>
                <td style="font-weight: bold">Ngày kết thúc</td>
                <td style="font-weight: bold">Số lượng</td>
                <td style="font-weight: bold">Tên sản phẩm</td>
                <td style="font-weight: bold">Dự toán</td>
            </tr>

            <c:forEach items="${requestScope.plans}" var="p">
                <tr class="even">
                    <td rowspan="${p.headers.size()}">${p.id}</td>
                    <td rowspan="${p.headers.size()}"><a href="detail?plid=${p.id}">${p.name}</a></td>
                    <td rowspan="${p.headers.size()}">${p.start}</td>
                    <td rowspan="${p.headers.size()}">${p.end}</td>
                    <td>${p.headers[0].quantity}<br/></td>
                    <td>${p.headers[0].product.name}<br/></td>
                    <td>${p.headers[0].estimatedeffort}<br/></td>

                </tr>
                <c:forEach var="i" begin="1" end="${p.headers.size()-1}">
                    <tr>
                        <td>${p.headers[i].quantity}<br/></td>
                        <td>${p.headers[i].product.name}<br/></td>
                        <td>${p.headers[i].estimatedeffort}<br/></td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </body>




</html>
