package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Service;
import ma.infosat.gestion.adherent.metier.ServiceMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")

public class ServiceRestService {
	@Autowired
	private ServiceMetier ServiceMetier;
	
	@RequestMapping(value="/services/{id}",method=RequestMethod.DELETE)
	public void deleteService(@PathVariable Long id) {
		ServiceMetier.deleteService(id);
	}
	
	@RequestMapping(value="/services",method=RequestMethod.POST)
	public Service saveService(@RequestBody Service service) {
		return ServiceMetier.saveService(service);
	}
	
    @RequestMapping(value="/services",method=RequestMethod.GET)
	public List<Service> listService() {
		return ServiceMetier.listService();
	}
	
    @PutMapping(value="/services")
	public void updateService(@RequestBody Service service) {
    	ServiceMetier.updateService(service);
	}
}
