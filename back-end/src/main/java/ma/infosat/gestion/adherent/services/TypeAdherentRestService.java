package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.TypeAdherent;
import ma.infosat.gestion.adherent.metier.TypeAdherentMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RequestMapping("/assocSat")
public class TypeAdherentRestService {

	@Autowired
	private TypeAdherentMetier typeAdherentMetier;
	
	@RequestMapping(value="/typeAdherents/{id}",method=RequestMethod.DELETE)
	public void deleteTypeAdherent(@PathVariable Long id) {
		typeAdherentMetier.deleteTypeAdherent(id);
	}
	
	
	@RequestMapping(value="/typeAdherents",method=RequestMethod.POST)
	public TypeAdherent saveTypeAdherent(@RequestBody TypeAdherent typeAdherent) {
		return typeAdherentMetier.saveTypeAdherent(typeAdherent);
	}
	
    @RequestMapping(value="/typeAdherents",method=RequestMethod.GET)
	public List<TypeAdherent> listTypeAdherent() {
		return typeAdherentMetier.listTypeAdherent();
	}
	
    @RequestMapping(value="/typeAdherents",method=RequestMethod.PUT)
	public void updateTypeAdherent(@RequestBody TypeAdherent typeAdherent) {
    	typeAdherentMetier.updateTypeAdherent(typeAdherent);
	}
}

