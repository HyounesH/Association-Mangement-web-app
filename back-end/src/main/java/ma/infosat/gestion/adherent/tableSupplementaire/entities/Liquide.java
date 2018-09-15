package ma.infosat.gestion.adherent.tableSupplementaire.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Liquide implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_liquide;
	private long code_employe;
	private double montant;
	private LocalDate date_depense;
	private String type_depense;
	public Liquide() {}
	public Liquide(double montant, LocalDate date_depense, String type_depense) {
		super();
		this.montant = montant;
		this.date_depense = date_depense;
		this.type_depense = type_depense;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public LocalDate getDate_depense() {
		return date_depense;
	}
	public void setDate_depense(LocalDate date_depense) {
		this.date_depense = date_depense;
	}
	public String getType_depense() {
		return type_depense;
	}
	public void setType_depense(String type_depense) {
		this.type_depense = type_depense;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId_liquide() {
		return id_liquide;
	}
	public long getCode_employe() {
		return code_employe;
	}
	public void setCode_employe(long code_employe) {
		this.code_employe = code_employe;
	}
	public void setId_liquide(int id_liquide) {
		this.id_liquide = id_liquide;
	}
	
	
	
	

	
}
