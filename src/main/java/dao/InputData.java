package dao;

import java.sql.Connection;

import modele.Locataire;

public class InputData {
	
	private JDBCLocataire dataLocataire = new JDBCLocataire();

	public static void main(String[] args) {
		Connection connexion = JDBCConnexion.getConnexion();
		InputData();
		JDBCConnexion.closeConnexion();
	}

	private static void InputData() {
		Locataire l1 = new Locataire(null, null, null, null, null, null, null, null, null, null, null, null, 0);
	}

}
