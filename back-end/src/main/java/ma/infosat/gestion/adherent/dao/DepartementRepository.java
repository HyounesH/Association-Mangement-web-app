package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
