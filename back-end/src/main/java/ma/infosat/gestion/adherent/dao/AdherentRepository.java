package ma.infosat.gestion.adherent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.infosat.gestion.adherent.entities.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Long>{
	
	@Query("SELECT c FROM Adherent c WHERE c.nom_adherent like :value")
	public Page<Adherent> search(@Param("value") String value,Pageable pageable);
	
	@Query("SELECT c from Adherent c where c.email=:email and c.motPasse=:password")
	public List<Adherent> login(@Param("email") String email,@Param("password")String passwd);
	
	@Query("SELECT count(c) from Adherent c")
	public int countAdherent();
	
	@Query("SELECT a FROM Adherent a where a.id_adherent=:id")
	public Adherent getAdherentById(@Param("id") Long id);
	
	@Query("SELECT a FROM Adherent a WHERE a.role IN ('secretaire','trésorier','vice-président','secrétaire-general','responsable-archive','president')")
	public List<Adherent> getListMembres();
}
