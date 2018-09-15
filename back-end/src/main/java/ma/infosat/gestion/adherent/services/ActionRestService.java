package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Action;
import ma.infosat.gestion.adherent.metier.ActionMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ActionRestService {

	@Autowired
	private ActionMetier actionMetier;
	
	@RequestMapping(value="/actions/{id}",method=RequestMethod.DELETE)
	public void deleteAction(@PathVariable Long id) {
		actionMetier.deleteAction(id);
	}
	
	
	@RequestMapping(value="/actions",method=RequestMethod.POST)
	public Action saveAction(@RequestBody Action action) {
		return actionMetier.saveAction(action);
	}
	
    @RequestMapping(value="/actions",method=RequestMethod.GET)
	public List<Action> listAction() {
		return actionMetier.listAction();
	}
	
    @RequestMapping(value="/actions",method=RequestMethod.PUT)
	public void updateAction(@RequestBody Action action) {
    	actionMetier.updateAction(action);
	}
}
