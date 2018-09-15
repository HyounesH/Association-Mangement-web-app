package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Structure;

public interface StructureMetier {
public Structure saveStructure(Structure structure);
public List<Structure> listStructure();
public Structure  updateStructure(Structure structure);
public Structure getStructure(Long id);
public boolean DeleteStructure(Long id);
}
