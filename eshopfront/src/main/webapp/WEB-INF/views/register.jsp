<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale="1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
</head>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
<body class="w3-light-grey">
<div class="container">
 <div class="row main">
  <div class="main-login main-center">
   <h5>Register</h5>
   <p>Fill the form</p>
      <form:form method="POST" action="addUser" modelAttribute="UserDetail">
      
      <div class="form-group">
        <label for="name" class="cols-sm-2 control-label">Your Name</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
            <input type="text" name="customername" id="customerName"class="form-control input-sm chat-input" placeholder="Your name" />
          </div>
         </div>
        </div>
       
        
        <div class="form-group">
        <label for="username" class="cols-sm-2 control-label">UserName</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="text" name="username" id="userName"class="form-control input-sm chat-input" placeholder="User Name" />
          </div>
         </div>
        </div>
        
         <div class="form-group">
        <label for="emailId" class="cols-sm-2 control-label">EmailId</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="text" name="emailId" id="userName"class="form-control input-sm chat-input" placeholder="Email Id"/>
          </div>
         </div>
        </div>
        
         <div class="form-group">
        <label for="mobilenumber" class="cols-sm-2 control-label">Mobile Number</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="text" name="mobilenumber" id="userName"class="form-control input-sm chat-input" placeholder="mobileNumber" />
          </div>
         </div>
        </div>
        
        
        
        
        <div class="form-group">
        <label for="address" class="cols-sm-2 control-label">Address</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="text" name="address" id="Addr"class="form-control input-sm chat-input" placeholder="Address" />
          </div>
         </div>
        </div>
        
        <div class="form-group">
        <label for="password" class="cols-sm-2 control-label">Password</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="password" name="password" id="password"class="form-control input-sm chat-input" placeholder="Password" />
          </div>
         </div>
        </div>
        
        <div class="form-group">
           <input type="submit" value="register"/>
        </div>
   </form:form>        
</div>
</div>
</div>
</body>
</html>