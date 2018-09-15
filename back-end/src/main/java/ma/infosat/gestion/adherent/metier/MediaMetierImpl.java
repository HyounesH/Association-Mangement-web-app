package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.MediaRepository;
import ma.infosat.gestion.adherent.entities.Media;

@Service
public class MediaMetierImpl implements MediaMetier {

	@Autowired
	private MediaRepository mediaRepository;
	
	@Override
	public Media saveMedia(Media media) {
		return mediaRepository.save(media);
	}

	@Override
	public List<Media> listMedia() {
		return mediaRepository.findAll();
	}

	@Override
	public void deleteMedia(Long id) {
		mediaRepository.deleteById(id);

	}

	@Override
	public void updateMedia(Media media) {
		mediaRepository.save(media);

	}

}
