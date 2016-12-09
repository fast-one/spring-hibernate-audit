<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Spring 4 MVC + Hibernate</title>
</head>
<body>
<form:form  id="myform" action="addPerson" method="POST" commandName="person">
	<h3>Person Revision</h3>
	<table >
		<tr>
            <th> Version </th>
            <th> ID </th>
			<th> User Name </th>
			<th> Age </th>
			<th> Gender </th>
			<th> City </th>
			<th>Contact (phone:email)</th>
		</tr>
		<c:forEach items="${allData}" var="entry">

			<tr>
                <td><c:out value="${entry.key}"/></td>
				<td><c:out value="${entry.value.pid}"/></td>
				<td> <c:out value="${entry.value.username}"/> </td>
				<td> <c:out value="${entry.value.age}"/> </td>
				<td> <c:out value="${entry.value.gender}"/> </td>
				<td> <c:out value="${entry.value.city}"/> </td>
				<td> <c:out value="${entry.value.contact.phoneNumber}"/> : <c:out value="${entry.value.contact.emailAddress}"/> </td>
			</tr>
		</c:forEach>
	</table>
</form:form>
<script src="${pageContext.request.contextPath}/app-resources/js/lib/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/app-resources/js/myapp.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-resources/css/style.css"/>

</body>
</html>