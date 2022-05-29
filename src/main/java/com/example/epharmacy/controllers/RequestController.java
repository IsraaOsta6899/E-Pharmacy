package com.example.epharmacy.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.epharmacy.models.Feedback;
import com.example.epharmacy.services.RequestService;

@Controller
public class RequestController {
private final RequestService requestService;
public RequestController(RequestService requestService) {
	this.requestService=requestService;
}
@GetMapping("/feedbacks")
public String opennRequestPage(Model model) {
	List<Feedback>allFeedbacks=requestService.getAllFeedBacks();
	model.addAttribute("allFeedbacks", allFeedbacks);
	for (Feedback feedback : allFeedbacks) {
		System.out.println(feedback.getMessage());
	}
	return "displayFeedbacks.jsp";
}
}

