package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.infosat.gestion.adherent.entities.Adherent;

public interface AdherentMetier {
	public Adherent saveAdherent(Adherent adherent);
	public List<Adherent> listAdherent();
	public void deleteAdherent(Long id);
	public void updateAdherent(Adherent adherent);
    public Page<Adherent> searchAdherents(String valeur,int page, int size);
    public List<Adherent> login(String email,String passwd);
    public int countNumberAdherent();
    public Adherent getAdherent(Long id);
    public List<Adherent> listMembres();
	

}
