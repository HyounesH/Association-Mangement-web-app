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
public class Profession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long profession_id;
	private String profession_nom;
	private String profession_note;
	@OneToMany(mappedBy="profession",cascade=CascadeType.ALL)
	private Set<Adherent> adherents = new HashSet<Adherent>();
	public Profession(String prefession_nom, String profession_note) {
		super();
		this.profession_nom = prefession_nom;
		this.profession_note = profession_note;
	}
	
	
	public Profession() {}


	public String getPrefession_nom() {
		return profession_nom;
	}


	public void setPrefession_nom(String prefession_nom) {
		this.profession_nom = prefession_nom;
	}


	public String getProfession_note() {
		return profession_note;
	}


	public void setProfession_note(String profession_note) {
		this.profession_note = profession_note;
	}

    @JsonIgnore
	public Set<Adherent> getAdherents() {
		return adherents;
	}

    @JsonSetter
	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}


	public Long getProfession_id() {
		return profession_id;
	}
	
	

}
