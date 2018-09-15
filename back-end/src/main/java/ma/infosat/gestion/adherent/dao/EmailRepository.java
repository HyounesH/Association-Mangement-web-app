package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.infosat.gestion.adherent.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
