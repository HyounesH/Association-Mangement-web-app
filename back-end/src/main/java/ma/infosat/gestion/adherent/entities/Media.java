package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Media  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long media_id;
	private String media_nom;
	private String media_file;
	private String media_note;
	private String media_type;
	private Date media_dateAjout;
	
	@ManyToOne
	@JoinColumn(name="action_id")
	private Action action;
	public Media(String media_nom, String media_file, String media_note, String media_type, Date media_dateAjout) {
		super();
		this.media_nom = media_nom;
		this.media_file = media_file;
		this.media_note = media_note;
		this.media_type = media_type;
		this.media_dateAjout = media_dateAjout;
	}
	
	public Media() {}

	public String getMedia_nom() {
		return media_nom;
	}

	public void setMedia_nom(String media_nom) {
		this.media_nom = media_nom;
	}

	public String getMedia_file() {
		return media_file;
	}

	public void setMedia_file(String media_file) {
		this.media_file = media_file;
	}

	public String getMedia_note() {
		return media_note;
	}

	public void setMedia_note(String media_note) {
		this.media_note = media_note;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public Date getMedia_dateAjout() {
		return media_dateAjout;
	}

	public void setMedia_dateAjout(Date media_dateAjout) {
		this.media_dateAjout = media_dateAjout;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Long getMedia_id() {
		return media_id;
	}
	
	
	
	
	

}
