<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
 .navbar-header {
 padding-top: 0;
 padding-bottom: 0;
 height: 40px;

 }
 
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/eshopfront">ESHOP</a>
    </div>

<c:if test="${!sessionScope.loggedIn}">
         <ul class="nav nav-tabs navbar-right">
         
    <li><a href="login"><b><span class="glyphicon glyphicon-log-in"></span> Login</b></a></li>
  <li><a href="register"><b><span class="glyphicon glyphicon-user"></span>Sign-up</b></a></li>
  </ul>
  
  <ul class="nav nav-tabs">
  	
   <li><a href="AboutUs">AboutUs</a></li>
    <li><a href="ContactUs">ContactUs</a></li>
   
     </ul>
</c:if>
   <c:if test="${sessionScope.loggedIn}">
   <c:if test="${sessionScope.ROLE eq 'ROLE_ADMIN'}">
   <ul class="nav nav-tabs">
      
   <li><a href="category">Category</a></li>
   
   <li><a href="supplier">Supplier</a></li>
   
   <li><a href="product">Product</a></li>
   </ul>

</c:if>
   <c:if test="${sessionScope.ROLE eq 'ROLE_USER'}">
    <ul class="nav nav-tabs">
    <li>
<a href="<c:url value="/productdisplay"/>">Product Catalog</a></li>
    <li>
<a href="<c:url value="/cart"/>">Cart</a></li>
   </ul>
</c:if>
<ul class="nav nav-tabs navbar-right">
   <li><a href="<c:url value="/perform_logout"/>">Logout</a></li>
</ul>

</c:if>
</div>
</nav>

</body>

</html>