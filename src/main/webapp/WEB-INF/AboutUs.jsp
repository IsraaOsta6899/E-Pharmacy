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
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

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
    <div class="homeSection">
        <img id=aboutUs src="images/aboutus.jpg" id="home"></img>
    </div>
    <div class="jumbotron jumbotron-fluid page-header"> 
        <div class="container text-center">
            <h1 class="text-black display-6" style="margin-top: -20%;">About Us</h1>
            </div>
        </div>
    </div>
        <!-- About Start -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <h1 class="section-title position-relative text-center mb-5" style="margin-top: 50%;">Electronic Pharmacy 2022</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 py-5">
                        <h4 class="font-weight-bold mb-3">About Us</h4>
                        <h5 class="text-muted mb-3" style="text-align: justify;">Many areas far from the city center face difficulty in accessing pharmacies, especially in the case of the need for medicines in the evening and the non-availability of pharmacies on duty next to them. Thus, this website offers to help the pharmacy owner to display the medicines available in his pharmacy on this website as well as to assist the community to request medical prescriptions through it.</h5>
                    </div>
                    <div class="col-lg-4" style="min-height:100px;">
                        <div class="position-relative h-100 rounded overflow-hidden">
                            <img class="position-absolute w-450 h-400" src="images/fo.png" style="object-fit: cover; margin-left: -25%;">
                        </div>
                    </div>
                    <div class="col-lg-4 py-5">
                        <h4 class="font-weight-bold mb-3">Our Features</h4>
                        <h5 class="text-muted mb-3"><i class="fa fa-check text-secondary mr-3"></i> Availability of all-medicines</h5>
                        <h5 class="text-muted mb-3"><i class="fa fa-check text-secondary mr-3"></i> Ability to accept orders 24/7</h5>
                        <h5 class="text-muted mb-3"><i class="fa fa-check text-secondary mr-3"></i> Customers can provide us with a feedback</h5>
                    </div>
                </div>
            </div>
        </div>
        <!-- About End -->

            <!-- Team Start -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <h1 class="section-title position-relative text-center mb-5">Meet Our Team</h1>
                </div>
                <div class="col-lg-6 mb-5 mb-lg-0 pb-5 pb-lg-0"></div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="owl-carousel team-carousel">
                        <div class="team-item">
                            <div class="team-img mx-auto">
                                <img class="rounded-circle w-95 h-95" src="images/member.jpg" style="object-fit: cover;">
                            </div>
                            <div class="position-relative text-center bg-light rounded px-4 py-5" style="margin-top: -100px;">
                                <h3 class="font-weight-bold mt-5 mb-3 pt-5">Israa Usta</h3>
                                <h6 class="text-uppercase text-muted mb-4">Designation</h6>
                                <div class="d-flex justify-content-center pt-1">
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="team-item">
                            <div class="team-img mx-auto">
                                <img class="rounded-circle w-95 h-95" src="images/member.jpg" style="object-fit: cover;">
                            </div>
                            <div class="position-relative text-center bg-light rounded px-4 py-5" style="margin-top: -100px;">
                                <h3 class="font-weight-bold mt-5 mb-3 pt-5">Hanei Islim</h3>
                                <h6 class="text-uppercase text-muted mb-4">Designation</h6>
                                <div class="d-flex justify-content-center pt-1">
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="team-item">
                            <div class="team-img mx-auto">
                                <img class="rounded-circle w-95 h-95" src="images/member.jpg" style="object-fit: cover;">
                            </div>
                            <div class="position-relative text-center bg-light rounded px-4 py-5" style="margin-top: -100px;">
                                <h3 class="font-weight-bold mt-5 mb-3 pt-5">Diana Khalil</h3>
                                <h6 class="text-uppercase text-muted mb-4">Designation</h6>
                                <div class="d-flex justify-content-center pt-1">
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                    <a class="btn btn-outline-secondary btn-social mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                </div>
                            </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Team End -->

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