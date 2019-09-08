<%@page import="jsp.demo.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is editUser page</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/editProduct" method="post">
        <label> ProductName: </label>
        <input type="text" name="productName" value="${product.productName}"  ><br>
        <label> Price: </label>
        <input type="text" name="price" value="${product.price}"  > <br>
        <label> Status: </label> 
          <select name="status">
		     <option value="Available">Available</option>
		     <option value="Sold" selected>Sold</option>
		  </select> 
		  <br>
      <!--   <label>Choose Image</label> 
        <input type="file" name="image" value="${product.image }"/>--> <br/> 
        <label>&nbsp; </label>
        <input type="hidden" name="id" value="${product.id}">
        <input type="submit" value="Update" name="update">
    </form>  

</body>
</html>