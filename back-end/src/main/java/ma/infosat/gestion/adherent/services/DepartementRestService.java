package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Departement;
import ma.infosat.gestion.adherent.metier.DepartementMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class DepartementRestService {

	@Autowired
	private DepartementMetier departementMetier;
	
	@RequestMapping(value="/departements/{id}",method=RequestMethod.DELETE)
	public void deleteDepartement(@PathVariable Long id) {
		departementMetier.deleteDepartement(id);
	}
	
	
	@RequestMapping(value="/departements",method=RequestMethod.POST)
	public Departement saveDepartement(@RequestBody Departement departement) {
		return departementMetier.saveDepartement(departement);
	}
	
    @RequestMapping(value="/departements",method=RequestMethod.GET)
	public List<Departement> listDepartement() {
		return departementMetier.listDepartement();
	}
	
    @RequestMapping(value="/departements",method=RequestMethod.PUT)
	public void updateDepartement(@RequestBody Departement departement) {
    	departementMetier.updateDepartement(departement);
	}
}
