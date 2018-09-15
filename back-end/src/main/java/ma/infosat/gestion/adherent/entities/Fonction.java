package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fonction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fonction_id;
	private String fonction_nom;
	private String fonction_note;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	
	@OneToMany(mappedBy="fk.fonction")
	private Set<LigneFonction> lignesFonction =new HashSet<LigneFonction>();
	
	public Fonction(String fonction_nom, String fonction_note, LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.fonction_nom = fonction_nom;
		this.fonction_note = fonction_note;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Fonction() {}

	public String getFonction_nom() {
		return fonction_nom;
	}

	public void setFonction_nom(String fonction_nom) {
		this.fonction_nom = fonction_nom;
	}

	public String getFonction_note() {
		return fonction_note;
	}

	public void setFonction_note(String fonction_note) {
		this.fonction_note = fonction_note;
	}


	public Long getFonction_id() {
		return fonction_id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Set<LigneFonction> getLignesFonction() {
		return lignesFonction;
	}

	public void setLignesFonction(Set<LigneFonction> lignesFonction) {
		this.lignesFonction = lignesFonction;
	}
	
	
	
	

}
