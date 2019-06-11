<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@include file="Header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/bg5.jpg">

<div class="row">
<c:forEach items="${productList}" var="product">

<div class="col-sm-6 col-md-3">
 <a href="<c:url value="totalproductdisplay/${product.productId}"/>" class="thumbnail">

<img src ='<c:url value="resources/images/${product.productId}.jpg"></c:url>'> 

 
 </a>

</div>

 </c:forEach>   
 
</div>

</body>
</html>