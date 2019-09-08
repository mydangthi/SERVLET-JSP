<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@ page import="jsp.demo.model.Product" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
   <head>
    <script>  
		function validate(){  
		var num=document.myform.phoneNumber.value;  
		var name=document.myform.customeName.value; 
		var dc=document.myform.address.value; 
		 
		if (name==null || name=="" ){
			alert("Tên không được để trống");
			return false;
		}else if (dc==null || dc=="" ){
			alert("Địa chỉ không được để trống");
			return false;
		}else if (isNaN(phoneNumber)){  
		  document.getElementById("numLoc").innerHTML="Enter Numeric value only";  
		  return false;  
		}else{  
		  return true;  
		  }  
		}  
   </script>
   </head> 
<body>
    <jsp:include page="header.jsp" />
    <br>
    
     <div class="ii"> 
	    <form>
				<h4>Product Information</h4>
				<table style="text-align: center" border="1"> 
				<tr>
				    <th>Product ID</th>
				    <th>Total Money</th>
				    <th>Image</th>
				 </tr>
				 <tr> 
				    <td>${product.id}</td>
				    <td style="color: red">${product.price} VND</td>
				    <td><img height="120" width="150" src="${product.image}"/></td>
				 </tr>
				</table>
	   
	    </form>	
   </div>				
			
 <div class="ii1">
    
		 <form name="myform" action="${pageContext.request.contextPath}/order" method="post" onsubmit="return validate()">
		    <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SHIPMENT INFORMATION</h4>
		    <br>
			 <table style="text-align: center">
				 <tr> 
					 <td>Full Name:</td>
					 <td><input type="text" name="customeName" /> </td>
				 </tr>
				  <tr> 
					 <td>Phone Number:</td>
					 <td><input type="number" name="phoneNumber" /><span id=numLoc></span> </td>
				 </tr>
				  <tr> 
					 <td>Address :</td>
					 <td><input type="text" name="address" /></td>
					 <td></td>
					 <td><input type="hidden" name="productId" value="${product.id}" /></td>
					 <td></td>
					 <td><input type="hidden" name="total" value="${product.price}" /></td>
				 
				 </tr>
				 <tr> 
				   <td></td>
				   <td><input type="submit" value="Order" /></td>
				 </tr>
			 
			 </table>
		  </form>
  </div>

</body>
</html>
