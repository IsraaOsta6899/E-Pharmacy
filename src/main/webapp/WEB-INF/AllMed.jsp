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
<link rel="stylesheet" href="/styles/allmed.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
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
        <div class="homeSection">
            <img id=aboutUs src="images/aboutus.jpg"></img>
        </div>

    <div class="jumbotron jumbotron-fluid">
        <div class="container text-center py-5" >
            <h1 class="text-black display-5" style="margin-top: -27%;">Product</h1>
            <div class="d-inline-flex align-items-center text-black">
                <i class="fa fa-circle px-3"></i>
                <p class="m-0"><a class="text-black" href="/home">Home</a></p>
            </div>
        </div>
    </div>

    <!-- Header End -->


    <!-- Products Start -->

    <div class="row justify-content-center">
                <div class="col-lg-6">
                    <h1 class="section-title position-relative text-center mb-5" style="text-align:center">All Medicines Available</h1>
                </div>
            </div>
    <div class="container-fluid py-5">
        <div class="container py-5">
            
            <c:forEach var="medicine" items="${allMedicines}">
            <div class="row">
                <div class="pb-2">
                    <div class="product-item d-flex flex-column align-items-center text-center rounded py-5 px-3 " style="width:100%">
                        <div class="bg-primary mt-n5 py-3" style="width: 80px;">
                            <h4 class="font-weight-bold text-black mb-0"><c:out value="${medicine.getPrice() }"></c:out>$$$</h4>
                        </div>
                        <div class="" style="width: 150px; height: 150px;">
                            <img class="rounded-circle w-100 h-100" src="/medicine-photos/${medicine.getId()}/${medicine.getPhotos()}" style="object-fit: cover;">
                        </div><br><br>
                        <h5 class="font-weight-bold mb-4"><c:out value="${medicine.getName() }"></c:out></h5>

                        <a href="/show/${medicine.getId()}" class="btn btn-sm btn-secondary">More Info</a>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
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