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
import fr.move.in.med.model.Professionnel;
import fr.move.in.med.services.ProfessionnelService;
import fr.move.in.med.status.RestApiStatus;
import fr.move.in.med.vo.ProfessionnelVo;

@RestController
@RequestMapping("/app")
public class ProfessionnelRestController {

	@Autowired
	private ProfessionnelService professionnelService;

	@RequestMapping(value = "/professionnels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Professionnel>> findAllProfessionnels() throws CustomException {
		return new ResponseEntity<List<Professionnel>>(professionnelService.getAllProfessionnels(), HttpStatus.OK);
	}

	@RequestMapping(value = "/professionnels", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RestApiStatus> createProfessionnel(@Valid @RequestBody ProfessionnelVo myProfessionnel)
			throws CustomException {
		professionnelService.createProfessionnel(myProfessionnel);
		return new ResponseEntity<RestApiStatus>(new RestApiStatus(HttpStatus.CREATED.name(), "Le professionnel a été créé avec succés"), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/professionnels/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RestApiStatus> upateProfessionnelById(@PathVariable(name = "id") Long id,
			@Valid @RequestBody ProfessionnelVo myProfessionnelToUpdate) throws CustomException {
		professionnelService.updateMyProfessionnel(myProfessionnelToUpdate, id);
		return new ResponseEntity<RestApiStatus>(new RestApiStatus(HttpStatus.OK.name(), "Le professionnel a été mis à jour avec succés"), HttpStatus.OK);
	}

	@RequestMapping(value = "/professionnels/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RestApiStatus> deleteProfessionnelById(@PathVariable(name = "id") Long id) throws CustomException {
		professionnelService.deleteProfessionnel(id);
		return new ResponseEntity<RestApiStatus>(new RestApiStatus(HttpStatus.OK.name(), "Le professionnel a été supprimé avec succés"), HttpStatus.OK);
	}

}
