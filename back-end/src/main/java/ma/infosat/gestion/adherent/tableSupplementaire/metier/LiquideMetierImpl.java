package ma.infosat.gestion.adherent.tableSupplementaire.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.tableSupplementaire.dao.LiquideRepository;
import ma.infosat.gestion.adherent.tableSupplementaire.entities.Liquide;

@Service
public class LiquideMetierImpl implements LiquideMetier {

	@Autowired
	private LiquideRepository liquideRepository;
	
	@Override
	public Liquide saveLiquide(Liquide liquide) {
		return liquideRepository.save(liquide);
	}

	@Override
	public List<Liquide> listLiquide() {
		return liquideRepository.findAll();
	}

	@Override
	public void deleteLiquide(int id) {
		liquideRepository.deleteById(id);
	}

	@Override
	public void updateLiquide(Liquide liquide) {
		liquideRepository.save(liquide);
	}

	@Override
	public Optional<Liquide> getLiquide(int id) {
		return liquideRepository.findById(id);
	}

}
