package ma.infosat.gestion.adherent.cotisation.entities;



import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("physiq")
public class PersonnePhysique extends Donneur  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cin;
	private String nom;
	private String prenom;
	public PersonnePhysique() {
		super();
	}
	
	public PersonnePhysique(String email, String telephone, String adresse, String ville,String password, String pays,String cin, String nom, String prenom) {
		super(email, telephone, adresse, ville, pays,password);
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
