package fr.move.in.med.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.move.in.med.model.Patient;
import fr.move.in.med.repository.PatientRepository;

@Repository
public class PatientDao {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient findPatientById(Long id) {
		return patientRepository.getOne(id);
	}
	
	public void createPatient(Patient myPatient) {
		patientRepository.save(myPatient);
	}
	
	public void updatePatient(Patient myPatient) {
		patientRepository.save(myPatient);
	}

	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);
	}
}
