<%@include file="Header.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
	<table class="table">
	
		<tr>
			<td colspan="5"><center>Your Order</center></td>
			</tr>
		<tr bgcolor="blue">
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Price</td>
			
		</tr>

		<c:forEach items="${listCartItem}" var="CartItem">
	<form action="<c:url value="updateCartItem/${cartItem.cartItemId}"/>" method="post">

				<tr>
				
					<td></td>
					<td>${cartItem.productName}</td>
					<td>${cartItem.quantity}</td>
					<td>${cartItem.price}</td>
					<td>${cartItem.quantity * cartItem.price}/-</td>
					
		</tr>
		</form>

		</c:forEach>

     <tr>
     <form action="updateAddress" method="get">
   <td colsapn="2">Address</td>
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
            <td colspan="3"><center><a href="<c:url value="/productdisplay"/>">Edit Cart</a></center></td>
			<td colspan="3"><center><a href="<c:url value="/Payment"/>">Payment</a></center></td>
            
        </tr>	


	</table>
	</div>

</body>
</html>