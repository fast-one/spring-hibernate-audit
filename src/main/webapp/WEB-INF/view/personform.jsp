<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Spring 4 MVC + Hibernate</title>
</head>
<body>
  <form:form  id="myform" action="addPerson" method="POST" commandName="person">
       <h3> <c:if test="${person.pid==0}">
			         Add New Person
	        </c:if>
			<c:if test="${person.pid!=0}">
			         Update Person for Id: <c:out value="${person.pid}"/>
					 <form:hidden path="pid"/>
	        </c:if>
       </h3>
	  <table>
	    <tr> <td>User Name:</td> <td><form:input  path="username"/><form:errors path="username" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Password:</td> <td><form:input path="password"/><form:errors path="password" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Age: </td> <td><form:input path="age"/><form:errors path="age" cssClass="error-msg"/> </td> </tr>
	    <tr> <td>Gender: </td> 
	         <td> <form:radiobuttons path="gender" items="${genderOptions}"/>
	             <form:errors path="gender" cssClass="error-msg"/> </td> </tr>    
	    <tr> <td>City:</td> <td> 
	        <form:select path="city">
	           <form:option value="" label="--Select City--"/>
	           <form:options items="${cityMap}"/>
            </form:select>  
            <form:errors path="city" cssClass="error-msg"/>
	    </td> </tr>

		<tr>
			<td colspan="2">
				<h3>Contact Details</h3>
				<table>
					<tr> <td>Email Address:</td> <td><form:input  path="contact.emailAddress"/><form:errors path="contact.emailAddress" cssClass="error-msg"/> </td> </tr>
					<tr> <td>Phone Number:</td> <td><form:input  path="contact.phoneNumber"/><form:errors path="contact.phoneNumber" cssClass="error-msg"/> </td> </tr>
					<%--<tr>--%>
						<%--<td colspan="2">--%>
							<%--<h3>Address(es)</h3>--%>
							<%--<table>--%>
                                <%--<h4>Address</h4>--%>
								<%--<tr> <td>Address:</td> <td><form:input  path="contact.addressList[0].address"/><form:errors path="contact.addressList[0].address" cssClass="error-msg"/> </td> </tr>--%>
								<%--<tr> <td>Type:</td> <td><form:input  path="contact.addressList[0].addressType"/><form:errors path="contact.addressList[0].addressType" cssClass="error-msg"/> </td> </tr>--%>
							<%--</table>--%>
                            <%--<table>--%>
                                <%--<h4>Address</h4>--%>
                                <%--<tr> <td>Address:</td> <td><form:input  path="contact.addressList[1].address"/><form:errors path="contact.addressList[1].address" cssClass="error-msg"/> </td> </tr>--%>
                                <%--<tr> <td>Type:</td> <td><form:input  path="contact.addressList[1].addressType"/><form:errors path="contact.addressList[1].addressType" cssClass="error-msg"/> </td> </tr>--%>
                            <%--</table>--%>
						<%--</td>--%>
					<%--</tr>--%>
				</table>
			</td>
		</tr>




	    <tr> <td colspan="2">
    	     <c:if test="${person.pid==0}">
			      <input type="button" value="Add" id="btn-add"> 
	         </c:if>
			 <c:if test="${person.pid!=0}">
			      <input type="button" value="Update" id="btn-update"> 
	         </c:if>
		</td> </tr>
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> </tr>
	  </table>
	  <table>   
	      <tr>   <td> ID </td>
		         <td> User Name </td>
				 <td> Age </td>
				 <td> Gender </td>
				 <td colspan="2"> City </td>
		  </tr>
    	  <c:forEach var="obj" items="${allData}">
		      <tr>
		         <td><a href="/revision/${obj.pid}"><c:out value="${obj.pid}"/></a> </td>
		         <td> <c:out value="${obj.username}"/> </td>
				 <td> <c:out value="${obj.age}"/> </td>
				 <td> <c:out value="${obj.gender}"/> </td>
				 <td> <c:out value="${obj.city}"/> </td>
				 <td> <a href="${pageContext.request.contextPath}/deletePerson?pid=${obj.pid}">Delete </a> |
				     <a href="${pageContext.request.contextPath}/personById?pid=${obj.pid}">Edit</a> 
				 </td>
		      </tr>
	      </c:forEach>
      </table> 
  </form:form>
  <script src="${pageContext.request.contextPath}/app-resources/js/lib/jquery-2.2.3.min.js"></script>
  <script src="${pageContext.request.contextPath}/app-resources/js/myapp.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-resources/css/style.css"/>
  
</body>
</html>