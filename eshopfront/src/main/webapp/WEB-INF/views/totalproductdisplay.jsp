<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@include file="Header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/><br/>
<form action="<c:url value="/addToCart/${product.productId}"/>" method="get">
  
<table class="table-bordered">
<tr>
    <td rowspan="7">
  
   <img src ='<c:url value='/resources/images/${product.productid}.jpg'></c:url>' height="70" width="70" alt="Generic placeholder thumbnal"> 
    
    
    </td>
    <td>Product ID</td>
    <td>${product.productId}</td>
</tr>
<tr>
    <td>Product Name</td>
    <td>${product.productName}</td>
</tr>
<tr>
    <td>Description</td>
    <td>${product.productDesc}</td>
</tr>
<tr>
    <td>Price</td>
    <td>INR.${product.price}</td>
</tr>
<tr>
    <td>Stock</td>
    <td>${product.stock}</td>
</tr>
<tr>
    <td>Category ID</td>
    <td>${product.categoryId}</td>
</tr>
<tr>
    <td>Supplier ID</td>
    <td>${product.supplierId}</td>
</tr>

<tr>
    <td>
        Quantity
        <select name="quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
         </select>
       </td>
   <td><input type="submit" value="addToCart" class="btn btn-warning"/></td>
 </tr>  


</table>
</form>

</body>
</html>
