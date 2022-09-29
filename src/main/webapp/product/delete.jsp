<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2022
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<form method="post">
    <label>Product Name</label><br>
    <p>${requestScope["product"].proName}</p><br>

    <label>Product Price</label><br>
    <p>${requestScope["product"].proPrice}</p><br>

    <label>Product Description</label><br>
    <p>${requestScope["product"].description}</p><br>

    <label>Product Made</label><br>
    <p>${requestScope["product"].made}</p><br>
    <p>Are you sure delete</p>


    <button>Yes</button>
</form>
<a href="/product">No</a>
</body>
</html>
