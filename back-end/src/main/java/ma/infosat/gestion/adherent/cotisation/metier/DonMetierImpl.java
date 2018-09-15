package ma.infosat.gestion.adherent.cotisation.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.cotisation.dao.DonRepository;
import ma.infosat.gestion.adherent.cotisation.entities.Don;
import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.entities.Espece;
import ma.infosat.gestion.adherent.cotisation.entities.Materiel;
@Service
public class DonMetierImpl implements DonMetier {
	@Autowired
	private DonRepository donRepository;
	@Override
	public Don saveDon(Don don) {
		return donRepository.save(don);
	}

	@Override
	public List<Don> listDon() {
		return donRepository.findAll();
	}

	@Override
	public void deleteDon(int id) {
		 donRepository.deleteById(id);

	}

	@Override
	public void updateDon(Don don) {
		donRepository.save(don);

	}

	@Override
	public List<Materiel> listMateriel() {
	 return donRepository.listMateriel();
	}

	
	@Override
	public int countNumberDon() {
		return donRepository.countDon();
	}

	@Override
	public List<Donneur> getListDonnateurSuivi() {
	 return donRepository.getListDonnateurSuivi();
	}

	@Override
	public void unmarkDon(int id) {
      donRepository.unMarkDon(id);		
	}

	@Override
	public Optional<Don> getDon(int id) {
		return donRepository.findById(id);
	}

	@Override
	public List<Espece> listArgent() {
		return donRepository.listArgent();
	}

	@Override
	public List<Materiel> listMaterielSortant() {
		return donRepository.listMaterielSortant();
	}

	@Override
	public List<Materiel> getListMaterielDonnateur(int id) {
		return donRepository.getListMaterielDonnateur(id);
	}

}
