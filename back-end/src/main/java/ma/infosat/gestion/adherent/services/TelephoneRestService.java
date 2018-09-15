package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Telephone;
import ma.infosat.gestion.adherent.metier.TelephoneMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RequestMapping("/assocSat")

public class TelephoneRestService {

	@Autowired
	private TelephoneMetier telephoneMetier;
	
	@RequestMapping(value="/telephones/{id}",method=RequestMethod.DELETE)
	public void deleteTelephone(@PathVariable Long id) {
		telephoneMetier.deleteTelephone(id);
	}
	
	
	@RequestMapping(value="/telephones",method=RequestMethod.POST)
	public Telephone saveTelephone(@RequestBody Telephone telephone) {
		return telephoneMetier.saveTelephone(telephone);
	}
	
    @RequestMapping(value="/telephones",method=RequestMethod.GET)
	public List<Telephone> listTelephone() {
		return telephoneMetier.listTelephone();
	}
	
    @RequestMapping(value="/telephones",method=RequestMethod.PUT)
	public void updateTelephone(@RequestBody Telephone telephone) {
    	telephoneMetier.updateTelephone(telephone);
	}
}
