package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Fonction;
import ma.infosat.gestion.adherent.metier.FonctionMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")

public class FonctionRestService {

	@Autowired
	private FonctionMetier fonctionMetier;
	
	@RequestMapping(value="/fonctions/{id}",method=RequestMethod.DELETE)
	public void deleteFonction(@PathVariable Long id) {
		fonctionMetier.deleteFonction(id);
	}
	
	
	@RequestMapping(value="/fonctions",method=RequestMethod.POST)
	public Fonction saveFonction(@RequestBody Fonction fonction) {
		return fonctionMetier.saveFonction(fonction);
	}
	
    @RequestMapping(value="/fonctions",method=RequestMethod.GET)
	public List<Fonction> listFonction() {
		return fonctionMetier.listFonction();
	}
	
    @RequestMapping(value="/fonctions",method=RequestMethod.PUT)
	public void updateFonction(@RequestBody Fonction fonction) {
    	fonctionMetier.updateFonction(fonction);
	}
	
}
