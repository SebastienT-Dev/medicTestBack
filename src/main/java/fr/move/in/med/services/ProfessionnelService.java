package fr.move.in.med.services;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.move.in.med.dao.ProfessionnelDao;
import fr.move.in.med.exceptions.CustomException;
import fr.move.in.med.model.Professionnel;
import fr.move.in.med.utils.MapperUtils;
import fr.move.in.med.vo.ProfessionnelVo;

@Service
public class ProfessionnelService {

	@Autowired
	private ProfessionnelDao professionnelDao;
	
	@Autowired
	private MapperUtils mapper;
	
	public List<Professionnel> getAllProfessionnels() throws CustomException {

		List<Professionnel> listProfessionnels = professionnelDao.getAllProfessionnels();

		if (CollectionUtils.isEmpty(listProfessionnels)) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(), "Aucun Professionnel existant");
		}

		return professionnelDao.getAllProfessionnels();
	}

	public Professionnel getProfessionnelById(Long id) throws CustomException {
		Professionnel myProfessionnel = professionnelDao.findProfessionnelById(id);

		if (myProfessionnel == null) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(), "Aucun Professionnel existant avec cet ID");
		}

		return myProfessionnel;
	}
	
	public void createProfessionnel(ProfessionnelVo myPatientToCreate) {
		professionnelDao.createPatient((Professionnel) mapper.convertObject(myPatientToCreate, Professionnel.class));
	}
	

	public void updateMyProfessionnel(ProfessionnelVo myProfessionnelToUpdate, Long id) throws CustomException {

		if (professionnelDao.findProfessionnelById(id) == null) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(),
					"Professionnel inexistant, impossible d'effectuer la mise à jour");
		}

		myProfessionnelToUpdate.setIdPro(id);
		Professionnel ProfessionnelUpdate = (Professionnel) mapper.convertObject(myProfessionnelToUpdate, Professionnel.class);
		professionnelDao.updateProfessionnel(ProfessionnelUpdate);
	}

	public void deleteProfessionnel(Long id) throws CustomException {

		if (professionnelDao.findProfessionnelById(id) == null) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(), "Professionnel inexistant, impossible de le supprimer");
		}

		professionnelDao.deleteProfessionnelById(id);
	}

}
