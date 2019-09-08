<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jsp.demo.model.Order" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="home">HOME</a>
<p>You are successfully logged in!</p>
	<table>
		<tr>
            <th>ID</th>
            <th>CustomerName</th>
			<th>PhoneNumber</th>
			<th>Address</th>
			<th>ProductId</th>
			<th>Total</th>
			
		</tr>
		<c:forEach items="${orders}" var="order">
		<tr>
			<td>${order.id}</td>
		    <td>${order.customerName }</td>
			<td>${order.phoneNumber}</td>
			<td>${order.address}</td>	
			<td>${order.productId }</td>
			<td>${order.total }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>