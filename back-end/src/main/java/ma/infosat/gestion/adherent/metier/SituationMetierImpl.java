package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.SituationRepository;
import ma.infosat.gestion.adherent.entities.Situation;

@Service
public class SituationMetierImpl implements SituationMetier {

	@Autowired
	private SituationRepository situationRepository;
	
	@Override
	public Situation saveSituation(Situation situation) {
		return situationRepository.save(situation);
	}

	@Override
	public List<Situation> listSituation() {
		return situationRepository.findAll();
	}

	@Override
	public void deleteSituation(Long id) {
		 situationRepository.deleteById(id);
		
	}

	@Override
	public void updateSituation(Situation situation) {
		situationRepository.save(situation);
		
	}

}