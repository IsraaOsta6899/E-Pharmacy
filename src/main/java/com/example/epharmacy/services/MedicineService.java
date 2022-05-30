package com.example.epharmacy.services;

import java.util.List;
import java.util.Optional;

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
}
