package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Action;

public interface ActionRepository extends JpaRepository<Action, Long> {

}
