package ma.infosat.gestion.adherent.tableSupplementaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.tableSupplementaire.entities.Liquide;
import ma.infosat.gestion.adherent.tableSupplementaire.metier.LiquideMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class LiquideRestService {
	@Autowired
	private LiquideMetier liquideMetier;

	@RequestMapping(value="/liquides",method=RequestMethod.POST)
	public Liquide saveLiquide( @RequestBody Liquide liquide) {
		return liquideMetier.saveLiquide(liquide);
	}

	@RequestMapping(value="/liquides",method=RequestMethod.GET)
	public List<Liquide> listLiquide() {
		return liquideMetier.listLiquide();
	}

	@RequestMapping(value="/liquides/{id}",method=RequestMethod.DELETE)
	public void deleteLiquide(@PathVariable int id) {
		liquideMetier.deleteLiquide(id);
	}

	@RequestMapping(value="/liquides",method=RequestMethod.PUT)
	public void updateLiquide(@RequestBody Liquide liquide) {
		liquideMetier.updateLiquide(liquide);
	}
	
	
}
