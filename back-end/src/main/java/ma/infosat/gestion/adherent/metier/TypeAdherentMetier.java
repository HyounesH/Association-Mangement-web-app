package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.TypeAdherent;

public interface TypeAdherentMetier {
	public TypeAdherent saveTypeAdherent(TypeAdherent typeAdherent);
	public List<TypeAdherent> listTypeAdherent();
	public void deleteTypeAdherent(Long id);
	public void updateTypeAdherent(TypeAdherent typeAdherent);
}
