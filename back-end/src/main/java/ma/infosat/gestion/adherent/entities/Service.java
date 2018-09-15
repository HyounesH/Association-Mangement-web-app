package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Service implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_service;
	private String nom;
	private String adresse;
	//reflexive association annotation mapping
	//un service peut avoir plusiers sous service
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_sercive_sup")
	private Service service_sup;
	
	@OneToMany(mappedBy="service_sup")
	private Set<Service> services=new HashSet<Service>();
	
	@ManyToOne
	@JoinColumn(name="id_depart")
	private Departement departement;
	
	@OneToMany(mappedBy="service",cascade=CascadeType.ALL)
	private Set<Adherent> adherents=new HashSet<Adherent>();
	
	@OneToMany(mappedBy="service")
	private Set<Action> actions=new HashSet<Action>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	public Service(String nom, String adresse, String ville) {
		super();
		this.nom = nom;
	}
	
	public Service() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Service getService_sup() {
		return service_sup;
	}

	public void setService_sup(Service service_sup) {
		this.service_sup = service_sup;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}
    @JsonIgnore
	public Set<Adherent> getAdherents() {
		return adherents;
	}
    @JsonSetter
	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
    
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Long getId_service() {
		return id_service;
	}

	public void setId_service(Long id_service) {
		this.id_service = id_service;
	}
	
	
	
    
}
