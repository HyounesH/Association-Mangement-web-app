package ma.infosat.gestion.adherent.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.infosat.gestion.adherent.dao.BureauVoteRepository;
import ma.infosat.gestion.adherent.entities.BureauVote;

@Service
public class BureauVoteMetierImpl implements BureauVoteMetier {

	@Autowired
	private BureauVoteRepository bureauVoteRepository;
	
	@Override
	public BureauVote saveBureauVote(BureauVote bureauVote) {
		return bureauVoteRepository.save(bureauVote);
	}

	@Override
	public List<BureauVote> listBureauVote() {
		return bureauVoteRepository.findAll();
	}

	@Override
	public void deleteBureauVote(Long id) {
		 bureauVoteRepository.deleteById(id);

	}

	@Override
	public void updateBureauVote(BureauVote bureauVote) {
		bureauVoteRepository.save(bureauVote);
	}

}
