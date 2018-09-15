package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Communaute implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long communaute_id;
	private String nom_communaute;
	
	@OneToMany(mappedBy="communaute",cascade=CascadeType.ALL)
	private Set<Adherent> adherents =new HashSet<Adherent>();
	public Communaute(Long communaute_id,String nom) {
		super();
		this.communaute_id=communaute_id;
		this.nom_communaute = nom;
	}
	
	public Communaute() {}

	public String getNom_communaute() {
		return nom_communaute;
	}

	public void setNom_communaute(String nom_communaute) {
		this.nom_communaute = nom_communaute;
  	}
    @JsonIgnore
	public Set<Adherent> getAdherents() {
		return adherents;
	}
    @JsonSetter
	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}

	public Long getCommunaute_id() {
		return communaute_id;
	}

	public void setCommunaute_id(Long communaute_id) {
		this.communaute_id = communaute_id;
	}
	
    
	
    
	

}
