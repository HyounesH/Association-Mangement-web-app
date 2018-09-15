package ma.infosat.gestion.adherent.cotisation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_don",discriminatorType=DiscriminatorType.STRING,length=4)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_don")
@JsonSubTypes({
	@Type(name="matr",value=Materiel.class),
	@Type(name="cheq",value=Cheque.class),
	@Type(name="espc",value=Espece.class),
	@Type(name="vers",value=Versement.class)
})
public abstract class Don implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	protected int id_don;
	protected LocalDate date_don;
	@Column(nullable=true,updatable=true)
	protected double montant;
 	protected String description_don;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_donneur")
	protected Donneur donneur;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_receveur_don")
	protected ReceveurDon receveur_don;
	
	public Don() { }
	
	public Don(LocalDate date_don, String description_don) {
		super();
		this.date_don = date_don;
		this.description_don = description_don;
	}
	

	public Don(LocalDate date_don, String description_don, Donneur donneur, ReceveurDon receveur_don) {
		super();
		this.date_don = date_don;
		this.description_don = description_don;
		this.donneur = donneur;
		this.receveur_don = receveur_don;
	}

	public ReceveurDon getReceveur_don() {
		return receveur_don;
	}

	public void setReceveur_don(ReceveurDon receveur_don) {
		this.receveur_don = receveur_don;
	}

	public LocalDate getDate_don() {
		return date_don;
	}
	public void setDate_don(LocalDate date_don) {
		this.date_don = date_don;
	}
	public String getDescription_don() {
		return description_don;
	}
	public void setDescription_don(String description_don) {
		this.description_don = description_don;
	}
	public int getId_don() {
		return id_don;
	}

	public Donneur getDonneur() {
		return donneur;
	}

	public void setDonneur(Donneur donneur) {
		this.donneur = donneur;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setId_don(int id_don) {
		this.id_don = id_don;
	}
	

}
