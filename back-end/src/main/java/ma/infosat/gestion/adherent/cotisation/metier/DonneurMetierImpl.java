package ma.infosat.gestion.adherent.cotisation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.cotisation.dao.DonneurRepository;
import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.entities.PersonneMorale;
import ma.infosat.gestion.adherent.cotisation.entities.PersonnePhysique;
@Service
public class DonneurMetierImpl implements DonneurMetier {
	@Autowired
	private DonneurRepository donneurRepository;
	@Override
	public Donneur saveDonneur(Donneur donneur) {
		return donneurRepository.save(donneur);
	}

	@Override
	public List<Donneur> listDonneur() {
		return donneurRepository.findAll();
	}

	@Override
	public void deleteDonneur(int id) {
		donneurRepository.deleteById(id);
		
	}

	@Override
	public void updateDonneur(Donneur donneur) {
		donneurRepository.save(donneur);
		
	}

	@Override
	public Donneur getDonneur(int id) {
		return donneurRepository.getDonnateurById(id);
	}

	@Override
	public String generatePassword(String key) {
		try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(key.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,2));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}

	@Override
	public List<Donneur> login(String email, String password) {
		return donneurRepository.login(email, password);
	}

	@Override
	public PersonneMorale getDonnateurMoral(int id) {
		return donneurRepository.getDonnateurMoral(id);
	}

	@Override
	public PersonnePhysique getDonnateurPhysique(int id) {
		return donneurRepository.getDonnateurPhysique(id);
	}


}
