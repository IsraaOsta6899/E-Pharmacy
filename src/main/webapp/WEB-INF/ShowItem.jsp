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
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

</head>
<body>
    <header>
        <h3>E-Pharmacy</h3>
        <nav  class="mynav" >
            <a class="navbar-link" href="#">HOME</a>
            <a class="navbar-link" href="#">ABOUT </a>
            <a class="navbar-link" href="#">SHOP</a>
            <a class="navbar-link" href="#">CONTACT</a><span>|</span> 
            <img src="images/cart.jpg"   class="cartImage" style="display:block" onclick="toggleText()"></img>
            <a class="navbar-link" href="#">Cart</a>
        </nav>
       
    </header>
    <!-- Shop Detail Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
            <div class="col-lg-5 pb-5">
                <div id="product-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner border">
                        <div class="carousel-item active">
                            <img class="w-100 h-50" style="margin-top: 150px;" src="images/pharmacy.jpg" alt="Image">
                        </div>
                    </div>
                    <a class="carousel-control-prev" data-slide="prev">
                        <i class="fa fa-2x fa-angle-left text-dark"></i>
                    </a>
                    <a class="carousel-control-next" data-slide="next">
                        <i class="fa fa-2x fa-angle-right text-dark"></i>
                    </a>
                </div>
            </div>

            <div class="col-lg-7 pb-5">
            	<form:form action="/addToCart" method="post" modelAttribute="addToCart">
            	<c:forEach items="${medicines}" var="medicine">
                <h3 class="font-weight-semi-bold">Here is Medicine Name...<c:out value=${"medicine.name"}></c:out></h3>
                <h3 class="font-weight-semi-bold mb-4">Here is Medicine Price...<c:out value=${"medicine.price"}></c:out></h3>
                <p class="mb-4">Medicine Description... <c:out value=${"medicine.description"}></c:out></p>
                </c:forEach>
                <div class="d-flex align-items-center mb-4 pt-2">
                    <div class="input-group quantity mr-3" style="width: 130px;">
                        <div class="input-group-btn">
                            <button class="btn btn-primary btn-minus" >
                            <i class="fa fa-minus"></i>
                            </button>
                        </div>
                        <input type="text" class="form-control bg-secondary text-center" value="1">
                        <div class="input-group-btn">
                            <button class="btn btn-primary btn-plus">
                                <i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <button class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</button>
                </div>
            </div>
            </form:form>
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
    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="script.js"></script>

    </div>
</body>