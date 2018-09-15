package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.FonctionRepository;
import ma.infosat.gestion.adherent.entities.Fonction;

@Service
public class FonctionMetierImpl implements FonctionMetier {

	@Autowired
	private FonctionRepository fonctionRepository;
	
	@Override
	public Fonction saveFonction(Fonction fonction) {
		return fonctionRepository.save(fonction);
	}

	@Override
	public List<Fonction> listFonction() {
		return fonctionRepository.findAll();
	}

	@Override
	public void deleteFonction(Long id) {
		fonctionRepository.deleteById(id);

	}

	@Override
	public void updateFonction(Fonction fonction) {
		fonctionRepository.save(fonction);

	}

}
