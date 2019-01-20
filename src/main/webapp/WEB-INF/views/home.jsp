<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>HOME</title>
</head>
<body>
    <jsp:include page="../fragments/header.jsp"/>
    <br>
    <table border="1 solid">
        <tr>
            <th>Tytuł</th>
            <th>Data dodania</th>
            <th>Treść</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.title}</td>
                <td>${article.created}</td>
                <c:choose>
                    <c:when test="${article.content.length() > 200}">
                        <td>${article.content.substring(0,200)}</td>
                    </c:when>
                    <c:when test="${article.content.length() <= 200}">
                        <td>${article.content}</td>
                    </c:when>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
    <br>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
