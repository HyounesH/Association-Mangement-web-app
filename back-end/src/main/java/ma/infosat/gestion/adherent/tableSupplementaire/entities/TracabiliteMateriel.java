package ma.infosat.gestion.adherent.tableSupplementaire.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ma.infosat.gestion.adherent.cotisation.entities.Materiel;

@Entity
public class TracabiliteMateriel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTracabilite;
	private  String date_envoi;
	private String description;
	private String lieu_envoi;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_don")
	private Materiel materiel;

	public TracabiliteMateriel(String date_envoi, String description, String lieu_envoi) {
		super();
		this.date_envoi = date_envoi;
		this.description = description;
		this.lieu_envoi = lieu_envoi;
	}
	public TracabiliteMateriel() {}
	public int getIdTracabilite() {
		return idTracabilite;
	}
	public void setIdTracabilite(int idTracabilite) {
		this.idTracabilite = idTracabilite;
	}
	public String getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(String date_envoi) {
		this.date_envoi = date_envoi;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu_envoi() {
		return lieu_envoi;
	}
	public void setLieu_envoi(String lieu_envoi) {
		this.lieu_envoi = lieu_envoi;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	
	
	
	
	
	
	
}
