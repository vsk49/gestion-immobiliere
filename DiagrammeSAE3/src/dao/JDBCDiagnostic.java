package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.time.LocalDate;

import modele.BienImmobilier;
import modele.Diagnostic;

public class JDBCDiagnostic implements DAODiagnostic {
	
	private String reference;
	private LocalDate dateRealisation;
	private String type;
	private LocalDate dateExpiration;
	private String classification;
	private String operateur;
	private String numeroRapport;
	private BienImmobilier bien;

	@Override
	public List<Diagnostic> getAll() {
		List<Diagnostic> diagnostics = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Diagnostic");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Diagnostic d = new Diagnostic();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnostics;
	}

	@Override
	public Optional<Diagnostic> getById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean insert(Diagnostic t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Diagnostic t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Diagnostic t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Diagnostic> getByNumeroRapport(String numeroRapport) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
