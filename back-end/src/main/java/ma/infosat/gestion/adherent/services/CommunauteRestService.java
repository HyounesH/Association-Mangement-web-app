package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Communaute;
import ma.infosat.gestion.adherent.metier.CommunauteMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class CommunauteRestService {

	@Autowired
	private CommunauteMetier communauteMetier;
	
	@RequestMapping(value="/communautes/{id}",method=RequestMethod.DELETE)
	public void deleteCommunaute(@PathVariable Long id) {
		communauteMetier.deleteCommunaute(id);
	}
	

	@RequestMapping(value="/communautes",method=RequestMethod.POST)
	public Communaute saveCommunaute(@RequestBody Communaute communaute) {
		return communauteMetier.saveCommunaute(communaute);
	}
	
    @RequestMapping(value="/communautes",method=RequestMethod.GET)
	public List<Communaute> listCommunaute() {
		return communauteMetier.listCommunaute();
	}
	
    @RequestMapping(value="/communautes",method=RequestMethod.PUT)
	public void updateCommunaute(@RequestBody Communaute communaute) {
    	communauteMetier.updateCommunaute(communaute);
	}
	
}
