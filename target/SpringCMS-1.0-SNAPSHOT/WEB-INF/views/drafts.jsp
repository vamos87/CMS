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
    <title>Szkice</title>
</head>
<body>
    <jsp:include page="../fragments/header.jsp"/>
    <br>
    <h2>Szkice</h2>
    <table border="1 solid">
            <tr>
                <th>Tytuł</th>
                <th>Akcje</th>
            </tr>
        <c:forEach items="${articles}" var="draft">
            <tr>
                <td>${draft.title}</td>
                <td><a href="edit/${draft.id}">edytuj</a></td>
                <td><a href="delete/${draft.id}">usuń</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="add">Dodaj</a><br>
    <br>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
