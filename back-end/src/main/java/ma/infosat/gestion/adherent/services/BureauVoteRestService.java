package ma.infosat.gestion.adherent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.infosat.gestion.adherent.entities.BureauVote;
import ma.infosat.gestion.adherent.metier.BureauVoteMetier;

@RestController
@RequestMapping("/assocSat")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class BureauVoteRestService {

	@Autowired
	private BureauVoteMetier bureauVoteMetier;
	
	@RequestMapping(value="/bureauVotes/{id}",method=RequestMethod.DELETE)
	public void deleteBureauVote(@PathVariable Long id) {
		bureauVoteMetier.deleteBureauVote(id);
	}
	
	
	@RequestMapping(value="/bureauVotes",method=RequestMethod.POST)
	public BureauVote saveBureauVote(@RequestBody BureauVote bureauVote) {
		return bureauVoteMetier.saveBureauVote(bureauVote);
	}
	
    @RequestMapping(value="/bureauVotes",method=RequestMethod.GET)
	public List<BureauVote> listBureauVote() {
		return bureauVoteMetier.listBureauVote();
	}
	
    @RequestMapping(value="/bureauVotes",method=RequestMethod.PUT)
	public void updateBureauVote(@RequestBody BureauVote bureauVote) {
    	bureauVoteMetier.updateBureauVote(bureauVote);
	}
	
}
