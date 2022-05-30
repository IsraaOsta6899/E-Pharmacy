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
<link rel="stylesheet" href="/styles/feedback.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

</head>
<body>
    <header>
        <h3>E-Pharmacy</h3>
        <nav  class="mynav" >
            <a class="navbar-link" href="#">HOME</a>
            <a class="navbar-link" href="#">ABOUT </a>
            <a class="navbar-link" href="#">SHOP</a>
            <a class="navbar-link" href="#">CONTACT</a><span>|</span> 
            <c:choose>
			    <c:when test="${isAdmin}">
            	<a class="navbar-link" href="/requests">Requests</a>
                <a class="navbar-link" href="#">Add Medicine</a>
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

<section class="feedbacks">
<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Number</th>
			      <th scope="col">User Name</th>
			      <th scope="col">User Email</th>
			      <th scope="col">Message/Feedback</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="f"  items="${allFeedbacks}">
			  <tr>
			  	<td><c:out value="${f.getId()}"/></td>
			  	<td><c:out value="${f.getUser().getUserName()}"/></td>
			  	<td><c:out value="${f.getUser().getEmail()}"/></td>
			  	<td><c:out value="${f.getMessage()}"/></td>
			  </tr>
			</c:forEach>
		</table>
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
    <div class="cart">
        <h4>Your Cart </h4>
        <hr>
        <div class="selected-items">

        </div>
        <input type="button" value="sent your order" id="send-order">

    </div>
    <script src="/script/scripts.js"></script>
         
</body>
</html>