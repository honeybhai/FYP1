<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Users</title>
</head>
<body>
	<div style="margin: 0 auto;">
		<spring:form action="${pageContext.request.contextPath}/saveUser.bnu" modelAttribute="user">
			<%-- hidden field to help decide whether to insert or update --%>
			<spring:hidden path="userId"/>
			First Name: <spring:input path="firstName"/><br/>
			Last Name: <spring:input path="lastName"/><br/>
			Gender: 
			<spring:radiobutton path="gender" value="M" /> Male
			<spring:radiobutton path="gender" value="F" /> Female			
			<br/>
			City <spring:input path="city"/>
			<input type="submit" value="Save" />
		</spring:form>
		<br/><br/>
		<table border="1">
			<tr>
				<th>ID</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>City</th><th>&nbsp;</th>
			</tr>
			<c:forEach items="${usersList}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.gender}</td>
					<td>${user.city}</td>
					<td><a href="${pageContext.request.contextPath}/manageUsers.bnu?userId=${user.userId}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/viewAllUsers.bnu">view all users</a>
	</div>
</body>
</html>