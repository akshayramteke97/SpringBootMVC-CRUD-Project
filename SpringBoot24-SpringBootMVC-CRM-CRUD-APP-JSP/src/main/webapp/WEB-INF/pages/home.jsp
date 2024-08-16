<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		
			<!-- put new button:: Add Customer -->
			<input type='button' value='Add Customer'
				onclick="window.location.href='showform'; return false;"
				class="add-button" />
			<table>
				<tr>
					<th>First Name</th>
					<th>Address</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customer}">
				<c:url var="update" value="/customer/showUpdate">
					<c:param name="customerId"  value="${customer.cid}"/>
				</c:url>
				<c:url var="delete" value="/customer/showDelete">
					<c:param name="customerId"  value="${customer.cid}"/>
				</c:url>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<a href='${update}'>Update</a>
							<a href='${delete}' onclick="if(!(confirm('Do you really want to delete?')))return false;">| Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>

