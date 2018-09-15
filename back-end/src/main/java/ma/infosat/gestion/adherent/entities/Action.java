package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Action  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long action_id;
	private String action_nom;
	private String lieu;
	private LocalDate dateCreation;
	private LocalDate dateRealise;
	private String objectif;
	
	@ManyToOne
	@JoinColumn(name="id_service")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name="typeAction_id")
	private TypeAction typeAction;
	
	@ManyToOne
	@JoinColumn(name="situation_id")
	private TypeAction situation;
	
	@OneToMany(mappedBy="action")
	private Set<Media> media=new HashSet<Media>();
	
	@OneToMany(mappedBy="fk.action")
	private Set<Equipe> equipes=new HashSet<Equipe>();
	
	public Action(String action_nom, String lieu, LocalDate dateRealise, String objectif) {
		super();
		this.action_nom = action_nom;
		this.lieu = lieu;
		this.dateCreation =LocalDate.now();
		this.dateRealise = dateRealise;
		this.objectif = objectif;
	}
	public Action() {}
	public String getAction_nom() {
		return action_nom;
	}
	public void setAction_nom(String action_nom) {
		this.action_nom = action_nom;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public LocalDate getDateRealise() {
		return dateRealise;
	}
	public void setDateRealise(LocalDate dateRealise) {
		this.dateRealise = dateRealise;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public TypeAction getTypeAction() {
		return typeAction;
	}
	public void setTypeAction(TypeAction typeAction) {
		this.typeAction = typeAction;
	}
	public TypeAction getSituation() {
		return situation;
	}
	public void setSituation(TypeAction situation) {
		this.situation = situation;
	}
	public Set<Media> getMedia() {
		return media;
	}
	public void setMedia(Set<Media> media) {
		this.media = media;
	}
	public Set<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}
	public Long getAction_id() {
		return action_id;
	}
	public void setAction_id(Long action_id) {
		this.action_id = action_id;
	}
	
	
	
	
	
	
	
	
	

}
