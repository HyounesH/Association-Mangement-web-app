package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
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
public class Departement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_depart;
	private String nom;
	private String note;
	private String adresse;
	private String telephone;
	//reflexive association annotation mapping 
	//un departement peut avoir plusiers department
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_depart_sup")
	private Departement depart_sup;
	
	@OneToMany(mappedBy="depart_sup")
	private Set<Departement> departements=new HashSet<Departement>();
	
	
	@ManyToOne
	@JoinColumn(name="id_structure")
	private Structure structure;
	
	@OneToMany(mappedBy="departement",fetch=FetchType.LAZY)
	private Set<Service> services = new HashSet<Service>();
	
	public Departement(String nom, String adresse, String ville) {
		super();
		this.nom = nom;
	}
	
	public Departement() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Departement getDepart_sup() {
		return depart_sup;
	}

	public void setDepart_sup(Departement depart_sup) {
		this.depart_sup = depart_sup;
	}

	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}

	public Long getId_depart() {
		return id_depart;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
    
	
	
	
	
   
}
