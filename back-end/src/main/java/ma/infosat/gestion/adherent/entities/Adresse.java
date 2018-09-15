package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Adresse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_adresse;
	private String quartier;
	private String ville;
	private int codePostal;
	private String pays;
	private String complAdresse;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_adhrenet")
	private Adherent adherent;
	
	
	public Adresse(String quartier, String ville, int codePostal,String pays,String complAdresse) {
		super();
		this.quartier = quartier;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays=pays;
		this.complAdresse=complAdresse;
	}
	
	public Adresse() {}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	@JsonIgnore
	public Adherent getAdherent() {
		return adherent;
	}
    @JsonSetter
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Long getId_adresse() {
		return id_adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getComplAdresse() {
		return complAdresse;
	}
    
	public void setComplAdresse(String complAdresse) {
		this.complAdresse = complAdresse;
	}

}
