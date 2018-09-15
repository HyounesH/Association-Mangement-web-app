package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Situation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long situation_id;
	private String situation_nom;
	private String situation_couleur;
	private String situation_note;
	
	@OneToMany(mappedBy="situation")
	private Set<Action> actions=new HashSet<Action>();
	
	public Situation(String situation_nom, String situation_couleur, String situation_note) {
		super();
		this.situation_nom = situation_nom;
		this.situation_couleur = situation_couleur;
		this.situation_note = situation_note;
	}
	public Situation() {}
	public String getSituation_nom() {
		return situation_nom;
	}
	public void setSituation_nom(String situation_nom) {
		this.situation_nom = situation_nom;
	}
	public String getSituation_couleur() {
		return situation_couleur;
	}
	public void setSituation_couleur(String situation_couleur) {
		this.situation_couleur = situation_couleur;
	}
	public String getSituation_note() {
		return situation_note;
	}
	public void setSituation_note(String situation_note) {
		this.situation_note = situation_note;
	}
	public Set<Action> getActions() {
		return actions;
	}
	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	
	
	

}
