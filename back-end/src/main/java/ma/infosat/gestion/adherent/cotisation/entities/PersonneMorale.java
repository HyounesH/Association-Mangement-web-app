package ma.infosat.gestion.adherent.cotisation.entities;



import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("morale")
public class PersonneMorale extends Donneur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom_moral;
	
	public PersonneMorale() {
		super();
	}
	public PersonneMorale(String email, String telephone, String adresse, String ville, String pays,String password,String nom_moral) {
		super(email, telephone, adresse, ville, pays,password);
		this.nom_moral = nom_moral;
	}
	public String getNom_moral() {
		return nom_moral;
	}
	public void setNom_moral(String nom_moral) {
		this.nom_moral = nom_moral;
	}
	
	

}
