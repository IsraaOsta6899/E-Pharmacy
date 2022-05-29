package com.example.epharmacy.controllers;



import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.epharmacy.models.*;
import com.example.epharmacy.services.UserService;


@Controller
public class HomeController {
	private final UserService userService;
	public HomeController( UserService userService) {
		this.userService=userService;
		
	}
@GetMapping("/")
public String openWelcomePage() {
	return "welcom.jsp";
}
@GetMapping("/Register")
public String openRegisterPage(Model model) {
	User newUser = new User(); 
	
    model.addAttribute("newUser", newUser);
	return "registration.jsp";
}

@GetMapping("/login")
public String openLoginPage(Model model) {
	LoginUser newLogin = new LoginUser();
    model.addAttribute("newLogin", newLogin);
	return "login.jsp";
}

@PostMapping("/register")
public String createNewUser(Model model,@Valid @ModelAttribute("newUser") User newUser,BindingResult result ) {
	System.out.println("okkkkk");
	if(result.hasErrors()) {
		System.out.println("olllll");
		return "registration.jsp";
	}
	else {
		System.out.println("ommmm");
		userService.register(newUser, result);

		return "redirect:/login";
		
	}
	
	
	
}

@PostMapping("/Login")
public String login(Model model,@Valid @ModelAttribute("newLogin") LoginUser newLogin,BindingResult result, HttpSession session) {
		     
	      User user = this.userService.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "login.jsp";
	     }
	     else {
	    	 System.out.println(";;;;;;;;;;;;;;;;");
			     User user2= userService.getUser(newLogin.getEmail());
			     session.setAttribute("user", user2);
			     boolean isAdmin= false;
			     if(user2.getRole().getId()==7) {
			    	 isAdmin=true;
			     }
			     System.out.println(isAdmin);
			     session.setAttribute("user", user2);
			     session.setAttribute("isAdmin", isAdmin); 
		    	 System.out.println(";;;;;;;;;;;;;;;;;");
		    	 
			     return "redirect:/home";
	     	}
	     }
@GetMapping("/home")
public String home(Model model,HttpSession session,Principal principal) {
	model.addAttribute("user", session.getAttribute("user"));
	model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

	
	return "Home.jsp";
}
@GetMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
}
@GetMapping("/feedbacks")
public String openFeedbackPage(Model model) {
	//to get all feedbacks later
	return "displayFeedbacks.jsp";
	
}
@GetMapping("/requests")
public String opennRequestPage(Model model) {
	//add all orders
	return "AllOrders.jsp";
}
  
@GetMapping("/contactus")
public String openContactUs(@ModelAttribute("newFeedback") Feedback newFeedback, Model model, HttpSession session) {
	model.addAttribute("user", session.getAttribute("user"));
	System.out.println("okkkkk");
	model.addAttribute("title", "Add Feedback");
	model.addAttribute("feedback", new Feedback());
	
	return "ContactUs.jsp";
}

@PostMapping("/ContactUs")
public String contactUs(@ModelAttribute("newFeedback") Feedback newFeedback, HttpSession session) {
	User user2 = (User) session.getAttribute("user");
	
	newFeedback.setUser(user2);
	
	user2.getFeedbacks().add(newFeedback);
	
	this.userService.updateUser(user2);
	
	System.out.println("FeedBack " + newFeedback);
	System.out.println("Added to data base");
	
	return "ContactUs.jsp";
}

}
