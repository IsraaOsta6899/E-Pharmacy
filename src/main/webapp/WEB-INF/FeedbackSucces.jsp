<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet" href="/styles/style.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

</head>
<body>
    <header>
        <h3>E-Pharmacy</h3>
        <nav  class="mynav" >
            <a class="navbar-link" href="/home">HOME</a>
            <a class="navbar-link" href="/aboutUs">ABOUT </a>
            <a class="navbar-link" href="/allmedicines">SHOP</a>
            <a class="navbar-link" href="/contactus">CONTACT</a><span>|</span> 
            <c:choose>
			    <c:when test="${isAdmin}">
            	<a class="navbar-link" href="/requests">Requests</a>
                <a class="navbar-link" href="/medicine/new">Add Medicine</a>
                <a class="navbar-link" href="/feedbacks">Feedbacks</a>
                
				</c:when>    
			    <c:otherwise>
			    
			    
				<img src="images/cart.jpg"   class="cartImage" style="display:block" onclick="toggleText()"></img>
				
            	 <a class="navbar-link" href="/getMyCartItems">Cart</a>
				</c:otherwise>
				
			</c:choose>
			<a class="navbar-link" href="/logout">Log out</a>
			
            
        </nav>
       
    </header>
    <div class="bg">
   
           <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                         <a href="/home"><button class="btn btn-primary btn-block py-3 px-5" type="submit">Continue Shopping</button></a>
                    </div>
                </div>
                </div>
               </div>
               </div>

</body>
</html>