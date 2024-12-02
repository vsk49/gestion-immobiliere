package dao;

import java.util.List;
import java.util.Optional;

import modele.BienImmobilier;
import modele.Diagnostic;

public interface DAODiagnostic extends DAO<Diagnostic, Integer> {
	
	public Optional<Diagnostic> getByNumeroRapport(String numeroRapport);
	
	public List<Diagnostic> getByBienImmobilier(BienImmobilier bien);
	
}
