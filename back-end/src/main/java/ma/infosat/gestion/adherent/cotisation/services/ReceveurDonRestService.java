package ma.infosat.gestion.adherent.cotisation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.cotisation.entities.ReceveurDon;
import ma.infosat.gestion.adherent.cotisation.metier.ReceveurDonMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ReceveurDonRestService {
	@Autowired
	private ReceveurDonMetier receveurDonMetier;
	
	@RequestMapping(value="/receveurDons/{id}",method=RequestMethod.DELETE)
	public void deleteReceveurDon(@PathVariable int id) {
		receveurDonMetier.deleteReceveurDon(id);
	}
	
	
	@RequestMapping(value="/receveurDons",method=RequestMethod.POST)
	public ReceveurDon saveReceveurDon(@RequestBody ReceveurDon receveurDon) {
		return receveurDonMetier.saveReceveurDon(receveurDon);
	}
	
    @RequestMapping(value="/receveurDons",method=RequestMethod.GET)
	public List<ReceveurDon> listDon() {
		return receveurDonMetier.listReceveurDon();
	}
	
    @RequestMapping(value="/receveurDons",method=RequestMethod.PUT)
	public void updateDon(@RequestBody ReceveurDon receveurDon) {
    	receveurDonMetier.updateReceveurDon(receveurDon);
	}
}
