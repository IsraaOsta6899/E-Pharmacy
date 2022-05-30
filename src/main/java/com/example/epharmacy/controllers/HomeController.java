package com.example.epharmacy.controllers;




import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.epharmacy.models.*;
import com.example.epharmacy.repositories.OrderRepo;
import com.example.epharmacy.services.CartMedicineService;
import com.example.epharmacy.services.CartService;
import com.example.epharmacy.services.MedicineService;
import com.example.epharmacy.services.OrderService;
import com.example.epharmacy.services.UserService;


@Controller
public class HomeController {
	private final UserService userService;
	private final MedicineService medicineService;
	private final CartService cartService;
	private final CartMedicineService cartMedicineService;
	private final OrderService orderService;
	public HomeController( UserService userService ,MedicineService medicineService, CartService cartService,CartMedicineService cartMedicineService,OrderService orderService) {
		this.userService=userService;
		this.medicineService=medicineService;
		this.cartService=cartService;
		this.cartMedicineService=cartMedicineService;
		this.orderService=orderService;
		
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
		Cart cart= new Cart();
		
		userService.register(newUser, result);
		cart.setUser(newUser);
		cartService.updateCart(cart);
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
			     if(user2.getRole().getId()==1) {
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
	User user2 = (User) session.getAttribute("user");
	List<Carts_Medicines> myMedicines=cartMedicineService.getAllItemsInThisCart(user2.getCart());
	
model.addAttribute("myMedicines",myMedicines);

	model.addAttribute("user", session.getAttribute("user"));
	model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

	
	return "Home.jsp";
}
@GetMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
}

@GetMapping("/requests")
public String opennRequestPage(Model model) {
	List<Order>allOrders=orderService.getAllOrders();
	model.addAttribute("AllOeders", allOrders);
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
@GetMapping("/show/{id}")
public String openItemPage( Model model, HttpSession session,@PathVariable("id")Long id) {
	model.addAttribute("user", session.getAttribute("user"));
	OrderItem userItem=new OrderItem();
	Medicine midicine= medicineService.getMedicineById(id);
	userItem.setName(midicine.getName());
	userItem.setPrice(midicine.getPrice());
	userItem.setQuantity(midicine.getQuantity());
	userItem.setuQuantity(0);
	System.out.println(midicine.getName());
	System.out.println(userItem.getName());
	model.addAttribute("userItem", userItem);
	session.setAttribute("medicineId", id);
	session.setAttribute("medicinename", midicine.getName());

	
	
	return "ShowItem.jsp";
}
@PostMapping("/addToCart")
public String addItemToUserCart(@Valid@ModelAttribute("userItem")OrderItem userItem,BindingResult result,Model model , HttpSession session ) {
	OrderItem orderItem=userItem;
	System.out.println(userItem.getName());
	Medicine d= medicineService.getMedicineByName((String) session.getAttribute("medicinename"));
	System.out.println(d.getId()+"llllllllllllllllllll");
	User user2 = (User) session.getAttribute("user");
	List<Carts_Medicines>carts_Medicines=cartMedicineService.getAllItemsInThisCart(user2.getCart());
	if(carts_Medicines==null) {
		Carts_Medicines newRecord = new Carts_Medicines();
		newRecord.setCart(user2.getCart());
		newRecord.setMedicine(d);
		newRecord.setNumber_of_items(orderItem.getuQuantity());
		cartMedicineService.add(newRecord);
		d.setQuantity(d.getQuantity()-orderItem.getuQuantity());
		medicineService.updateMedicine(d);
		
	}
	else {
		int flag= 0;
		for (Carts_Medicines carts_Medicines2 : carts_Medicines) {
			if(carts_Medicines2.getMedicine().getId()==d.getId()) {
				int prevCount=carts_Medicines2.getNumber_of_items();
				carts_Medicines2.setNumber_of_items(prevCount+orderItem.getuQuantity());
				cartMedicineService.add(carts_Medicines2);
				
			}
			
		}
		if(flag==0) {
			Carts_Medicines newRecord = new Carts_Medicines();
			newRecord.setCart(user2.getCart());
			newRecord.setMedicine(d);
			newRecord.setNumber_of_items(orderItem.getuQuantity());
			cartMedicineService.add(newRecord);
		}
		
	}
	
	
	return "redirect:/home";

}
@GetMapping("/getMyCartItems")
public String getAllItemInCart(HttpSession session , Model model ) {
	User user2 = (User) session.getAttribute("user");
	List<Carts_Medicines> myMedicines=cartMedicineService.getAllItemsInThisCart(user2.getCart());
	
model.addAttribute("myMedicines",myMedicines);
	return "Home.jsp";
	
}
@RequestMapping("/sentOrder/{id}")
public String addItemsToOrder(@PathVariable("id")Long cartId,HttpSession session ,Model model) {
	Order newOrder= new Order();
	User user2 = (User) session.getAttribute("user");
	newOrder.setUserr(user2);
	int totalPrice=0;
	Cart myCart=cartService.getCartById(cartId);
	List<Carts_Medicines>allMedicines= cartMedicineService.getAllItemsInThisCart(myCart);
	List<Medicine>medicines= new ArrayList<Medicine>();
	for (Carts_Medicines carts_Medicines : allMedicines) {
		totalPrice+=carts_Medicines.getNumber_of_items()*carts_Medicines.getMedicine().getPrice();
		medicines.add(carts_Medicines.getMedicine());
		
	}
	newOrder.setMedicines(medicines);
	newOrder.setTotalPrice(totalPrice);
	orderService.addNewOrder(newOrder);
	List<Carts_Medicines> a=cartMedicineService.getAll();
	for (Carts_Medicines carts_Medicines : a) {
		if(carts_Medicines.getCart()==myCart) {
			cartMedicineService.deleteElement(carts_Medicines);
		}
	}
	
	return "redirect:/home";
}
@RequestMapping("/accept/{id}")
public String acceptOrder(@PathVariable("id")Long id) {
	Order deleteOrder= orderService.findOrderById(id);
	orderService.deleteOrder(deleteOrder);
	return "redirect:/requests";
	
}

@RequestMapping("/reject/{id}")
public String rejectOrder(@PathVariable("id")Long id) {
	Order deleteOrder= orderService.findOrderById(id);
	orderService.deleteOrder(deleteOrder);
	return "redirect:/requests";
	
}
}
