<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<head>

    <title>Admin</title>
    <style>
        <%@include file='style/style.css' %>
    </style>

</head>

<body>

<div class="centre">

    <a href="<c:url value="/logout"/>">Logout</a>

    <h3>Admin</h3>

    <table class="centre">
        <tr>
            <th class="centre">Id</th>
            <th class="centre">Name</th>
            <th class="centre">Last name</th>
            <th class="centre">Age</th>
            <th class="centre">Email</th>
            <th class="centre">Roles</th>
            <th class="centre">Actions</th>
        </tr>

        <c:forEach var="entry" items="${allUsersMap}">

            <c:url var="showButton" value="/admin/user">
                <c:param name="userName" value="${entry.value.name}"/>
            </c:url>

            <c:url var="updateButton" value="/admin/update">
                <c:param name="userName" value="${entry.value.name}"/>
            </c:url>

            <c:url var="deleteButton" value="/admin/delete">
                <c:param name="userName" value="${entry.value.name}"/>
            </c:url>

            <tr>
                <td class="centre"><c:out value="${entry.value.id}"/></td>
                <td class="centre"><c:out value="${entry.value.name}"/></td>
                <td class="centre"><c:out value="${entry.value.lastName}"/></td>
                <td class="centre"><c:out value="${entry.value.age}"/></td>
                <td class="centre"><c:out value="${entry.value.email}"/></td>

                <td class="centre">
                    <c:forEach var="role" items="${entry.value.roles}">
                        <c:out value="${role.getRole()}"/>
                    </c:forEach>
                </td>

                <td class="centre">
                    <input type="button" value="Show"
                           onclick="window.location.href = '${showButton}'"/>
                    <input type="button" value="Update"
                           onclick="window.location.href = '${updateButton}'"/>
                    <input type="button" value="Delete"
                           onclick="window.location.href = '${deleteButton}'"/>
                </td>

            </tr>

        </c:forEach>
    </table>

    <input type="button" value="Add user"
           onclick="window.location.href = 'admin/addNewUser'"/>

</div>

</body>

</html>
