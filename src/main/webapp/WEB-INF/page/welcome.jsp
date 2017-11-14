<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017/11/9
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
</head>
<body>
Greeting : ${greeting}
This is a welcome page.

Dear <strong>${user}</strong>, Welcome to Home Page.
<a href="<c:url value="/logout" />">Logout</a>

<br/>
<br/>
<div>
    <label>View all information| This part is visible to Everyone</label>
</div>
<br/>
<div>
    <sec:authorize access="hasRole('ADMIN')">
        <label><a href="#">Edit this page</a> | This part is visible only to ADMIN</label>
    </sec:authorize>
</div>

<br/>
<div>
    <sec:authorize access="hasRole('ADMIN') and hasRole('DBA')">
        <label><a href="#">Start backup</a> | This part is visible only to one who is both ADMIN & DBA</label>
    </sec:authorize>
</div>
</body>
</html>
