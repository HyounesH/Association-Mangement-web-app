package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Equipe;
import ma.infosat.gestion.adherent.entities.Equipe_FK;

public interface EquipeMetier {

	public Equipe saveEquipe(Equipe equipe);
	public List<Equipe> listEquipe();
	public void deleteEquipe(Equipe_FK id);
	public void updateEquipe(Equipe equipe);

}
