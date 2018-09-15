package ma.infosat.gestion.adherent.cotisation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cheq")
public class Cheque extends Don implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long num_compte_banque;
	private LocalDate date_cheque;
	private String nom_banque;

	public Cheque() {
		
	}
	
	

	public Cheque(long num_compte_banque, LocalDate date_cheque, String nom_banque) {
		super();
		this.num_compte_banque = num_compte_banque;
		this.date_cheque = date_cheque;
		this.nom_banque = nom_banque;
	}



	public Cheque(LocalDate date_don, String description_don, Donneur donneur, ReceveurDon receveur_don) {
		super(date_don, description_don, donneur, receveur_don);
		// TODO Auto-generated constructor stub
	}



	public Cheque(LocalDate date_don, String description_don) {
		super(date_don, description_don);
		// TODO Auto-generated constructor stub
	}



	public long getNum_compte_banque() {
		return num_compte_banque;
	}

	public void setNum_compte_banque(long num_compte_banque) {
		this.num_compte_banque = num_compte_banque;
	}

	public LocalDate getDate_cheque() {
		return date_cheque;
	}

	public void setDate_cheque(LocalDate date_cheque) {
		this.date_cheque = date_cheque;
	}


	public String getNom_banque() {
		return nom_banque;
	}

	public void setNom_banque(String nom_banque) {
		this.nom_banque = nom_banque;
	}

}
