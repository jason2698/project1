<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@include file="WEB-INF/views/Header.jsp" %> 
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <title>Online Shopping</title>
  
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
    width: 100%;
    margin: auto;
  }
  </style>
  
</head>
<body background="resources/images/bg10.jpg">
  <h1 class="mt-5"  style="color:black" padding="1000*1000.200" ><i><center>WELCOME</i></center></h1>

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
       <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
      <img src='<c:url value='resources/images/in71.jpg'></c:url>' alt= "Mobiles" height="460" width="345" > 
        <div class="carousel-caption">
        <h3>WELCOME</h3>
        <p>Mobile use is growing faster than all of Google internal predictions</p>
       
        </div>
      </div>

      <div class="item">
       <img src='<c:url value='resources/images/ph1.jpg'></c:url>' alt= "Mobiles" height="460" width="345" > 
        <div class="carousel-caption">
        
        </div>
      </div>
    
      <div class="item">
       <img src='<c:url value='resources/images/ph3.jpg'></c:url>' alt= "Mobiles" height="460" width="345" > 
        <div class="carousel-caption">
        </div>
      </div>

	 <div class="item">
       <img src='<c:url value='resources/images/ph5.jpg'></c:url>' alt= "Mobiles" height="460" width="345" > 
        <div class="carousel-caption">
        </div>
      </div>
        
        
        <div class="item">
       <img src='<c:url value='resources/images/in5.jpg'></c:url>' alt= "Mobiles" height="460" width="345" > 
        <div class="carousel-caption">
        </div>
      </div>
      
      </div>
  

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</body>

</html>