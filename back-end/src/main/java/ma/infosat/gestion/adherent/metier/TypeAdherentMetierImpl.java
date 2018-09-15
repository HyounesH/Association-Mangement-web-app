package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.TypeAdherentRepository;
import ma.infosat.gestion.adherent.entities.TypeAdherent;

@Service
public class TypeAdherentMetierImpl implements TypeAdherentMetier {

	@Autowired
	private TypeAdherentRepository typeAdherentRepository;
	
	@Override
	public TypeAdherent saveTypeAdherent(TypeAdherent typeAdherent) {
		return typeAdherentRepository.save(typeAdherent);
	}

	@Override
	public List<TypeAdherent> listTypeAdherent() {
		return typeAdherentRepository.findAll();
	}

	@Override
	public void deleteTypeAdherent(Long id) {
		 typeAdherentRepository.deleteById(id);
		
	}

	@Override
	public void updateTypeAdherent(TypeAdherent typeAdherent) {
		typeAdherentRepository.save(typeAdherent);
		
	}

}
