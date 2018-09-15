package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Fonction;

public interface FonctionMetier {

	public Fonction saveFonction(Fonction fonction);
	public List<Fonction> listFonction();
	public void deleteFonction(Long id);
	public void updateFonction(Fonction fonction);

}
