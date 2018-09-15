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
public class BureauVote implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bureauVote_id;
	private  String nom_bureauVote;
	
	private String adresse;
	
	@OneToMany(mappedBy="bureauVote")
	private Set<Telephone> telephones=new HashSet<Telephone>();
	
	@OneToMany(mappedBy="bureauVote",cascade=CascadeType.ALL)
	private Set<Adherent> adherents =new HashSet<Adherent>();

	public BureauVote(String nom_bureauVote,String adresse) {
		super();
		this.nom_bureauVote = nom_bureauVote;
		this.adresse=adresse;
	}
	
	public BureauVote() {}

	public String getNom_bureauVote() {
		return nom_bureauVote;
	}

	public void setNom_bureauVote(String nom_bureauVote) {
		this.nom_bureauVote = nom_bureauVote;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
   @JsonIgnore
	public Set<Telephone> getTelephones() {
		return telephones;
	}
    @JsonSetter
	public void setTelephones(Set<Telephone> telephones) {
		this.telephones = telephones;
	}
    @JsonIgnore
	public Set<Adherent> getAdherents() {
		return adherents;
	}
    @JsonSetter
	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}

	public Long getBureauVote_id() {
		return bureauVote_id;
	}

}
