package com.example.epharmacy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.epharmacy.models.Feedback;
import com.example.epharmacy.models.User;
import com.example.epharmacy.repositories.FeedbackRepo;

@Service
public class FeedbackService {
	private final FeedbackRepo feedbackRepo;
	public FeedbackService(FeedbackRepo feedbackRepo) {
		this.feedbackRepo = feedbackRepo;
	}

	public List<Feedback>getAllFeedbacks(){
		return feedbackRepo.findAll();
	}

	public List<Feedback>yourFeedbacks(User user){
		return feedbackRepo.findAllByUser(user);
	}
	
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepo.save(feedback);
	}
}