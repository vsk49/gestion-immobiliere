package dao;

import java.sql.Connection;
import java.time.LocalDate;

import modele.Genre;
import modele.Locataire;

public class InputData {
	
	private final JDBCLocataire donneesLocataires = new JDBCLocataire();

	public static void main(String[] args) {
		Connection connexion = JDBCConnexion.getConnexion();
		InsererDonnees();
		JDBCConnexion.closeConnexion();
	}

	private static void InsererDonnees() {
		Locataire l1 = new Locataire("DUDU", "Dupont", "Dudule",
				Genre.MASCULIN, LocalDate.of(1984, 1, 23), "Toulouse",
				"France", "", "06 12 34 56 78",
				"dupont.dudule@gmail.com", null, null, 0);
		Locataire l2 = new Locataire("DULA", "Dupont", "Laure",
				Genre.FEMININ, null, null,
				null, null, null,
				null, null, null, 0);
	}

}
