package ma.infosat.gestion.adherent.cotisation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.metier.DonneurMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class DonneurRestService {
	@Autowired
	private DonneurMetier donneurMetier;
	
	
	
	@GetMapping("/donnateur/login/{email}/{password}")
	public List<Donneur> login(@PathVariable String email, @PathVariable String password) {
		return donneurMetier.login(email, password);
	}

	@RequestMapping(value="/donneurs/password/generate/{key}",method=RequestMethod.GET)
	public String generatePassword(@PathVariable String key) {
		return donneurMetier.generatePassword(key);
	}

	@RequestMapping(value="/donneurs/{id}",method=RequestMethod.GET)
	public Donneur getDonneur(@PathVariable int id) {
		return donneurMetier.getDonneur(id);
	}

	@RequestMapping(value="/donneurs/{id}",method=RequestMethod.DELETE)
	public void deleteDonneur(@PathVariable int id) {
		donneurMetier.deleteDonneur(id);
	}
	
	@RequestMapping(value="/donneurs",method=RequestMethod.POST)
	public Donneur saveDonneur(@RequestBody Donneur donneur) {
		return donneurMetier.saveDonneur(donneur);
	}
	
    @RequestMapping(value="/donneurs",method=RequestMethod.GET)
	public List<Donneur> listDonneur() {
		return donneurMetier.listDonneur();
	}
	
    @RequestMapping(value="/donneurs",method=RequestMethod.PUT)
	public void updateDonneur(@RequestBody Donneur donneur) {
    	donneurMetier.updateDonneur(donneur);
	}
}
