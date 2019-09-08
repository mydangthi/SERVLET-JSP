<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
<head>
      
      <title>Cosmetic Shop</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	  <link href="${pageContext.request.contextPath}/main/bootstrap/bootstrap.min.css" rel="stylesheet">
     
</head>
<body>
		  <nav class="navbar navbar-expand-lg navbar-dark bg-danger fixed-top">
			    <div class="container">
			       <a class="navbar-brand" href="homeAdmin"><h4>Cosmetic Shop</h4></a>
			       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			       <span class="navbar-toggler-icon"></span>
			      </button>
				      <div class="collapse navbar-collapse" id="navbarResponsive">
				        <ul class="navbar-nav ml-auto">
						       <li class="nav-item active">
						           <a class="nav-link" href="homeAdmin">Home Admin
						             <span class="sr-only">(current)</span>
						           </a>
						       </li>
						       <li class="nav-item">
					            	<a class="nav-link" href="orderList">Order List</a>
					           </li>
					           <li class="nav-item">
					            	<a class="nav-link" href="home">Home Order</a>
					           </li>
					           <li class="nav-item">
					            	<a class="nav-link" href="logout">Logout</a>
					           </li>
				        </ul>
				      </div>
			    </div>
		  </nav>
</body>
</html>