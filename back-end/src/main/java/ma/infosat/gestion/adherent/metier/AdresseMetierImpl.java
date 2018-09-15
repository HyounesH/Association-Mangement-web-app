package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.AdresseRepository;
import ma.infosat.gestion.adherent.entities.Adresse;

@Service
public class AdresseMetierImpl implements AdresseMetier {

	@Autowired
	private AdresseRepository adresseRepository;
	
	@Override
	public Adresse saveAdresse(Adresse adresse) {
		return adresseRepository.save(adresse);
	}

	@Override
	public List<Adresse> listAdresse() {
		return adresseRepository.findAll();
	}

	@Override
	public void deleteAdresse(Long id) {
		adresseRepository.deleteById(id);

	}

	@Override
	public void updateAdresse(Adresse adresse) {
		adresseRepository.save(adresse);

	}

	@Override
	public Adresse getAdresseByAdherentId(Long id) {
		return adresseRepository.getAdresseByAdherentId(id);
	}


}
