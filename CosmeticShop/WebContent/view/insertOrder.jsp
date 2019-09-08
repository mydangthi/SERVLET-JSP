<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jsp.demo.model.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is addUser page</title>
</head>
<body>
  <jsp:include page="header.jsp" />
 
 
	<form action="${pageContext.request.contextPath}/insertOrder" enctype="multipart/form-data" method="post">
        <label> CustomerName: </label>
        <input type="text" name=" customerName"><br>
        <label> PhoneNumber: </label>
         <input type="text" name="phoneNumber"> <br>
       <br>
        <label> Address</label> 
        <input type="text" name="address" /> <br/> 
         
        <label>&nbsp; </label>
        <input type="submit" value="Add" name="add">
    </form>
</body>
</html>