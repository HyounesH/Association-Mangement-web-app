package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@Entity
public class Telephone  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_telephone;
	@Pattern(regexp="0[567]([.- ][0-9]{2}){4}")
	private String telephone;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="bureauVote_id")
	private BureauVote bureauVote;
	
	@ManyToOne
	@JoinColumn(name="id_structure")
	private Structure structure;
	
	public Telephone(String telephone, String type) {
		super();
		this.telephone = telephone;
		this.type = type;
	}
	
	public Telephone() {}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public BureauVote getBureauVote() {
		return bureauVote;
	}

	public void setBureauVote(BureauVote bureauVote) {
		this.bureauVote = bureauVote;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public Long getId_telephone() {
		return id_telephone;
	}
	
	
	
	

}
