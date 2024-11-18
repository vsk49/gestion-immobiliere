package dao;

import java.util.Optional;

import modele.Diagnostic;

public interface DAODiagnostic extends DAO<Diagnostic, Integer> {
	
	public Optional<Diagnostic> getByNumeroRapport(String numeroRapport);
	
}
