package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.ProfessionRepository;
import ma.infosat.gestion.adherent.entities.Adherent;
import ma.infosat.gestion.adherent.entities.Profession;

@Service
public class ProfessionMetierImpl implements ProfessionMetier {

	@Autowired
	private ProfessionRepository professionRepository;
	
	@Override
	public Profession saveProfession(Profession profession) {
		return professionRepository.save(profession);
	}

	@Override
	public List<Profession> listProfession() {
		return professionRepository.findAll();
	}

	@Override
	public void deleteProfession(Long id) {
		professionRepository.deleteById(id);

	}

	@Override
	public void updateProfession(Profession profession) {
		professionRepository.save(profession);

	}

	@Override
	public void addAdherentProfession(Long profession_id,Adherent adherent) {
		Profession p= professionRepository.getOne(profession_id);
		p.getAdherents().add(adherent);
		professionRepository.save(p);
	}

}
