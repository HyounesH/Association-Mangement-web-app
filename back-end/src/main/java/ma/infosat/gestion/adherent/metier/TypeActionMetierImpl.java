package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.TypeActionRepository;
import ma.infosat.gestion.adherent.entities.TypeAction;

@Service
public class TypeActionMetierImpl implements TypeActionMetier {

	@Autowired
	private TypeActionRepository typeActionRepository;
	
	@Override
	public TypeAction saveTypeAction(TypeAction typeAction) {
		return typeActionRepository.save(typeAction);
	}

	@Override
	public List<TypeAction> listTypeAction() {
		return typeActionRepository.findAll();
	}

	@Override
	public void deleteTypeAction(Long id) {
		 typeActionRepository.deleteById(id);
		
	}

	@Override
	public void updateTypeAction(TypeAction typeAction) {
		typeActionRepository.save(typeAction);
		
	}

}
