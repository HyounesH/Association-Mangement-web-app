package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.TypeAction;
import ma.infosat.gestion.adherent.metier.TypeActionMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RequestMapping("/assocSat")

public class TypeActionRestService {

	@Autowired
	private TypeActionMetier typeActionMetier;
	
	@RequestMapping(value="/typeActions/{id}",method=RequestMethod.DELETE)
	public void deleteTypeAction(@PathVariable Long id) {
		typeActionMetier.deleteTypeAction(id);
	}
	
	
	@RequestMapping(value="/typeActions",method=RequestMethod.POST)
	public TypeAction saveTypeAction(@RequestBody TypeAction typeAction) {
		return typeActionMetier.saveTypeAction(typeAction);
	}
	
    @RequestMapping(value="/typeActions",method=RequestMethod.GET)
	public List<TypeAction> listTypeAction() {
		return typeActionMetier.listTypeAction();
	}
	
    @RequestMapping(value="/typeActions",method=RequestMethod.PUT)
	public void updateTypeAction(@RequestBody TypeAction typeAction) {
    	typeActionMetier.updateTypeAction(typeAction);
	}
}

