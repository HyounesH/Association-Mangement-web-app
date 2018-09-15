package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneFontion_FK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="id_adherent")
	private Adherent adherent;
	@ManyToOne
	@JoinColumn(name="fonction_id")
	private Fonction fonction;
	public LigneFontion_FK(Adherent adherent, Fonction fonction) {
		super();
		this.adherent = adherent;
		this.fonction = fonction;
	}
	public LigneFontion_FK() {
		super();
		this.fonction=new Fonction();
		this.adherent=new Adherent();
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public Fonction getFonction() {
		return fonction;
	}
	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}
	
	
	

}
