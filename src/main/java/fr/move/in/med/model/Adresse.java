package fr.move.in.med.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * @author sebastienternisien
 * @since 26/09/2019
 * 
 *        Classe représentant le modéle de donnée pour la table "adresse"
 * 
 */
@Entity
@Table(name = "adresse")
public class Adresse {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdresse")
	private Integer idAdresse;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "codePostal")
	private String codePostal;
	
	@Column(name = "ville")
	private String ville;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idTypeAdresse")
	private TypeAdresse typeAdresse;
	
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient monPatient;
	
	@ManyToOne
	@JoinColumn(name = "idPro")
	private Professionnel monPro;
	
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public TypeAdresse getTypeAdresse() {
		return typeAdresse;
	}

	public void setTypeAdresse(TypeAdresse typeAdresse) {
		this.typeAdresse = typeAdresse;
	}

	public Patient getMonPatient() {
		return monPatient;
	}

	public void setMonPatient(Patient monPatient) {
		this.monPatient = monPatient;
	}

	public Professionnel getMonPro() {
		return monPro;
	}

	public void setMonPro(Professionnel monPro) {
		this.monPro = monPro;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
