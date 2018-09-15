package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.TelephoneRepository;
import ma.infosat.gestion.adherent.entities.Telephone;

@Service
public class TelephoneMetierImpl implements TelephoneMetier {

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	@Override
	public Telephone saveTelephone(Telephone telephone) {
		return telephoneRepository.save(telephone);
	}

	@Override
	public List<Telephone> listTelephone() {
		return telephoneRepository.findAll();
	}

	@Override
	public void deleteTelephone(Long id) {
		 telephoneRepository.deleteById(id);
		
	}

	@Override
	public void updateTelephone(Telephone telephone) {
		telephoneRepository.save(telephone);
		
	}

}