package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.AdherentRepository;
import ma.infosat.gestion.adherent.entities.Adherent;

@Service
public class AdherentMetierImpl implements AdherentMetier{
	
	@Autowired
    private AdherentRepository adherentRepository;
	
	@Override
	public Adherent saveAdherent(Adherent adherent) {
		return adherentRepository.save(adherent);
	}

	@Override
	public List<Adherent> listAdherent() {
		return adherentRepository.findAll();
	}

	@Override
	public void deleteAdherent(Long id) {
		adherentRepository.deleteById(id);		
	}
	
	@Override
	public void updateAdherent(Adherent adherent) {
		adherentRepository.save(adherent);
	}

	@Override
	public Page<Adherent> searchAdherents(String valeur, int page, int size) {
		return adherentRepository.search("%"+valeur+"%", new PageRequest(page, size));
	}

	@Override
	public List<Adherent> login(String email, String passwd) {
		return adherentRepository.login(email, passwd);
	}

	@Override
	public int countNumberAdherent() {
		return adherentRepository.countAdherent();
	}

	@Override
	public Adherent getAdherent(Long id) {
		return adherentRepository.getAdherentById(id);
	}

	@Override
	public List<Adherent> listMembres() {
		return adherentRepository.getListMembres();
	}


}
