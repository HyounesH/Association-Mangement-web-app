package ma.infosat.gestion.adherent.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Adherent implements Serializable{
	/**
	 * 	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_adherent;
	private String nom_adherent;
	private String prenom_adherent;
	private String cin;
	private LocalDate dateDeNaissance;
	private String lieuDeNaissance;
	private LocalDate dateAdhesion;
	private String numeroVote;
	private String photo;
	private String motPasse;
	private String sexe;
	private String telephone;
	private String email;
	private String role;
	@OneToMany(mappedBy="adherent",cascade=CascadeType.ALL)
	private Set<Adresse> adresses=new HashSet<Adresse>();
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="communaute_id")
	private Communaute communaute;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="bureauVote_id")
	private BureauVote bureauVote;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_service")
	private Service service;
	
	@OneToMany(mappedBy="fk.adherent",cascade=CascadeType.ALL)
	private Set<Equipe> equipes=new HashSet<Equipe>();
	
	@ManyToMany(mappedBy="adherents")
	private Set<TypeAdherent> typeAdherents =new HashSet<TypeAdherent>();
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="prefession_id")
	private Profession profession;
	
	@OneToMany(mappedBy="fk.adherent")
	private Set<LigneFonction> lignesFonction =new HashSet<LigneFonction>();
	public Adherent(String nom_adherent, String prenom_adherent, String cIN, LocalDate dateDeNaissance,
			String lieuDeNaissance,String numeroVote, String photo,String email,String telephone,String sexe,String role) {
		super();
		this.nom_adherent = nom_adherent;
		this.prenom_adherent = prenom_adherent;
		this.cin = cIN;
		this.dateDeNaissance = dateDeNaissance;
		this.lieuDeNaissance = lieuDeNaissance;
		this.dateAdhesion =LocalDate.now();
		this.numeroVote = numeroVote;
		this.email=email;
		this.telephone=telephone;
		this.photo = photo;
		this.sexe=sexe;
		this.role=role;
	}
	
	public Adherent() {
		this.dateAdhesion=LocalDate.now();
	}

	public String getNom_adherent() {
		return nom_adherent;
	}

	public void setNom_adherent(String nom_adherent) {
		this.nom_adherent = nom_adherent;
	}

	public String getPrenom_adherent() {
		return prenom_adherent;
	}

	public void setPrenom_adherent(String prenom_adherent) {
		this.prenom_adherent = prenom_adherent;
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	public LocalDate getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(LocalDate dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public String getNumeroVote() {
		return numeroVote;
	}

	public void setNumeroVote(String numeroVote) {
		this.numeroVote = numeroVote;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Adresse> getAdresses() {
		return adresses;
	}
   @JsonSetter
	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}
	public Service getService() {
		return service;
	}
    @JsonSetter
	public void setService(Service service) {
		this.service = service;
	}
	@JsonIgnore
	public Set<Equipe> getEquipes() {
		return equipes;
	}
    @JsonSetter
	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}
	public Communaute getCommunaute() {
		return communaute;
	}
    @JsonSetter
	public void setCommunaute(Communaute communaute) {
		this.communaute = communaute;
	}
	public BureauVote getBureauVote() {
		return bureauVote;
	}
    @JsonSetter
	public void setBureauVote(BureauVote bureauVote) {
		this.bureauVote = bureauVote;
	}
	public Profession getProfession() {
		return profession;
	}
    @JsonSetter
	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public Long getId_adherent() {
		return id_adherent;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Set<TypeAdherent> getTypeAdherents() {
		return typeAdherents;
	}

	public void setTypeAdherents(Set<TypeAdherent> typeAdherents) {
		this.typeAdherents = typeAdherents;
	}

	public Set<LigneFonction> getLignesFonction() {
		return lignesFonction;
	}

	public void setLignesFonction(Set<LigneFonction> lignesFonction) {
		this.lignesFonction = lignesFonction;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId_adherent(Long id_adherent) {
		this.id_adherent = id_adherent;
	}
	
	
	
	
	
	
}
