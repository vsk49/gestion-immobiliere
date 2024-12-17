package dao;

import java.sql.Connection;
import java.time.LocalDate;

import modele.Genre;
import modele.Locataire;

public class InputData {
	
	private static final JDBCLocataire donneesLocataires = new JDBCLocataire();

	private static final Locataire[] locataires = {
			new Locataire("YPOU", "--Poux Bories", "Yoan",
			Genre.MASCULIN, LocalDate.of(2004, 1, 23), "Toulouse",
			"France", "Etudiant", "06 12 34 56 78",
			"yoan.poux@gmail.com", LocalDate.of(2024, 5, 12), null, 0),
			new Locataire("VKOH", "Koh", "Virgil Shaun",
					Genre.MASCULIN, LocalDate.of(2004, 4, 9), "Toulouse",
					"Malaisie", "Etudiant", "06 11 16 22 42",
					"virgilskoh@gmail.com", LocalDate.of(2024, 3, 5), null, 0),
			new Locataire("EDEH", "Deher", "Enzo",
					Genre.MASCULIN, LocalDate.of(2004, 5, 6), "Toulouse",
					"France", "Etudiant", "06 12 34 56 78",
					"enzo.deher@gmail.com", LocalDate.of(2024, 1, 20), null, 0),
			new Locataire("RMIE", "Miegemolle", "Romain",
					Genre.MASCULIN, LocalDate.of(2004, 6, 7), "Toulouse",
					"France", "Etudiant", "06 12 34 56 78",
					"romain.miegemolle@gmail.com", LocalDate.of(2023, 8, 30), null, 0)
	};

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Connection connexion = JDBCConnexion.getConnexion();
		InsererDonnees();
		JDBCConnexion.closeConnexion();
	}

	private static void InsererDonnees() {
		for (Locataire locataire : locataires) {
			donneesLocataires.insert(locataire);
		}
	}

}
