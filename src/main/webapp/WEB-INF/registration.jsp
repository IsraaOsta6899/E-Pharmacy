<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link rel="stylesheet" href="/styles/register.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

</head>
<body>
    <header>
        <h3>E-Pharmacy</h3>
        <nav  class="mynav" >
           <a class="navbar-link" href="/login">Login 									| </a> 
            <a class="navbar-link" href="/Register">  Sign Up</a>            
            
        </nav>
   </header>
    
    <section class="register">
    	<div class="Rform">
    		<form:form action="/register" method="post" modelAttribute="newUser">
            
            <h2>Registration</h2>
            <div class="myDiv">
                <span >Name:</span>
            	<form:input path="userName"   placeholder="full name" />
            </div>
            <div class="myDiv" >
                <span >Email:</span>
            	<form:input path="email"   placeholder="email address" />
           		
            </div>
            <div class="myDiv" >
                <span >phone Number:</span>
            	<form:input path="phoneNumber"   placeholder="phone Number" />
           		
            </div>
            
            <div class="myDiv">
                <span  >Password:</span>
            	<form:input path="password" placeholder="password" type="password"/>
            
            </div>
            <div class="myDiv">
                <span >Confirm Password:</span>
            	<form:input path="confirm"  placeholder="confirm password" type="password" />
           
            </div>
       		<form:errors path="userName"></form:errors>
       		<form:errors path="email"></form:errors>            
       		<form:errors path="phoneNumber"></form:errors>           
            <form:errors path="password"></form:errors>            
            <form:errors path="confirm"></form:errors>           
            <button type="submit" class="btn btn-primary btn-lg">Register</button>
            
        </form:form>
    	</div>
    	<img src="/images/pharmacy.jpg"></img>
    
    </section>
    
    <footer>
        <h3>E-Pharmacy</h3>
        <p>I have always striven to fix beauty in wood, stone,<br>
            glass or pottery, that has been my creed.</p>
        <div class="contact">
            <div class="container">
                <img src="images/email.png" ></img>
                <p>Email</p>
                <p>myPharmacy@gmail.com</p>

            </div>
            <div class="container">
                <img src="images/location.png" ></img>
                <p>Location</p>
                <p>Nablus-Palestine </p>

            </div>
            <div class="container">
                <img src="images/phone.png" ></img>
                <p>Call</p>
                <p>+970599114657</p>

            </div>
        </div>
    </footer>

         
</body>
</html>