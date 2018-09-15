package ma.infosat.gestion.adherent.cotisation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.cotisation.entities.Don;
import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.entities.Espece;
import ma.infosat.gestion.adherent.cotisation.entities.Materiel;
import ma.infosat.gestion.adherent.cotisation.metier.DonMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class DonRestService {
	@Autowired
	private DonMetier donMetier;
	
	
	@GetMapping("/suivi/list/materiel/{id}")
	public List<Materiel> getListMaterielDonnateur(@PathVariable int id) {
		return donMetier.getListMaterielDonnateur(id);
	}


	@PutMapping("/unmark/don/{id}")
	public void unmarkDon(@PathVariable int id) {
		 donMetier.unmarkDon(id);
	}

   
	@GetMapping("/list/donnateurs")
	public List<Donneur> getListDonnateurSuivi() {
		return donMetier.getListDonnateurSuivi();
	}


	@GetMapping("/dons/materiel")
	public List<Materiel> listMateriel() {
		return donMetier.listMateriel();
	}
	
	@GetMapping("/dons/argent")
	public List<Espece> listArgent() {
		return donMetier.listArgent();
	}

	@RequestMapping(value="/dons/{id}",method=RequestMethod.GET)
	public Optional<Don> getDon(@PathVariable int id) {
		return donMetier.getDon(id);
	}
	
	@RequestMapping(value="/dons/{id}",method=RequestMethod.DELETE)
	public void deleteDon(@PathVariable int id) {
		donMetier.deleteDon(id);
	}
	
	
	@RequestMapping(value="/dons",method=RequestMethod.POST)
	public Don saveDon(@RequestBody Don don) {
		return donMetier.saveDon(don);
	}
	
    @RequestMapping(value="/dons",method=RequestMethod.GET)
	public List<Don> listDon() {
		return donMetier.listDon();
	}
    
	
    @RequestMapping(value="/dons",method=RequestMethod.PUT)
	public void updateDon(@RequestBody Don don) {
    	donMetier.updateDon(don);
	}
    
    @RequestMapping(value="/dons/count",method=RequestMethod.GET)
    public int countDon() {
    	return donMetier.countNumberDon();
    }
    
    @RequestMapping(value="/dons/materielSortant",method=RequestMethod.GET)
    public List<Materiel> listMaterielSortant() {
    	return donMetier.listMaterielSortant();
    }
}
