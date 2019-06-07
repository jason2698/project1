<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
</head>
<body background="bg2.jpg">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>


<title>Login</title>
</head>

<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-4 text-center">
        <h1 class="mt-5" style="color:white"><b>Login Page</h1>
              
                </br>
	<form action="perform_login" method="post">
	<table align="center" width="100%" height="200">
		<tr bgcolor="white" >
		<td></td>
		<td><input type="text" id="userName" name="username" class="form-control input-sm chat-input" class="form-control input-sm chat-input" style="font-size: 20px;line-height: 1;border-radius: 10px" placeholder="Enter Username"/></td>
		</tr>  
		<h4 style="color:white"><b>WELCOME</b></h4>
		<tr bgcolor="white">
		<td></td>
		<td><input type="password" id="Password" name="password" class="form-control input-sm chat-input" style="font-size: 20px;line-height: 1;border-radius: 10px" placeholder="Enter Password"/></td>
		</tr>
		<tr bgcolor="black">
		<td colspan="4">
		<input type="submit"  class="btn btn-primary active"  style="color:black" "align="center" value="login"/>
		</td>
		</tr>
	</table>
	</form>
</div>
</div>
</div>
</br></br></br>
</body>

<%@include file="Footer.jsp" %>
</html>