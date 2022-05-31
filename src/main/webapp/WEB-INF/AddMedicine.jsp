<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add</title>
<link rel="stylesheet" href="/styles/d.css"/>
<link rel="stylesheet" href="/styles/d.css"/>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    
    
	<script type="text/javascript" src="js/app.js"></script>
	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/styles/d.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
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
    <section >
<div class = "container-md-fluid m-5 p-5">
		<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
			<h1>Add New Medicine</h1>
			<form:form action="/medicine/new" method="post" modelAttribute="newMedicine" enctype="multipart/form-data">
				<div>
		 			<form:label path="name" for="floatingInput">Name</form:label>
				    <form:input path="name" class="form-control" name = "name" id="floatingInput"   />
					<form:errors path="name" class = "my-3" style="color: red;"/>
				</div>
					    <br> 
				
				<div>
				<form:label path="quantity" for="floatingInput">Quantity</form:label>
				  <form:input type="number" path="quantity" class="form-control" name = "quantity" id="floatingInput" style="height=50px"/>  
					<form:errors path="quantity" class = "my-3" style="color: red;"/>
				</div>
				
				    <br>
				<div >
				<form:label path="price" for="floatingTextarea2">Price</form:label>
				
                 <form:input type="number" step="0.1" path="price" class="form-control" placeholder="Leave a comment here" name = "price" id="floatingTextarea2" style="height: 50px"/>
                    <form:errors path="price" class = "my-3" style="color: red;"/>
                </div>
                
                
                    <br>
                 	<div >
				<form:label path="expirydate" for="floatingTextarea2">Expire date</form:label>
				
                 <form:input type="date" path="expirydate" class="form-control"  name = "expirydate" id="floatingTextarea2" style="height: 50px"/>
                    <form:errors path="expirydate" class = "my-3" style="color: red;"/>
                </div>
                <br>
             
                <div>
                <form:label path="category" for="floatingTextarea2">Category</form:label>
                <form:select path="category" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
			     <<c:forEach var="category" items="${cateList}">
				  	<form:option value="${category.id}"><c:out value="${category.name}"></c:out></form:option>
				  
				  	</c:forEach>
				  	
				  	
				
				</form:select>
				
				</div>
			
				
				   	<div >
				<form:label path="prescription" for="floatingTextarea2">Prescription</form:label>
                 <form:checkbox path="prescription"  placeholder="prescription" name = "prescription"  />
                    <form:errors path="prescription" class = "my-3" style="color: red;"/>
                </div>
                
              <br>
              <div>
     
				    <label>Photos: </label>
				    <input type="file" name="image" accept="image/png, image/jpeg" />
				     
    			</div>
				<button type="submit" class="btn btn-info">Add Medicine</button>
			</form:form>
			</div>
		</div>
	</div>
        

 


    </section>
</div>

    <footer>
        <h3>E-Pharmacy</h3>
        <p>I have always striven to fix beauty in wood, stone,<br>
            glass or pottery, that has been my creed.</p>
        <div class="contact">
            <div class="container">
                <img src="/images/email.png" ></img>
                <p>Email</p>
                <p>myPharmacy@gmail.com</p>

            </div>
            <div class="container">
                <img src="/images/location.png" ></img>
                <p>Location</p>
                <p>Nablus-Palestine </p>

            </div>
            <div class="container">
                <img src="/images/phone.png" ></img>
                <p>Call</p>
                <p>+970599114657</p>

            </div>
        </div>
    </footer> 
</body>
</html>