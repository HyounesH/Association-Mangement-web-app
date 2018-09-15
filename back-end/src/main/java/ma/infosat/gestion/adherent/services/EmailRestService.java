package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Email;
import ma.infosat.gestion.adherent.metier.EmailMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class EmailRestService {

	@Autowired
	private EmailMetier emailMetier;
	
	@RequestMapping(value="/emails/{id}",method=RequestMethod.DELETE)
	public void deleteEmail(@PathVariable Long id) {
		emailMetier.deleteEmail(id);
	}
	
	
	@RequestMapping(value="/emails",method=RequestMethod.POST)
	public Email saveEmail(@RequestBody Email email) {
		return emailMetier.saveEmail(email);
	}
	
    @RequestMapping(value="/emails",method=RequestMethod.GET)
	public List<Email> listEmail() {
		return emailMetier.listEmail();
	}
	
    @RequestMapping(value="/emails",method=RequestMethod.PUT)
	public void updateEmail(@RequestBody Email email) {
    	emailMetier.updateEmail(email);
	}
}
