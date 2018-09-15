package ma.infosat.gestion.adherent.cotisation.metier;

import java.util.List;

import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.entities.PersonneMorale;
import ma.infosat.gestion.adherent.cotisation.entities.PersonnePhysique;

public interface DonneurMetier {

	public Donneur saveDonneur(Donneur donneur);
	public List<Donneur> listDonneur();
	public void deleteDonneur(int id);
	public void updateDonneur(Donneur donneur);
	public Donneur getDonneur(int id);
	public String generatePassword(String key);
	public List<Donneur> login(String email, String password);
	public PersonneMorale getDonnateurMoral(int id);
	public PersonnePhysique getDonnateurPhysique(int id);

}
