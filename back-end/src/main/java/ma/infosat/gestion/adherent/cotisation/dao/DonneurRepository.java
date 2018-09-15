package ma.infosat.gestion.adherent.cotisation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.infosat.gestion.adherent.cotisation.entities.Donneur;
import ma.infosat.gestion.adherent.cotisation.entities.PersonneMorale;
import ma.infosat.gestion.adherent.cotisation.entities.PersonnePhysique;

public interface DonneurRepository extends JpaRepository<Donneur, Integer>{
	
	@Query("SELECT d FROM Donneur d where d.id_donneur=:id")
	public Donneur getDonnateurById(@Param("id") int id);
	@Query("SELECT p FROM PersonneMorale p WHERE p.id_donneur=:id")
	public PersonneMorale getDonnateurMoral(@Param("id") int id);
	@Query("SELECT p FROM PersonnePhysique p WHERE p.id_donneur=:id")
	public PersonnePhysique getDonnateurPhysique(@Param("id") int id);
	@Query("SELECT d from Donneur d where d.email=:email and d.password=:password")
	public List<Donneur> login(@Param("email") String email,@Param("password")String passwd);
	

}
