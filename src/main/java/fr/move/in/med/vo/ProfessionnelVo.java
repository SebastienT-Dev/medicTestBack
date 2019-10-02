package fr.move.in.med.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.dozer.Mapping;

import fr.move.in.med.constants.Message;
import fr.move.in.med.model.Adresse;

/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "professionnel"
 * 
 */
public class ProfessionnelVo {

	@Mapping(value = "idPro")
	private Long idPro;

	@NotEmpty(message = Message.NOM_EMPTY)
	private String nom;

	@NotEmpty(message = Message.NOM_EMPTY)
	private String prenom;
	
	@Email(message = Message.EMAIL_INVALID)
	private String adresseMail;
	
	private DomaineProVo domaineProfessionnel;
	
	private Set<PatientVo> listPatients = new HashSet<PatientVo>();

	private List<Adresse> listAdresses = new ArrayList<Adresse>();

	public ProfessionnelVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdPro() {
		return idPro;
	}

	public void setIdPro(Long idPro) {
		this.idPro = idPro;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public DomaineProVo getDomaineProfessionnel() {
		return domaineProfessionnel;
	}

	public void setDomaineProfessionnel(DomaineProVo domaineProfessionnel) {
		this.domaineProfessionnel = domaineProfessionnel;
	}

	public Set<PatientVo> getListPatients() {
		return listPatients;
	}

	public void setListPatients(Set<PatientVo> listPatients) {
		this.listPatients = listPatients;
	}

	public List<Adresse> getListAdresses() {
		return listAdresses;
	}

	public void setListAdresses(List<Adresse> listAdresses) {
		this.listAdresses = listAdresses;
	}

}
