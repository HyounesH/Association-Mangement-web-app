package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Communaute;

public interface CommunauteMetier {
	public Communaute saveCommunaute(Communaute communaute);
	public List<Communaute> listCommunaute();
	public void deleteCommunaute(Long id);
	public void updateCommunaute(Communaute communaute);
}
