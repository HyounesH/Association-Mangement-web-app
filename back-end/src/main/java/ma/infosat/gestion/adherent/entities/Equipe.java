package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Equipe_FK fk;
	private String role;
	private String description;
	private Date dateAffectation;
	public Equipe(Action action,Adherent adherent, String role, String description, Date dateAffectation) {
		super();
		this.fk = new Equipe_FK(action,adherent);
		this.role = role;
		this.description = description;
		this.dateAffectation = dateAffectation;
	}
	public Equipe() {
		this.fk=new Equipe_FK();
	}
	public Equipe_FK getFk() {
		return fk;
	}
	public void setFk(Equipe_FK fk) {
		this.fk = fk;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	
	

	
}
