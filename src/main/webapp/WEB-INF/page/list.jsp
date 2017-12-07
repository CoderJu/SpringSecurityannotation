<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017/12/7
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User's List</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of Users</h2>
<table>
    <tr>
        <td>id</td><td>First Name</td><td>Last Name</td><td>Type</td><td></td><td></td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
                <%--<td>${user.lastName}</td>
                <td>${user.type}</td>--%>
            <td><a href="<c:url value='/edit-user-${user.id}' />">edit</a></td>
            <td><a href="<c:url value='/delete-user-${user.id}' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/logout' />">Logout</a>
</body>
</html>
