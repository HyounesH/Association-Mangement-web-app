package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.Media;
import ma.infosat.gestion.adherent.metier.MediaMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")

public class MediaRestService {
	@Autowired
	private MediaMetier mediaMetier;
	
	@RequestMapping(value="/medias/{id}",method=RequestMethod.DELETE)
	public void deleteMedia(@PathVariable Long id) {
		mediaMetier.deleteMedia(id);
	}
	
	
	@RequestMapping(value="/medias",method=RequestMethod.POST)
	public Media saveMedia(@RequestBody Media media) {
		return mediaMetier.saveMedia(media);
	}
	
    @RequestMapping(value="/medias",method=RequestMethod.GET)
	public List<Media> listMedia() {
		return mediaMetier.listMedia();
	}
	
    @RequestMapping(value="/medias",method=RequestMethod.PUT)
	public void updateMedia(@RequestBody Media media) {
    	mediaMetier.updateMedia(media);
	}
}
