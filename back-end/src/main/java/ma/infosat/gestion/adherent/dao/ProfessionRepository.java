package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Long>{

}
