package ma.infosat.gestion.adherent.cotisation.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ReceveurDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_receveur_don;
	private long code_employe;
	@OneToMany(mappedBy="receveur_don",cascade=CascadeType.ALL)
	private Set<Don> dons = new HashSet<Don>();
	public ReceveurDon() {}
	public ReceveurDon(long code_employe) {
		super();
		this.code_employe = code_employe;
	}
	public int getId_receveur_don() {
		return id_receveur_don;
	}
	public long getCode_employe() {
		return code_employe;
	}
	public void setCode_employe(long code_employe) {
		this.code_employe = code_employe;
	}
	@JsonIgnore
	public Set<Don> getDons() {
		return dons;
	}
	@JsonIgnore
	public void setDons(Set<Don> dons) {
		this.dons = dons;
	}
	public void setId_receveur_don(int id_receveur_don) {
		this.id_receveur_don = id_receveur_don;
	}
	

	

}
