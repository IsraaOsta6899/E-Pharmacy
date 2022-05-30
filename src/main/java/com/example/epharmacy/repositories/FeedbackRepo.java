package com.example.epharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.epharmacy.models.Feedback;
import com.example.epharmacy.models.User;

@Repository
public interface FeedbackRepo extends CrudRepository<Feedback, Long> {
	List<Feedback>findAll();
	List<Feedback>findAllByUser(User user);

}
