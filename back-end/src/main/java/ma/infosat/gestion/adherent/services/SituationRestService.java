package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Situation;
import ma.infosat.gestion.adherent.metier.SituationMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RequestMapping("/assocSat")
public class SituationRestService {

	@Autowired
	private SituationMetier situationMetier;
	
	@RequestMapping(value="/situations/{id}",method=RequestMethod.DELETE)
	public void deleteSituation(@PathVariable Long id) {
		situationMetier.deleteSituation(id);
	}
	
	
	@RequestMapping(value="/situations",method=RequestMethod.POST)
	public Situation saveSituation(@RequestBody Situation situation) {
		return situationMetier.saveSituation(situation);
	}
	
    @RequestMapping(value="/situations",method=RequestMethod.GET)
	public List<Situation> listSituation() {
		return situationMetier.listSituation();
	}
	
    @RequestMapping(value="/situations",method=RequestMethod.PUT)
	public void updateSituation(@RequestBody Situation situation) {
    	situationMetier.updateSituation(situation);
	}
}

