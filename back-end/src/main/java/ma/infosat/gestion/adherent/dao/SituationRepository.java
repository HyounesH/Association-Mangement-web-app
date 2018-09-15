package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Situation;

public interface SituationRepository  extends JpaRepository<Situation, Long>{

}
