package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Adherent;
import ma.infosat.gestion.adherent.entities.Profession;

public interface ProfessionMetier {

	public Profession saveProfession(Profession profession);
	public List<Profession> listProfession();
	public void deleteProfession(Long id);
	public void updateProfession(Profession profession);
	public void addAdherentProfession(Long profession_id,Adherent adherent);

}
