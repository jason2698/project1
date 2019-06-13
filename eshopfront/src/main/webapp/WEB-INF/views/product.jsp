<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<%@include file="Header.jsp"%>
<html>
<head>
<meta charset=ISO-8859-1">
</head>
<body background="resources/images/bg.jpg">
<br/><br/>

<h2 align="center">Product Page</h2>

	<form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
	
	<table align="center">
				<tr>
					<td colspan="2">Product Info</td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td><form:input path="productName" style="border-radius: 10px;color:black"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><form:input path="price" style="border-radius: 10px;color:black"/></td>
				</tr>
				<tr>
					<td>Stock</td>
					<td><form:input path="stock" style="border-radius: 10px;color:black"/></td>
				</tr>
				<tr>
   					<td>Image</td>
    				<td><form:input type="file" path="pimage" style="border-radius: 10px;color:black"/></td>
				</tr>
		<tr>
    <td>Category</td>
    <td>
    <form:select path="categoryId" style="border-radius: 10px;color:black">
    <form:option value="0" label="--Select Category--"/>
    <form:options items="${categoryList}"/>
    </form:select>
    </td>
</tr>

<tr>
    <td>Supplier</td>
    <td>
    <form:select path="supplierId" style="border-radius: 10px;color:black">
    <form:option value="0" label="--Select Supplier--"/>
    <form:options items="${supplierList}"/>
    </form:select>
    </td>
</tr>

<tr>
    <td>Product Desc</td>
    <td><form:input path="productDesc" style="border-radius: 10px;color:black"/></td>
</tr>
<tr>
    <td colspan="2"><center><input type="submit" value="InsertProduct" style="border-radius: 10px;color:black"/></center></td>
</tr>
</table>		

</form:form>
</br>
<table align="center" border="1" >
<tr>
<td>Product Id</td>
<td>Product Name</td>
<td>Product Description</td>
<td>Price</td>
<td>Stock</td>
<td>Category ID</td>
<td>Supplier ID</td>
<td>Operations</td>
</tr>

<c:forEach items="${productList}" var="product">
<tr>
                          <td>${product.productId}</td>
                          <td>${product.productName}</td>
                          <td>${product.productDesc}</td>
                          <td>${product.price}</td>
                          <td>${product.stock}</td>
                          <td>${product.categoryId}</td>
                          <td>${product.supplierId}</td>
    <td>
    <a href="<c:url value="/editProduct/${product.productId}"/>"class="btn btn-success">Edit</a>
    <a href="<c:url value="/deleteProduct/${product.productId}"/>"class="btn btn-danger">Delete</a>
    </td>
 </tr>
 </c:forEach>   
    
</table>


</body>
</html>