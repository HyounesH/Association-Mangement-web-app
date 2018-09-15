package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.StructureRepository;
import ma.infosat.gestion.adherent.entities.Structure;


@Service
public class StructureDaoImpl implements StructureMetier {
	
	@Autowired
	private StructureRepository structureRepository;

	@Override
	public Structure saveStructure(Structure structure) {

		return structureRepository.save(structure);
	}

	@Override
	public List<Structure> listStructure() {
		// TODO Auto-generated method stub
		return structureRepository.findAll();
	}

	@Override
	public Structure updateStructure(Structure structure) {
		return  structureRepository.save(structure);
	}

	@Override
	public Structure getStructure(Long id) {
		return structureRepository.getOne(id);
	}

	@Override
	public boolean DeleteStructure(Long id) {
		if( ! structureRepository.existsById(id)) {
			return false ;
		}
		else {
		structureRepository.delete(structureRepository.getOne(id));
		return true;
		}
	}

}
