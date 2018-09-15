package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Action;

public interface ActionMetier {
	public Action saveAction(Action action);
	public List<Action> listAction();
	public void deleteAction(Long id);
	public void updateAction(Action action);
}
