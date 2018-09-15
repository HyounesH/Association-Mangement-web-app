package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Telephone;

public interface TelephoneRepository  extends JpaRepository<Telephone, Long>{

}
