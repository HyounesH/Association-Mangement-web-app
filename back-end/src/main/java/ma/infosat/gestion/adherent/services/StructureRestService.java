package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Structure;
import ma.infosat.gestion.adherent.metier.StructureMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class StructureRestService {
	
	@Autowired
	private StructureMetier structureMetier;
    
	@RequestMapping(value="/structures/{id}",method=RequestMethod.GET)
	public Structure getStructure(@PathVariable Long id) {
		return structureMetier.getStructure(id);
	}
	@RequestMapping(value="/structures/{id}" , method=RequestMethod.DELETE)
	public boolean DeleteStructure(@PathVariable Long id) {
		return structureMetier.DeleteStructure(id);
	}
	@RequestMapping(value="/structures",method=RequestMethod.POST)
	public Structure saveStructure(@RequestBody Structure structure) {
		return structureMetier.saveStructure(structure);
	}
    @RequestMapping(value="/structures",method=RequestMethod.GET)
	public List<Structure> listStructure() {
		return structureMetier.listStructure();
	}
    
    @RequestMapping(value="/structures",method=RequestMethod.PUT)
	public Structure updateStructure(@RequestBody Structure structure) {
    	return this.structureMetier.updateStructure(structure);
	}
	
	

}
