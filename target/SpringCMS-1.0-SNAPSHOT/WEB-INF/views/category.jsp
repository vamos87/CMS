<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 24.10.18
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>${category.name}</title>
</head>
<body>
    <jsp:include page="../fragments/header.jsp"/>
    <br>
    <h2>${category.name}</h2>
    <table border="1 solid">
        <tr>
            <th>Tytuł</th>
            <th>Autor</th>
            <th>Data utworzenia</th>
            <th>Treść</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.title}</td>
                <td>${article.author.firstName} ${article.author.lastName}</td>
                <td>${article.created}</td>
                <td>${article.content}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
