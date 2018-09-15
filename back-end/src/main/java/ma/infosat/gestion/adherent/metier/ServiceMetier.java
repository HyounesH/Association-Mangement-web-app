package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Service;

public interface ServiceMetier {
	public Service saveService(Service service);
	public List<Service> listService();
	public void deleteService(Long id);
	public void updateService(Service service);
}
