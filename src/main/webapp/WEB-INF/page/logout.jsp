<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017/11/8
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin page</title>
</head>
<body>
Dear <strong>${user}</strong>, Welcome to Admin Page.
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>