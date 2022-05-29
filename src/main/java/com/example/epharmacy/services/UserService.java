package com.example.epharmacy.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.epharmacy.models.*;
import com.example.epharmacy.repositories.RoleRepo;
import com.example.epharmacy.repositories.UserRepo;

@Service
public class UserService  {
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	public UserService ( UserRepo userRepo,RoleRepo roleRepo) {
		this.userRepo=userRepo;	
		this.roleRepo=roleRepo;
	}
	public User register(User newUser, BindingResult result) {
		List<User>allUsers=userRepo.findAll();
		if(allUsers.size()==0) {
			//create admin user
			Role newRole = new Role();
			List<Role>allRoles=roleRepo.findAll();
			newRole=allRoles.get(0);
			
			User user2=newUser;
	    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    	newUser.setPassword(hashed);
	    	newUser.setRole(newRole);
	    	userRepo.save(newUser);
	    	return newUser;
			
		}
		else {
			//create normal user
    	Optional<User> user=userRepo.findByEmail(newUser.getEmail());

    	if(user.isEmpty()) {
    		User user2=newUser;
    		Role newRole = new Role();
			List<Role>allRoles=roleRepo.findAll();
			newRole=allRoles.get(1);
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	newUser.setRole(newRole);

    	userRepo.save(newUser);
    	return newUser;
    	}
    	else {
    		ObjectError error=new ObjectError("inValid Email", "This email is already exist");
    		result.addError(error);
    		User user3=new User();
    		return user3;
    	}
        
    }
    
	}
	 public User login(LoginUser newLoginObject, BindingResult result) {
	    	Optional<User> user=userRepo.findByEmail(newLoginObject.getEmail());
	    	if(user.isEmpty()) {
			    result.rejectValue("email", "invalidEmail", "Invalid email!");

	    		return new User();

	    	}
	    	else {

	    		User user2= user.get();
	    		if(!BCrypt.checkpw(newLoginObject.getPassword(), user2.getPassword())) {

	    		    result.rejectValue("password", "Matches", "Invalid Password!");
	    		    return new User();
	    		}
	    		else {

					return user2;
				}
	    	}

	    }
	 public User getUser(String email) {
		Optional<User> user1=   userRepo.findByEmail(email);
		User user=user1.get();
		return user;
	 }
	 public User findByEmail(String email) {
		Optional<User> user= userRepo.findByEmail(email);
		return user.get();
	 }
	   
	

}
