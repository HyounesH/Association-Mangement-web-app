package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Structure;

public interface StructureRepository  extends JpaRepository<Structure, Long>{

}
