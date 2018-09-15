package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public  class TypeAdherent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long typeAdherent_id;
	private String typeAdherent_nom;
	private String typeAdherent_note;
	
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="typeAdherent_id"),inverseJoinColumns=@JoinColumn(name="id_adherent"))
    private Set<Adherent> adherents=new HashSet<Adherent>();
	public TypeAdherent(String typeAdherent_nom, String typeAdherent_note) {
		super();
		this.typeAdherent_nom = typeAdherent_nom;
		this.typeAdherent_note = typeAdherent_note;
	}
	
	public TypeAdherent() {}

	public String getTypeAdherent_nom() {
		return typeAdherent_nom;
	}

	public void setTypeAdherent_nom(String typeAdherent_nom) {
		this.typeAdherent_nom = typeAdherent_nom;
	}

	public String getTypeAdherent_note() {
		return typeAdherent_note;
	}

	public void setTypeAdherent_note(String typeAdherent_note) {
		this.typeAdherent_note = typeAdherent_note;
	}

	public Set<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(Set<Adherent> adherents) {
		this.adherents = adherents;
	}

	public Long getTypeAdherent_id() {
		return typeAdherent_id;
	}
	
	
	
	

}
