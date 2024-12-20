package dao;

import java.sql.Connection;
import java.time.LocalDate;

import modele.BienImmobilier;
import modele.Genre;
import modele.Locataire;

public class InputData {
	
	private static final JDBCLocataire donneesLocataires = new JDBCLocataire();
	private static final JDBCBienImmobilier donneesBiens = new JDBCBienImmobilier();

	private static final Locataire[] locataires = {
			new Locataire("YPOU", "Poux--Bories", "Yoan",
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

	private static final BienImmobilier[] biens = {
			new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31000, "Toulouse",
					LocalDate.of(2020, 2, 2), null, 1234, null),
			new BienImmobilier(2, null, "90 boulevard du 6 juin 1944", 31000, "Toulouse",
					LocalDate.of(2020, 3, 3), null, 1547, null),
			new BienImmobilier(3, "3198765432100", "10 rue des Princes", 31000, "Toulouse",
					LocalDate.of(2020, 4, 4), null, 1889, null),
			new BienImmobilier(4, "3101234567891", "41 rue des Lilas", 31000, "Toulouse",
					LocalDate.of(2020, 5, 5), null, 1672, null)
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
		for (BienImmobilier bien : biens) {
			donneesBiens.insert(bien);
		}
	}

}
