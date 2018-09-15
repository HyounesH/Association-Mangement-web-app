package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Equipe;
import ma.infosat.gestion.adherent.entities.Equipe_FK;

public interface EquipeRepository extends JpaRepository<Equipe, Equipe_FK> {

}
