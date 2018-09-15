package ma.infosat.gestion.adherent.cotisation.metier;

import java.util.List;
import java.util.Optional;

import ma.infosat.gestion.adherent.cotisation.entities.Don;
import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.entities.Espece;
import ma.infosat.gestion.adherent.cotisation.entities.Materiel;

public interface DonMetier {
	public Don saveDon(Don don);
	public List<Don> listDon();
	public void deleteDon(int id);
	public void updateDon(Don don);
	public Optional<Don> getDon(int id);
	
	public List<Materiel> listMateriel();
	public int countNumberDon();
	public List<Donneur> getListDonnateurSuivi();
	public  void unmarkDon(int id);
	
	public List<Espece> listArgent();
	public List<Materiel> listMaterielSortant();
	public List<Materiel> getListMaterielDonnateur(int id);

}
