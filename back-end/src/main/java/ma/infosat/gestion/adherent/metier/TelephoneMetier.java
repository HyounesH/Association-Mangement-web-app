package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Telephone;

public interface TelephoneMetier {
	public Telephone saveTelephone(Telephone telephone);
	public List<Telephone> listTelephone();
	public void deleteTelephone(Long id);
	public void updateTelephone(Telephone telephone);
}

