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
public class TypeAction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long typeAction_id;
	private String typeAction_nom;
	private String typeAction_note;
	
	@OneToMany(mappedBy="typeAction")
	private Set<Action> actions=new HashSet<Action>();
	
	public TypeAction(String typeAction_nom, String typeAction_note) {
		super();
		this.typeAction_nom = typeAction_nom;
		this.typeAction_note = typeAction_note;
	}
	public TypeAction() {}
	public String getTypeAction_nom() {
		return typeAction_nom;
	}
	public void setTypeAction_nom(String typeAction_nom) {
		this.typeAction_nom = typeAction_nom;
	}
	public String getTypeAction_note() {
		return typeAction_note;
	}
	public void setTypeAction_note(String typeAction_note) {
		this.typeAction_note = typeAction_note;
	}
	public Set<Action> getActions() {
		return actions;
	}
	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	public Long getTypeAction_id() {
		return typeAction_id;
	}
	
	
	

}
