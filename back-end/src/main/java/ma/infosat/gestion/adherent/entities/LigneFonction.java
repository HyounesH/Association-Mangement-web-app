package ma.infosat.gestion.adherent.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LigneFonction {

	@Id
	private LigneFontion_FK fk;
	
	private String type;
	private String  description;
	private String role;
	
	
	public LigneFonction(Adherent adherent,Fonction fonction , String type, String description,String role) {
		this.fk=new LigneFontion_FK(adherent,fonction);
		this.type=type;
		this.description=description;
		this.role=role;
	}
	public LigneFonction() {
		this.fk=new LigneFontion_FK();
	}
	public LigneFontion_FK getFk() {
		return fk;
	}
	public void setFk(LigneFontion_FK fk) {
		this.fk = fk;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
