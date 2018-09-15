package ma.infosat.gestion.adherent.cotisation.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_donneur",discriminatorType=DiscriminatorType.STRING,length=6)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_donneur")
@JsonSubTypes({
	@Type(name="morale",value=PersonneMorale.class),
	@Type(name="physiq",value=PersonnePhysique.class)
})
public abstract class Donneur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id_donneur;
	protected String email;
	protected String telephone;
	protected String adresse;
	protected String ville;
	protected String pays;
	protected String password;
	protected String role;
	protected boolean suivi;
	@OneToMany(mappedBy="donneur",cascade=CascadeType.ALL)
	protected Set<Don> dons = new HashSet<Don>();
	public Donneur() { }
	public Donneur(String email, String telephone, String adresse, String ville, String pays,String password) {
		super();
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.password=password;
		this.suivi=true;
	}
	public int getId_donneur() {
		return id_donneur;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@JsonIgnore
	public Set<Don> getDons() {
		return dons;
	}
	@JsonSetter
	public void setDons(Set<Don> dons) {
		this.dons = dons;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId_donneur(int id_donneur) {
		this.id_donneur = id_donneur;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isSuivi() {
		return suivi;
	}
	public void setSuivi(boolean suivi) {
		this.suivi = suivi;
	}
	
	
	
	

}
