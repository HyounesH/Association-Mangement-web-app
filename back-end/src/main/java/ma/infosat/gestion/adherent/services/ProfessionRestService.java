package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Adherent;
import ma.infosat.gestion.adherent.entities.Profession;
import ma.infosat.gestion.adherent.metier.ProfessionMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")

public class ProfessionRestService {
	
	@Autowired
	private ProfessionMetier ProfessionMetier;
	@RequestMapping(value="/professions/{id}",method=RequestMethod.PUT)
	public void addAdherentProfession(@PathVariable Long profession_id, @RequestBody Adherent adherent) {
		ProfessionMetier.addAdherentProfession(profession_id, adherent);
	}

	@RequestMapping(value="/professions/{id}",method=RequestMethod.DELETE)
	public void deleteProfession(@PathVariable Long id) {
		ProfessionMetier.deleteProfession(id);
	}
	
	@RequestMapping(value="/professions",method=RequestMethod.POST)
	public Profession saveProfession(@RequestBody Profession profession) {
		Profession p=new Profession(profession.getPrefession_nom(), profession.getProfession_note());
		return ProfessionMetier.saveProfession(p);
	}
	
    @RequestMapping(value="/professions",method=RequestMethod.GET)
	public List<Profession> listProfession() {
		return ProfessionMetier.listProfession();
	}
	
    @RequestMapping(value="/professions",method=RequestMethod.PUT)
	public void updateProfession(@RequestBody Profession profession) {
    	ProfessionMetier.updateProfession(profession);
	}
}
