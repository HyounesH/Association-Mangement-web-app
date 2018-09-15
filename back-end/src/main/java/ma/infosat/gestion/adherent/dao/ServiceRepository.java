package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Service;

public interface ServiceRepository extends JpaRepository<Service,Long>{

}
