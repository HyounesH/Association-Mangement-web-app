package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Adherent;
import ma.infosat.gestion.adherent.metier.AdherentMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AdherentRestService {
	
	@Autowired
	private AdherentMetier adherentMetier;
	
    @RequestMapping(value="/membres",method=RequestMethod.GET)
	public List<Adherent> listMembres() {
		return adherentMetier.listMembres();
	}


	@RequestMapping(value="/adherents/count",method=RequestMethod.GET)
	public int countNumberAdherent() {
		return adherentMetier.countNumberAdherent();
	}


    @RequestMapping(value="/adherents/{id}",method=RequestMethod.GET)
	public Adherent getAdherent(@PathVariable Long id) {
		return adherentMetier.getAdherent(id);
	}



	@RequestMapping(value="/login/{email}/{passwd}",method=RequestMethod.GET)
	public List<Adherent> login(@PathVariable String email, @PathVariable String passwd) {
		return adherentMetier.login(email, passwd);
	}



	@RequestMapping(value="/searchAdherent",method=RequestMethod.GET)
	public Page<Adherent> searchAdherents(@RequestParam(value="valeur",defaultValue="") String valeur,
			                              @RequestParam(value="page",defaultValue="0") int page,
			                              @RequestParam(value="size",defaultValue="5") int size) {
		return adherentMetier.searchAdherents(valeur, page, size);
	}



	@RequestMapping(value="/adherents/{id}",method=RequestMethod.DELETE)
	public void deleteAdherent(@PathVariable Long id) {
		adherentMetier.deleteAdherent(id);
	}
	
	
	
	@RequestMapping(value="/adherents",method=RequestMethod.POST)
	public Adherent saveAdherent(@RequestBody Adherent adherent) {
		return adherentMetier.saveAdherent(adherent);
	}
	
    @RequestMapping(value="/adherents",method=RequestMethod.GET)
	public List<Adherent> listAdherent() {
		return adherentMetier.listAdherent();
	}
	
    @RequestMapping(value="/adherents",method=RequestMethod.PUT)
	public void updateAdherent(@RequestBody Adherent adherent) {
		 adherentMetier.updateAdherent(adherent);
	}
    
   

}
