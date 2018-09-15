package ma.infosat.gestion.adherent.cotisation.metier;

import java.util.List;

import ma.infosat.gestion.adherent.cotisation.entities.ReceveurDon;

public interface ReceveurDonMetier {
	public ReceveurDon saveReceveurDon(ReceveurDon receveurDon);
	public List<ReceveurDon> listReceveurDon();
	public void deleteReceveurDon(int id);
	public void updateReceveurDon(ReceveurDon receveurDon);
}
