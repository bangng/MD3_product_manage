<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2022
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<a href="/product">Back to home</a>
<c:if test='${requestScope["message"] != null}'>
    <span>${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>Product Name</label><br>
    <input type="text" name="namePro" value='${requestScope["product"].proName}'><br>
    <label>Product Price</label><br>
    <input type="number" name="pricePro" value='${requestScope["product"].proPrice}'><br>
    <label>Product Description</label><br>
    <input type="text" name="desPro" value='${requestScope["product"].description}'><br>
    <label>Product Made</label><br>
    <input type="text" name="madePro" value='${requestScope["product"].made}'><br>
    <button>Edit</button>
</form>

</body>
</html>
