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
    <title>Autorzy</title>
</head>
<body>
    <jsp:include page="../fragments/header.jsp"/>
    <br>
    <h2>Autorzy</h2>
    <table border="1 solid">
            <tr>
                <th>Autor</th>
                <th>Akcje</th>
            </tr>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.firstName} ${author.lastName}</td>
                <td><a href="edit/${author.id}">edytuj</a></td>
                <td><a href="delete/${author.id}">usuń</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="add">Dodaj</a><br>
    <br>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
