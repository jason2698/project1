<%@include file="Header.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/bg8.jpg">
	
	<div class="container">
	<table class="table">
	
		<tr>
			<td colspan="5"><center><b>Your Order</b></center></td>
			</tr>
		<tr bgcolor="white">
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Total Price</th>
			
		</tr>

		<c:forEach items="${listCartItem}" var="cart">
	<form action="<c:url value="updateCartItem/${cart.cartItemId}"/>" method="post">

				<tr>
					
					<td><b>${cart.productName}</b></td>
					<td><b>${cart.quantity}</b></td>
					<td><b>${cart.price}</b></td>
					<td><b>${cart.quantity * cart.price}/-</b></td>
					
		</tr>
		</form>

		</c:forEach>

     <tr>
     <form action="updateAddress" method="get">
   <td colsapn="2"><b>Address</b></td>
    <td colspan="4">
      <textarea  name="address" rows="5" cols="30">${address}</textarea>
      
      </td>
      <td>
      <input type="submit" value="UpdateAddress"/>
      </td>
      </form>
      </tr>
      
       
     

		<tr bgcolor="grey">
			<td colspan="4">Grand Total Price</td>
			<td colspan="2">${grandTotal}/-</td>
		</tr>
		<tr>
		

	<tr bgcolor="grey">
            <td colspan="3"  style="background-color:white"><center><a href="<c:url value="/productdisplay"/>">Edit Cart</a></center></td>
			<td colspan="3"  style="background-color:white"><center><a href="<c:url value="/Payment"/>">Payment</a></center></td>
            
        </tr>	


	</table>
	</div>

</body>
</html>