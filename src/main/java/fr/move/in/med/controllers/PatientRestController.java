package fr.move.in.med.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.move.in.med.exceptions.CustomException;
import fr.move.in.med.model.Patient;
import fr.move.in.med.services.PatientService;
import fr.move.in.med.status.RestApiStatus;
import fr.move.in.med.vo.PatientVo;

@RestController
@RequestMapping("/app")
public class PatientRestController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value = "/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Patient>> findAllPatients() throws CustomException {
		return new ResponseEntity<List<Patient>>(patientService.getAllPatients(), HttpStatus.OK);
	}

	@RequestMapping(value = "/patients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RestApiStatus> createPatient(@Valid @RequestBody PatientVo myPatient) throws CustomException {
		patientService.createPatient(myPatient);
		return new ResponseEntity<RestApiStatus>(new RestApiStatus(HttpStatus.CREATED.name(), "Le patient a été créé avec succés"), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/patients/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RestApiStatus> deletePatientById(@PathVariable(name = "id") Long id) throws CustomException {
		patientService.deletePatient(id);
		return new ResponseEntity<RestApiStatus>(new RestApiStatus(HttpStatus.OK.name(), "Le patient a été mis à jour avec succés"), HttpStatus.OK);
	}

	@RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RestApiStatus> upatePatientById(@PathVariable(name = "id") Long id, @Valid @RequestBody PatientVo myPatientToUpdate) throws CustomException {
		patientService.updateMyPatient(myPatientToUpdate, id);
		return new ResponseEntity<RestApiStatus>(new RestApiStatus(HttpStatus.OK.name(), "Le patient a été supprimé avec succés"), HttpStatus.OK);
	}

}
