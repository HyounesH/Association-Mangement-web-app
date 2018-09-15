package ma.infosat.gestion.adherent.cotisation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.cotisation.dao.ReceveurDonRepository;
import ma.infosat.gestion.adherent.cotisation.entities.ReceveurDon;
@Service
public class ReceveurDonMetierImpl implements ReceveurDonMetier {
	@Autowired
	private ReceveurDonRepository receveurDonRepository;
	@Override
	public ReceveurDon saveReceveurDon(ReceveurDon receveurDon) {
		return receveurDonRepository.save(receveurDon);
	}

	@Override
	public List<ReceveurDon> listReceveurDon() {
		return receveurDonRepository.findAll();
	}

	@Override
	public void deleteReceveurDon(int id) {
		receveurDonRepository.deleteById(id);

	}

	@Override
	public void updateReceveurDon(ReceveurDon receveurDon) {
		receveurDonRepository.save(receveurDon);

	}

}
