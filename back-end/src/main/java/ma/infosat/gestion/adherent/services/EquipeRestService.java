package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Equipe;
import ma.infosat.gestion.adherent.entities.Equipe_FK;
import ma.infosat.gestion.adherent.metier.EquipeMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class EquipeRestService {

	@Autowired
	private EquipeMetier equipeMetier;
	
	@RequestMapping(value="/equipes/{id}",method=RequestMethod.DELETE)
	public void deleteEquipe(@PathVariable Equipe_FK id) {
		equipeMetier.deleteEquipe(id);
	}
	
	
	@RequestMapping(value="/equipes",method=RequestMethod.POST)
	public Equipe saveEquipe(@RequestBody Equipe equipe) {
		return equipeMetier.saveEquipe(equipe);
	}
	
    @RequestMapping(value="/equipes",method=RequestMethod.GET)
	public List<Equipe> listEquipe() {
		return equipeMetier.listEquipe();
	}
	
    @RequestMapping(value="/equipes",method=RequestMethod.PUT)
	public void updateEquipe(@RequestBody Equipe equipe) {
    	equipeMetier.updateEquipe(equipe);
	}
}
