<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<a href="/product">
    Back to home
</a>
<c:if test='${requestScope["message"] !=null}'>
    <span style="color:deepskyblue">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>Product Name</label><br>
    <input type="text" name="namePro"><br>
    <label>Product Price</label><br>
    <input type="number" name="pricePro"><br>
    <label>Product Description</label><br>
    <input type="text" name="desPro"><br>
    <label>Product Made</label><br>
    <input type="text" name="madePro"><br>
    <button>Create</button>
</form>
</body>
</html>
