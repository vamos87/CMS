<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 25.10.18
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"	%>
<html>
<head>
    <title>Kategorie</title>
</head>
<body>
    <jsp:include page="../fragments/header.jsp"/>
    <br>
    <h2>Kategorie</h2>
    <form:form method="post" modelAttribute="category">

        Nazwa:  <form:input path="name"/>
                <form:errors path="name"/> <br>

        Opis:   <form:input path="description"/>
                <form:errors path="description"/> <br>

        <input type="submit" value="Dodaj">

        <form:hidden path="id"/><br>
        <form:errors path="*"/>
    </form:form>
    <br>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
