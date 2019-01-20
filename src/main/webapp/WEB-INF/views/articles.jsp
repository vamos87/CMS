<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 25.10.18
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Artykuły</title>
    <link href="../style/util.css" rel="stylesheet">

</head>
<body>
    <jsp:include page="../fragments/header.jsp"/>
    <br>
    <h2>Artykuły</h2>
    <table border="1 solid">
            <tr>
                <th>Tytuł</th>
                <th>Akcje</th>
            </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.title}</td>
                <td><a href="edit/${article.id}">edytuj</a></td>
                <td><a href="delete/${article.id}">usuń</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="add">Dodaj</a><br>
    <br>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
