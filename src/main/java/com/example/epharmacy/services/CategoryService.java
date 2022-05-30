package com.example.epharmacy.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.epharmacy.repositories.*;

import com.example.epharmacy.models.*;



@Service
public class CategoryService {
	 @Autowired
 private 	CategoryRepo cateRepo;
	 
	 
	 public List<Category> FindAll(){
		return (List<Category>) cateRepo.findAll();
	 }
	 
	 
//	 public Medicine FindMedicine(Long id) {
//		 Optional<Medicine> thisMed = cateRepo.findById(id);
//		 if (thisMed.isPresent()) {
//			 return thisMed.get();
//		 }
//		 else {
//			 return null;
//		 }
//	 }
	 
	 public Category createMedicine(Category b) {
		 return cateRepo.save(b);
	 }
	 
//	 public Medicine updateBook(Medicine book) {
//		 Medicine med1 = medRepo.findById(book.getId()).orElse(null);
//	        assert med1!=null;
//	        mwd1.setTitle(book.getTitle());
//	        med1.setAuthor(book.getAuthor());
//	        med1.setThought(book.getThought());
//	        return boomedRepokRepo.save(book1);
//	    }
////	 
//	 public void delete(Long id) {
//	    	Medicine deleteBook = cateRepo.findById(id).orElse(null); 
//	    	medRepo.delete(deleteBook);
//	  	}

}

