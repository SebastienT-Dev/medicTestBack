package fr.move.in.med.services;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.move.in.med.dao.PatientDao;
import fr.move.in.med.exceptions.CustomException;
import fr.move.in.med.model.Patient;
import fr.move.in.med.utils.MapperUtils;
import fr.move.in.med.vo.PatientVo;

@Service
public class PatientService  {
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private MapperUtils mapper;
	
	
	public List<Patient> getAllPatients() throws CustomException {
		
		List<Patient> listPatients= patientDao.getAllPatients();
		
		if (CollectionUtils.isEmpty(listPatients)) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(), "Aucun patient existant");
		}
		
		return patientDao.getAllPatients();
	}
	

	public Patient getPatientById(Long id) throws CustomException {
		Patient myPatient = patientDao.findPatientById(id);
		
		if (myPatient == null) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(), "Aucun patient existant avec cet ID");
		}
		
		return myPatient;
	}
	
	public void createPatient(PatientVo myPatientToCreate) {
		patientDao.createPatient((Patient) mapper.convertObject(myPatientToCreate, Patient.class));
	}
	
	public void updateMyPatient(PatientVo myPatientToUpdate, Long id) throws CustomException {
		
		if (patientDao.findPatientById(id) == null) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(), "Patient inexistant, impossible d'effectuer la mise à jour");
		}
		
		myPatientToUpdate.setIdPatient(id);
		Patient patientUpdate = (Patient) mapper.convertObject(myPatientToUpdate, Patient.class);
		patientDao.updatePatient(patientUpdate);
	}
	
	public void deletePatient(Long id) throws CustomException {
		
		if (patientDao.findPatientById(id) == null) {
			throw new CustomException(HttpStatus.NOT_FOUND.name(), "Patient inexistant, impossible de le supprimer");
		}
		
		patientDao.deletePatientById(id);
	}
}
