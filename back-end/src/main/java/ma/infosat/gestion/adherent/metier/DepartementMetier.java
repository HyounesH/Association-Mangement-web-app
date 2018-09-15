package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Departement;

public interface DepartementMetier {
	public Departement saveDepartement(Departement departement);
	public List<Departement> listDepartement();
	public void deleteDepartement(Long id);
	public void updateDepartement(Departement departement);
}
