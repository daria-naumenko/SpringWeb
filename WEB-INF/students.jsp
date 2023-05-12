<%@ page contentType="text/html" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student information</title>
</head>
<body>
<h1>Write information about student</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.age}</td>
            <td>
                <a href="<c:url value='/students/${student.id}/update' />">Update</a>
                <a href="<c:url value='/students/${student.id}/delete' />">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="<c:url value='/students/new' />">Add new student</a>
<c:if test="${not empty student}">
    <h2>Edit Student</h2>
    <form method="post" action="<c:url value='/students/${student.id}' />">
        <input type="hidden" name="_method" value="PUT" />
        <label>First Name:</label>
        <input type="text" name="firstName" value="${student.firstName}" /><br>
        <label>Last Name:</label>
        <input type="text" name="lastName" value="${student.lastName}" /><br>
        <label>Age:</label>
        <input type="text" name="age" value="${student.age}" /><br>
        <input type="submit" value="Save" />
    </form>
</c:if>

</body>
</html>