<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2022
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>

<a href="/product?action=create">Create Product</a>
<c:if test='${requestScope["message"]}'></c:if>
<input >
<a href="/product?action=search">Search</a>
<table border="1">
    <tr>
        <th>STT</th>
        <th>ProductName</th>
        <th>ProductPrice</th>
        <th>ProductDescription</th>
        <th>ProductMade</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

        <c:forEach var="p" items='${requestScope["productList"]}'>
    <tr>
        <td>${p.id}</td>
        <td>${p.proName}</td>
        <td>${p.proPrice}</td>
        <td>${p.description}</td>
        <td>${p.made}</td>
        <td>
            <a href="product?action=edit&id=${p.id}">Edit</a>
        </td>
        <td>
            <a href="product?action=delete&id=${p.id}">Delete</a>
        </td>
    </tr>
        </c:forEach>



</table>

</body>
</html>
