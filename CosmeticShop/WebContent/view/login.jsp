 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/main.css">
</head>
<body>
	<h1> Login </h1>
	
    <form action="<%=request.getContextPath()%>/login" method="post">
        <label> Username: </label>
        <input type="text" name="userName"> <br>
        <label> Password: </label>
        <input type="password" name="password"> <br>
        <label>&nbsp; </label>
        <input type="submit" value="Login" name="submit">
    </form>
</body>
</html>