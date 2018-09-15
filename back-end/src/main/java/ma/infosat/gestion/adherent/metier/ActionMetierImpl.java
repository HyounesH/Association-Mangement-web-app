package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.ActionRepository;
import ma.infosat.gestion.adherent.entities.Action;

@Service
public class ActionMetierImpl implements ActionMetier {

	@Autowired
	private ActionRepository actionRepository;
	
	@Override
	public Action saveAction(Action action) {
		return actionRepository.save(action);
	}

	@Override
	public List<Action> listAction() {
		return actionRepository.findAll();
	}

	@Override
	public void deleteAction(Long id) {
		 actionRepository.deleteById(id);
		
	}

	@Override
	public void updateAction(Action action) {
		actionRepository.save(action);
		
	}

}
