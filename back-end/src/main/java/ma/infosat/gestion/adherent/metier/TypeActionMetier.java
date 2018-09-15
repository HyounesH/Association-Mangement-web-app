package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.TypeAction;

public interface TypeActionMetier {
	public TypeAction saveTypeAction(TypeAction typeAction);
	public List<TypeAction> listTypeAction();
	public void deleteTypeAction(Long id);
	public void updateTypeAction(TypeAction typeAction);

}
