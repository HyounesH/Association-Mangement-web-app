package ma.infosat.gestion.adherent.tableSupplementaire.metier;

import java.util.List;
import java.util.Optional;

import ma.infosat.gestion.adherent.tableSupplementaire.entities.Liquide;

public interface LiquideMetier {
	
	public Liquide saveLiquide(Liquide liquide);
	public List<Liquide> listLiquide();
	public void deleteLiquide(int id);
	public void updateLiquide(Liquide liquide);
	public Optional<Liquide> getLiquide(int id);

}
