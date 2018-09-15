package ma.infosat.gestion.adherent.cotisation.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import ma.infosat.gestion.adherent.tableSupplementaire.entities.TracabiliteMateriel;
@Entity
@DiscriminatorValue("matr")
public class Materiel extends Don  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String etat;
	private LocalDate dateSortie;
	private String lieuSortie;
	private boolean suivi;

	@OneToMany(mappedBy="materiel",cascade=CascadeType.ALL)
	protected Set<TracabiliteMateriel> tracabiliteMateriel=new HashSet<TracabiliteMateriel>();
	
	
	
	public Materiel(String etat, LocalDate dateSortie, String lieuSortie, boolean suivi) {
		super();
		this.etat = etat;
		this.dateSortie = dateSortie;
		this.lieuSortie = lieuSortie;
		this.suivi = true;
	}
	
	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Materiel(LocalDate date_don, String description_don, Donneur donneur, ReceveurDon receveur_don) {
		super(date_don, description_don, donneur, receveur_don);
		// TODO Auto-generated constructor stub
	}



	public Materiel(LocalDate date_don, String description_don) {
		super(date_don, description_don);
		// TODO Auto-generated constructor stub
	}



	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getLieuSortie() {
		return lieuSortie;
	}
	public void setLieuSortie(String lieuSortie) {
		this.lieuSortie = lieuSortie;
	}
	public boolean isSuivi() {
		return suivi;
	}
	public void setSuivi(boolean suivi) {
		this.suivi = suivi;
	}
	@JsonIgnore
	public Set<TracabiliteMateriel> getTracabiliteMateriel() {
		return tracabiliteMateriel;
	}
	@JsonSetter
	public void setTracabiliteMateriel(Set<TracabiliteMateriel> tracabiliteMateriel) {
		this.tracabiliteMateriel = tracabiliteMateriel;
	}
	
	
	
}
