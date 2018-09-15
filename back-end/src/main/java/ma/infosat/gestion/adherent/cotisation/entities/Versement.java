package ma.infosat.gestion.adherent.cotisation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vers")
public class Versement extends Don implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long num_compte_banque;

	
	public Versement() {}
	
	

	public Versement(long num_compte_banque) {
		super();
		this.num_compte_banque = num_compte_banque;
	}
	



	public Versement(LocalDate date_don, String description_don, Donneur donneur, ReceveurDon receveur_don) {
		super(date_don, description_don, donneur, receveur_don);
		// TODO Auto-generated constructor stub
	}



	public Versement(LocalDate date_don, String description_don) {
		super(date_don, description_don);
		// TODO Auto-generated constructor stub
	}



	public long getNum_compte_banque() {
		return num_compte_banque;
	}

	public void setNum_compte_banque(long num_compte_banque) {
		this.num_compte_banque = num_compte_banque;
	}

}
