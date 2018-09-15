package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.CommunauteRepository;
import ma.infosat.gestion.adherent.entities.Communaute;

@Service
public class CommunauteMetierImpl implements CommunauteMetier {

	@Autowired
    private CommunauteRepository communauteRepository ;
	
	
	@Override
	public Communaute saveCommunaute(Communaute communaute) {
		return communauteRepository.save(communaute);
	}

	@Override
	public List<Communaute> listCommunaute() {
		return communauteRepository.findAll();
	}

	@Override
	public void deleteCommunaute(Long id) {
		communauteRepository.deleteById(id);

	}

	@Override
	public void updateCommunaute(Communaute communaute) {
		communauteRepository.save(communaute);

	}

}
