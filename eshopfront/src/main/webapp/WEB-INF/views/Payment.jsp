<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="Header.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/bg8.jpg">

<table class="table table-dark" width="100%" align="center">

   <tr>
        <td><b>Total Amount</b></td>
        <td><b>RS.${grandTotal}/-</b></td>
        
        </tr>
    </table>
    <br/><br/><br/><br/><br/>
    
  <div class="container"> 
 <form action="<c:url value="receipt"/>" method="post">
  <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                    Payment Details</h3>
                    
                    <div class="checkbox pull-right">
                        <label>
                            <input type="checkbox" />
                            Remember
                        </label>
                    </div>
                </div>
                <div class="panel-body">
                    <form role="form">
                    <div class="form-group">
       
     <tr>
           <td colspan="2"><center>
            <input type="radio" name="pmode" value="CC" required/>Credit Card
            <input  type="radio" name="pmode"  value="COD">Cash on Delivery</center></td>
            </tr>
            
            <div class="input-group">
                            <input type="text" value="7987-2345-9087"class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
         <div class="row">
            <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CV CODE</label>
                                <input type="password" value="345 "class="form-control" id="cvCode" placeholder="CV" required />
                           </div>
                           </div>
                           </div>
                           
     
        <input type="submit" value="Pay" class="btn btn-success"/>
        </form>
        </div>
        </div>
        </div>
        </div>
        

</form>
</body>
</html>
