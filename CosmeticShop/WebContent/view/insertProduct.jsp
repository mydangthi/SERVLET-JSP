<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jsp.demo.model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is addUser page</title>
</head>
<body>
  
 
 
	<form action="${pageContext.request.contextPath}/insertProduct" enctype="multipart/form-data" method="post">
        <label> ProductName: </label>
        <input type="text" name="productName"><br>
        <label> Price: </label>
        <input type="text" name="price"> <br>
        <label> Status: </label> 
        <select name="status">
		  <option value="Available">Available</option>
		  <option value="Sold" selected>Sold</option>
		</select> <br>
       <br>
          <label>Choose Image</label> 
        <input type="file" name="image" /> <br/>
        <label>&nbsp; </label>
        <input type="submit" value="Add" name="add">
    </form>
</body>
</html>