package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.infosat.gestion.adherent.dao.ServiceRepository;
import ma.infosat.gestion.adherent.entities.Service;

@org.springframework.stereotype.Service
public class ServiceMetierImpl implements ServiceMetier {

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public Service saveService(Service service) {
		return serviceRepository.save(service);
	}

	@Override
	public List<Service> listService() {
		return serviceRepository.findAll();
	}

	@Override
	public void deleteService(Long id) {
		serviceRepository.deleteById(id);

	}

	@Override
	public void updateService(Service service) {
		serviceRepository.save(service);

	}

}
