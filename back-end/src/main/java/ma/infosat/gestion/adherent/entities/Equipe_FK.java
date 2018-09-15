package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Equipe_FK  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="action_id")
	private Action action;
	@ManyToOne
	@JoinColumn(name="id_adherent")
	private Adherent adherent;
	public Equipe_FK(Action action, Adherent adherent) {
		super();
		this.action = action;
		this.adherent = adherent;
	}
	
	public Equipe_FK() {}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	
	

}
