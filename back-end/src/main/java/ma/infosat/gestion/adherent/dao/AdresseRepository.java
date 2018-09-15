package ma.infosat.gestion.adherent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.infosat.gestion.adherent.entities.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse,Long> {
@Query("SELECT c FROM Adresse c WHERE c.adherent.id_adherent = :value")	
public Adresse getAdresseByAdherentId(@Param ("value") Long adherent_id);

	
}
 