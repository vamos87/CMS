<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 24.10.18
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/skeleton/2.0.4/skeleton.css">--%>


<html>
<head>
    <title>Title</title>
    <link href="../style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <hr>
    <a href="/home">HOME</a> |
    <c:forEach items="${categories}" var="category">
        <a href="/category/${category.id}">${category.name}</a> |
    </c:forEach>
</body>
</html>
