package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Adresse;

public interface AdresseMetier {
	public Adresse saveAdresse(Adresse adresse);
	public List<Adresse> listAdresse();
	public void deleteAdresse(Long id);
	public void updateAdresse(Adresse adresse);
	public Adresse getAdresseByAdherentId(Long id);
}
