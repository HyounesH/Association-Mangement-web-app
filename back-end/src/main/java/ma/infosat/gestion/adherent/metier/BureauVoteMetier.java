package ma.infosat.gestion.adherent.metier;

import java.util.List;

import ma.infosat.gestion.adherent.entities.BureauVote;

public interface BureauVoteMetier {
	public BureauVote saveBureauVote(BureauVote bureauVote);
	public List<BureauVote> listBureauVote();
	public void deleteBureauVote(Long id);
	public void updateBureauVote(BureauVote bureauVote);
}
