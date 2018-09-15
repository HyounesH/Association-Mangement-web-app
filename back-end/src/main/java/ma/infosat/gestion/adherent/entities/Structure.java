package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Structure implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_structure;
	private String nom;
	private LocalDate dateCreation;
	private String email;
	private String siteWeb;
	private String objectif;
	private String logo;
	private String adresse;
	private String telephone;
	
	//reflexive association annotation mapping
	//une structure peut avoir plusiers sous structure
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="structure_sup_id")
	private Structure structure_sup;
	
	@OneToMany(mappedBy="structure_sup",cascade=CascadeType.ALL)
	private Set<Structure> structures=new HashSet<Structure>();
	
	@OneToMany(mappedBy="structure",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Departement> departements=new HashSet<Departement>();
	
	public Structure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Structure(String nom, LocalDate dateCreation, String email, String adresse, String ville, String telephone,
			String siteWeb, String objectif) {
		super();
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.email = email;
		this.siteWeb = siteWeb;
		this.objectif = objectif;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public Set<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}
	public Structure getStructure_sup() {
		return structure_sup;
	}
	public void setStructure_sup(Structure structure_sup) {
		this.structure_sup = structure_sup;
	}
	public Set<Structure> getStructures() {
		return structures;
	}
	public void setStructures(Set<Structure> structures) {
		this.structures = structures;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Long getId_structure() {
		return id_structure;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setId_structure(Long id_structure) {
		this.id_structure = id_structure;
	}
	

}
