package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.EmailRepository;
import ma.infosat.gestion.adherent.entities.Email;

@Service
public class EmailMetierImpl implements EmailMetier {

	@Autowired
	private EmailRepository emailRepository;
	
	@Override
	public Email saveEmail(Email email) {
		return emailRepository.save(email);
	}

	@Override
	public List<Email> listEmail() {
		return emailRepository.findAll();
	}

	@Override
	public void deleteEmail(Long id) {
		emailRepository.deleteById(id);

	}

	@Override
	public void updateEmail(Email email) {
		emailRepository.save(email);

	}

}
