<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
     <%@ page import="jsp.demo.model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>User management</title>
</head>
<body>
	<jsp:include page="headerAdmin.jsp" />		 
	<br>
	<br>
	<br>
     <div class="container">
		 <a href="insertProduct">Insert New Product</a>
		    <div class="row">
			      <div class="col-lg-12"> 
				        <div class="row">
					         <c:forEach items="${productList}" var="product">
					         <c:url value="/image?fname=${product.image}" var="imgUrl"></c:url>
			
					         <div class="col-lg-3 col-md-6 mb-4">
					            <div class="card h-100">
					             <img class="card-img-top" height="200px"  src="${imgUrl}" alt="">
					              <div class="card-body">
						               <h6>Product Name: ${product.productName}</h6>
									   <h6 style="color: red">Price: ${product.price} VND</h6>
									   <h6>Status: ${product.status }</h6>
								       <hr>
						               <a href="editProduct?id=${product.id}">Edit</a> 
						               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						               <a href="deleteProduct?id=${product.id}">Delete</a>
					              </div>
					            </div>
				          </div>
						  </c:forEach>
				        
					   </div>
				  </div>
			  </div>
	  </div>
	  <br>
	  <br>
	  <br>
	  <br>
	  <br>
	  <br>
	  <br>
	  <br>
	  <br>
	  <br><br>
	<jsp:include page="footer.jsp" />