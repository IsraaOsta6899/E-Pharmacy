package com.example.epharmacy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.epharmacy.models.Feedback;
import com.example.epharmacy.repositories.RequestRepo;

@Service
public class RequestService {
private final RequestRepo requestRepo;
public RequestService(RequestRepo requestRepo) {
	this.requestRepo=requestRepo;
	
}
public List<Feedback> getAllFeedBacks(){
	return requestRepo.findAll();
}
}
