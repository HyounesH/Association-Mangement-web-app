package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.EquipeRepository;
import ma.infosat.gestion.adherent.entities.Equipe;
import ma.infosat.gestion.adherent.entities.Equipe_FK;

@Service
public class EquipeMetierImpl implements EquipeMetier {

	@Autowired
	private EquipeRepository equipeRepository;
	
	@Override
	public Equipe saveEquipe(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@Override
	public List<Equipe> listEquipe() {
		return equipeRepository.findAll();
	}

	@Override
	public void deleteEquipe(Equipe_FK id) {
		equipeRepository.deleteById(id);

	}

	@Override
	public void updateEquipe(Equipe equipe) {
		equipeRepository.save(equipe);

	}

}
