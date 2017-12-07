<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017/12/7
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User Registration Form</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<h2>User Registration Form</h2>
<c:url value='/edit-user-${user.id}' var="url" />
<form:form method="POST" modelAttribute="user" action="${url}">

    <table>
        <tr>
            <td><label for="id">ID: </label> </td>
            <td><form:input path="id" id="id"/></td>
        </tr>
        <tr>
            <td><label for="userName">User Name: </label> </td>
            <td><form:input path="userName" id="userName"/></td>
        </tr>
      <%--  <tr>
            <td><label for="passWord">passWord: </label> </td>
            <td><form:input   path="passWord" id="passWord"/></td>
        </tr>--%>
        <tr>
            <td><label for="firstName">First Name: </label> </td>
            <td><form:input path="firstName" id="firstName"/></td>
        </tr>
        <tr>
            <td><label for="lastName">Last Name: </label> </td>
            <td><form:input path="lastName" id="lastName"/></td>
        </tr>

       <%-- <tr>
            <td><label for="type">Type: </label> </td>
            <td><form:input path="type" id="type"/></td>
        </tr> --%>
        <tr>
            <td colspan="3">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</form:form>
<br/>
<br/>
Go back to <a href="<c:url value='/list' />">List of All Users</a>
<a href="<c:url value='/logout' />">Logout</a>
</body>
</html>
