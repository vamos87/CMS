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
    <title>Szkice</title>
</head>
<body>
    <jsp:include page="../fragments/header.jsp"/>
    <br>
    <h2>Szkice</h2>
    <form:form method="post" modelAttribute="article">

        Tytuł:  <form:input path="title"/>
                <form:errors path="title"/> <br>

        Treść:  <form:textarea rows="10" cols="100" path="content"/>
                <form:errors path="content"/> <br>

        <input type="submit" value="Dodaj">

        <form:hidden path="id"/><br>
        <form:errors path="*"/>
    </form:form>
    <br>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
