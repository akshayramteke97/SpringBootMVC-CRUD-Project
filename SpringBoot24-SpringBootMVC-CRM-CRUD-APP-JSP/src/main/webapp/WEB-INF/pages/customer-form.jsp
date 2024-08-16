<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/style.css">
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<form:form method="POST" action="${pageContext.request.contextPath}/customer/savecustomer" modelAttribute="customer" >
			<form:hidden path="cid"/>
			<table>
				<tbody>
					<tr>
						<td>
							First Name
						</td>
						<td>
							<form:input path="firstName"/>
						</td>	
					</tr>
					<tr>
						<td>
							Last Name
						</td>
						<td>
							<form:input path="lastName"/>
						</td>	
					</tr>
					<tr>
						<td>
							Email
						</td>
						<td>
							<form:input path="email"/>
						</td>	
					</tr>
					<tr>
						<td>
						
						</td>
						<td>
							<input type="submit" value="save"/>
						</td>	
					</tr>
				</tbody>
				
			</table>
			
		</form:form>
	</div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/home">Go Back</a>
		</p>

</body>
</html>