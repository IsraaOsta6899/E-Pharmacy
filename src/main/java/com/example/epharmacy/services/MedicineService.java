package com.example.epharmacy.services;

import java.util.List;
import java.util.Optional;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Service;

import com.example.epharmacy.models.Medicine;
import com.example.epharmacy.repositories.MedicineRepo;

@Service
public class MedicineService {
	private final MedicineRepo medicineRepo;
	public MedicineService(MedicineRepo medicineRepo) {
		this.medicineRepo=medicineRepo;
	}
	public List<Medicine> getAllMedicines() {
		return medicineRepo.findAll();
	}
	public Medicine getMedicineById(Long id) {
		Optional<Medicine> medicine= medicineRepo.findById(id)	;
		return medicine.get();
		}
	public Medicine getMedicineByName(String name) {
		return medicineRepo.findByName(name);
		
	}
	public void updateMedicine(Medicine m) {
		medicineRepo.save(m);
		return;
	}
	public List<Medicine> FindAll(){
		return medicineRepo.findAll();
	 }
	 
	 
	 public Medicine FindMedicine(Long id) {
		 Optional<Medicine> thisMed = medicineRepo.findById(id);
		 if (thisMed.isPresent()) {
			 return thisMed.get();
		 }
		 else {
			 return null;
		 }
	 }
	 
	 public Medicine createMedicine(Medicine b) {
		 return medicineRepo.save(b);
	 }
	 
//	 public Medicine updateBook(Medicine book) {
//		 Medicine med1 = medRepo.findById(book.getId()).orElse(null);
//	        assert med1!=null;
//	        mwd1.setTitle(book.getName());
//	        med1.setAuthor(book.getAur());
//	        med1.setThought(book.getThought());
//	        return boomedRepokRepo.save(book1);
//	    }
	 
	 public Medicine updateMedicine(Long id,Medicine b) {
		 Medicine med = medicineRepo.findById(id).orElse(null);
		 assert med!=null;
		 med.setName(b.getName());
		 med.setPrice(b.getPrice());
		 med.setPrescription(b.isPrescription());
		 med.setExpirydate(b.getExpirydate());
		 med.setQuantity(b.getQuantity());

		 return medicineRepo.save(b);
		 
	 }
	 
	 
	 
 
	 public void delete(Long id) {
	    	Medicine deleteMed = medicineRepo.findById(id).orElse(null); 
	    	medicineRepo.delete(deleteMed);
	  	}
}
