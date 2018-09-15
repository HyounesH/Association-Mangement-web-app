package ma.infosat.gestion.adherent.cotisation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.infosat.gestion.adherent.cotisation.entities.Don;
import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.entities.Espece;
import ma.infosat.gestion.adherent.cotisation.entities.Materiel;

public interface DonRepository extends JpaRepository<Don, Integer> {
	@Query("select m from Materiel m")
	public List<Materiel> listMateriel();
	
	@Query("SELECT count(d) from Don d")
	public int countDon();
	
	@Query("SELECT d FROM Donneur d WHERE d.suivi=true")
	public List<Donneur> getListDonnateurSuivi();
	
	@Query("SELECT m FROM Materiel m where m.donneur.id_donneur=:id")
	public List<Materiel> getListMaterielDonnateur(@Param("id") int id);
	
	@Modifying
	@Query("UPDATE Materiel m SET m.suivi=false WHERE m.donneur.id_donneur=:id ")
	public void unMarkDon(@Param("id") int id);
	@Query("select a from Espece a")
	public List<Espece> listArgent();
	
	@Query("select m from Materiel m where m.etat='livrer'")
	public List<Materiel> listMaterielSortant();
	
	@Query("SELECT m FROM Materiel m WHERE m.etat='recu'")
	public List<Materiel> listMaterielEntrants();
	

}
