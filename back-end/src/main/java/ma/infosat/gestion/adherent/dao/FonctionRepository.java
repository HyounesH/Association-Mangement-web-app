package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Fonction;

public interface FonctionRepository  extends JpaRepository<Fonction, Long> {

}
