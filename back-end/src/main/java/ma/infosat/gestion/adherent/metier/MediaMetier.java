package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.Media;

public interface MediaMetier {
	public Media saveMedia(Media media);
	public List<Media> listMedia();
	public void deleteMedia(Long id);
	public void updateMedia(Media media);
}
