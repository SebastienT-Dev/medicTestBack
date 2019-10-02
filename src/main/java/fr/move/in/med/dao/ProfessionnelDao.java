package fr.move.in.med.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.move.in.med.model.Professionnel;
import fr.move.in.med.repository.ProfessionnelRepository;

@Repository
public class ProfessionnelDao {

	@Autowired
	private ProfessionnelRepository professionnelRepo;
	
	public List<Professionnel> getAllProfessionnels() {
		return professionnelRepo.findAll();
	}

	public Professionnel findProfessionnelById(Long id) {
		return professionnelRepo.getOne(id);
	}
	
	public void createPatient(Professionnel myPro) {
		professionnelRepo.save(myPro);
	}

	public void updateProfessionnel(Professionnel myPro) {
		professionnelRepo.save(myPro);
	}

	public void deleteProfessionnelById(Long id) {
		professionnelRepo.deleteById(id);
	}
}
