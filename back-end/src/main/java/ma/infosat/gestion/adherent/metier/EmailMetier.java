package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Email;

public interface EmailMetier {
	public Email saveEmail(Email email);
	public List<Email> listEmail();
	public void deleteEmail(Long id);
	public void updateEmail(Email email);

}
