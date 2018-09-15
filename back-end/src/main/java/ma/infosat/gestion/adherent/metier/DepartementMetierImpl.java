package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.DepartementRepository;
import ma.infosat.gestion.adherent.entities.Departement;

@Service
public class DepartementMetierImpl implements DepartementMetier {

	@Autowired
	private DepartementRepository departementRepository;
	
	@Override
	public Departement saveDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public List<Departement> listDepartement() {
		return departementRepository.findAll();
	}

	@Override
	public void deleteDepartement(Long id) {
		departementRepository.deleteById(id);

	}

	@Override
	public void updateDepartement(Departement departement) {
		departementRepository.save(departement);

	}

}
