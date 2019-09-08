<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jsp.demo.model.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>User management</title>
</head>
<body>
      
	 <jsp:include page="header.jsp"></jsp:include>
	 <br>
	
	<h2 style="text-align:center; color:blue;">WELCOME TO HOME PAGE </h2>
	
	<div>
		
      <form method="GET" action="${pageContext.request.contextPath}/searchProduct" > 
			  <table> 
				    <tr> 
					      <td> 
							      <h4>Enter the product name to search :</h4>
					      </td> 
					      <td>
							      <input type ="text" name = "productName" />
							      <input type ="submit" value ="Search"/>
					      </td>
				    </tr> 
			  </table>   
		 </form>   
     
	</div>
	<div class="container">
			<div class="row">
				<div class="col-lg-12">
					  <div class="row">
							<c:forEach items="${product}" var="product">  
							<c:url value="/image?fname=${product.image}" var="imgUrl"></c:url>
			
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="card h-100">
									 <img class="card-img-top" height="200"  src="${imgUrl}" alt="">
									      <div class="card-body">
									            <h5>Product ID: ${product.id }</h5>
											    <h5>Product Name: ${product.productName}</h5>
												<h5 style="color: red">Price: ${product.price} VND</h5>
												<h6>Status: ${product.status }</h6>
												<hr> 
										        <h5 style="text-align: center"><a href="order?id=${product.id}" >BUY</a></h5>
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
<jsp:include page="footer.jsp" />
</body>
</html>