package ma.infosat.gestion.adherent.cotisation.entities;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("espc")
public class Espece extends Don implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Espece() {}


	public Espece(LocalDate date_don, String description_don, Donneur donneur, ReceveurDon receveur_don) {
		super(date_don, description_don, donneur, receveur_don);
		// TODO Auto-generated constructor stub
	}


	public Espece(LocalDate date_don, String description_don) {
		super(date_don, description_don);
	}
    
	
	

	
	

}
