package com.example.epharmacy.controllers;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.epharmacy.services.*;
import com.example.epharmacy.fil.FileUploadUtil;
import com.example.epharmacy.models.*;


@Controller
public class HomeController {
	private final UserService userService;
	private final MedicineService medicineService;
	private final CartService cartService;
	private final CartMedicineService cartMedicineService;
	private final OrderService orderService;

    private final CategoryService cateServ;

	private final FeedbackService feedbackService;
	public HomeController( UserService userService ,CategoryService cateServ,MedicineService medicineService, CartService cartService,CartMedicineService cartMedicineService,OrderService orderService, FeedbackService feedbackService) {

		this.userService=userService;
		this.medicineService=medicineService;
		this.cartService=cartService;
		this.cartMedicineService=cartMedicineService;
		this.orderService=orderService;

		this.cateServ=cateServ;

		this.feedbackService = feedbackService;


		
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
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	User user2 = (User) session.getAttribute("user");
	List<Carts_Medicines> myMedicines=cartMedicineService.getAllItemsInThisCart(user2.getCart());
	
model.addAttribute("myMedicines",myMedicines);

	model.addAttribute("user", session.getAttribute("user"));
	model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

	
	return "Home.jsp";
}
@GetMapping("/logout")
public String logout(HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	session.invalidate();
	return "redirect:/";
}

@GetMapping("/requests")
public String opennRequestPage(Model model,HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	
	List<Order>allOrders=orderService.getAllOrders();
	model.addAttribute("AllOeders", allOrders);
	return "AllOrders.jsp";
}
  
@GetMapping("/contactus")
public String openContactUs(@ModelAttribute("newFeedback") Feedback newFeedback, Model model, HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	model.addAttribute("user", session.getAttribute("user"));
	System.out.println("okkkkk");
	model.addAttribute("title", "Add Feedback");
	model.addAttribute("feedback", new Feedback());
	
	return "ContactUs.jsp";
}

@PostMapping("/ContactUs")
public String contactUs(Model model, @ModelAttribute("newFeedback") Feedback newFeedback, HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	User user2 = (User) session.getAttribute("user");
	newFeedback.setUser(user2);
	
	feedbackService.addFeedback(newFeedback);
	user2.getFeedbacks().add(newFeedback);
	
	List<Feedback>allFeedbacks=   user2.getFeedbacks();
	allFeedbacks.add(newFeedback);
	user2.setFeedbacks(allFeedbacks);
	List<Feedback> feedbacks = user2.getFeedbacks();
	feedbacks.add(newFeedback);
	user2.setFeedbacks(feedbacks);
	this.userService.updateUser(user2);
	
	System.out.println("FeedBack " + newFeedback);
	System.out.println("Added to data base");
	
	return "FeedbackSucces.jsp";
}
@GetMapping("/show/{id}")
public String openItemPage( Model model, HttpSession session,@PathVariable("id")Long id) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
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
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
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
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	User user2 = (User) session.getAttribute("user");
	List<Carts_Medicines> myMedicines=cartMedicineService.getAllItemsInThisCart(user2.getCart());
	
model.addAttribute("myMedicines",myMedicines);
	return "Home.jsp";
	
}
@RequestMapping("/sentOrder/{id}")
public String addItemsToOrder(@PathVariable("id")Long cartId,HttpSession session ,Model model) {
	
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}Order newOrder= new Order();
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
public String rejectOrder(@PathVariable("id")Long id,HttpSession session) {
	
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}Order deleteOrder= orderService.findOrderById(id);
	orderService.deleteOrder(deleteOrder);
	return "redirect:/requests";
	
}

@GetMapping("/medicine/new")
public String addMedicine(@ModelAttribute("newMedicine") Medicine newMedicine,Model model,HttpSession session) {
	
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	User user2 = (User) session.getAttribute("user");

	if(user2.getRole().getId()==1) {
	
	List<com.example.epharmacy.models.Category> cateList=cateServ.FindAll();
	model.addAttribute("cateList", cateList);
	return "AddMedicine.jsp";

	}
	else {
		return "redirect:/";
	}
	
   
}

@PostMapping("/medicine/new")
public String addMdeicine(@Valid @ModelAttribute("newMedicine") Medicine newMedicine, 
        BindingResult result,HttpSession session, @RequestParam("image") MultipartFile multipartFile) throws IOException{
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	User user2 = (User) session.getAttribute("user");

	if(user2.getRole().getId()==1) {
	if(result.hasErrors()) {
		System.out.println("helllo");
		System.out.println(result.hasErrors());
	return "AddMedicine.jsp";
		
	}else {
		

		
//		Long userId=(Long)session.getAttribute("userId");
//	    User currenUser=userServ.findbyId(userId);
//	    newMedicine.setUser(currenUser);
//	    bookServ.createBook(newMedicine);
		
	      
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        newMedicine.setPhotos(fileName);
//		newMedicine.setExpirydate(new SimpleDateFormat("dd/MM/yyyy").parse(newMedicine.getExpirydate())); 
		medicineService.createMedicine(newMedicine);
//		
	    String uploadDir = "medicine-photos/" + newMedicine.getId();
	       
	    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	    
		return "redirect:/home";
		
}}
	else {
		return"redirect:/";
	}
    


}


@GetMapping("/medicine/{id}/edit")
public String editMedicine( @ModelAttribute("newMedicine") Medicine newMedicine,@PathVariable("id") Long id, Model model,HttpSession session) {
	
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	User user2 = (User) session.getAttribute("user");

	if(user2.getRole().getId()==1) {
	Medicine medFound=medicineService.FindMedicine(id);
	 String date=String.valueOf(medFound.getExpirydate()).split(" ")[0];
	 System.out.println(date); 
        model.addAttribute("medicine", medFound);
        model.addAttribute("date", date);
    	List<com.example.epharmacy.models.Category> cateList=cateServ.FindAll();
		model.addAttribute("cateList", cateList);

return "Edit.jsp";}
	else {
		return "redirect:/";
	}
}

@RequestMapping("/medicine/{id}/edit")
public String editMdeicine(@Valid @ModelAttribute("newMedicine") Medicine newMedicine,BindingResult result,HttpSession session
         ,@PathVariable("id") Long id) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}	
	User user2 = (User) session.getAttribute("user");

	if(user2.getRole().getId()==1) {
	if(result.hasErrors()) {
		
		System.out.println("helllo");
		System.out.println(result.hasErrors());
	return "Edit.jsp";
		
	}else {

		
		System.out.println(newMedicine.toString());
		medicineService.updateMedicine(id,newMedicine);
		return "redirect:/home";
		
}}
	else {
		return "redirect:/";
	}
    


}

@RequestMapping("/names/{id}/delete")
public String destroy(@PathVariable("id") Long id,HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	User user2 = (User) session.getAttribute("user");
System.out.println("ggggggggggggggggggggggggggggggggggggggggggggg");
	if(user2.getRole().getId()==1) {
	medicineService.delete(id);
    return "redirect:/home";
    }
	else {
		return"redirect:/";
	}
}

@GetMapping("/aboutUs")
public String openApoutUsPage(HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/login";
	}
	return "AboutUs.jsp";
}


@GetMapping("/allmedicines")
public String allMedicines(HttpSession session , Model model ) {
	
	User user2 = (User) session.getAttribute("user");
	
	List<Medicine> allMedicines= medicineService.getAllMedicines();
	for (Medicine medicine : allMedicines) {
		System.out.println(medicine.getName());
		System.out.println(medicine.getPrice());
	}
	model.addAttribute("allMedicines",allMedicines);
	return "AllMed.jsp";
	
}


@GetMapping("/allmedicinesInCat/{id}")
public String allMedicinesInCat(HttpSession session , Model model,@PathVariable("id") Long id) {
	
	User user2 = (User) session.getAttribute("user");
	Category category= cateServ.getCategory(id);
	List<Medicine> allMedicines= medicineService.getAllMedicinesInCat(category);
	for (Medicine medicine : allMedicines) {
		System.out.println(medicine.getName());
		System.out.println(medicine.getPrice());
	}
	model.addAttribute("allMedicines",allMedicines);
	return "AllAnimalInCategory.jsp";
	
}

}
