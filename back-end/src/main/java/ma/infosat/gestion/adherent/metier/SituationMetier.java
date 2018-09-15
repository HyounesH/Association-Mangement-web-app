package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Situation;

public interface SituationMetier {
	public Situation saveSituation(Situation situation);
	public List<Situation> listSituation();
	public void deleteSituation(Long id);
	public void updateSituation(Situation situation);
}
