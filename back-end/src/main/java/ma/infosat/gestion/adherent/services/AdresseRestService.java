package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Adresse;
import ma.infosat.gestion.adherent.metier.AdresseMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AdresseRestService {
	
	@Autowired
	private AdresseMetier adresseMetier;
	
	@GetMapping("/adresse/adherent/{id}")
	public Adresse getAdresseByAdherentId(@PathVariable Long id) {
		return adresseMetier.getAdresseByAdherentId(id);
	}


	@RequestMapping(value="/adresses/{id}",method=RequestMethod.DELETE)
	public void deleteAdresse(@PathVariable Long id) {
		adresseMetier.deleteAdresse(id);
	}
	
	
	@RequestMapping(value="/adresses",method=RequestMethod.POST)
	public Adresse saveAdresse(@RequestBody Adresse adresse) {
		return adresseMetier.saveAdresse(adresse);
	}
	
    @RequestMapping(value="/adresses",method=RequestMethod.GET)
	public List<Adresse> listAdresse() {
		return adresseMetier.listAdresse();
	}
	
    @RequestMapping(value="/adresses",method=RequestMethod.PUT)
	public void updateAdresse(@RequestBody Adresse adresse) {
    	adresseMetier.updateAdresse(adresse);
	}
	

}
