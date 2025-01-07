package modele;

import java.time.LocalDate;

public class Logement extends BienLouable {
	
	private Garage garage;

	public Logement(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
			LocalDate dateAnniversaire, TaxeFonciere taxesFoncieres, int ICCDateDebut, double surface, int nbPieces,
			Garage garage) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, ICCDateDebut, surface, nbPieces);
		this.garage = garage;
	}

	public boolean estEnColocation() {
		return false;
	}

	public String getDateDepartLocataire(String id) {
		return null;
	}

	public double getQuotiteLocataire(String id) {
		return 0;
	}
	
	public Garage getGarageLie() {
		return this.garage;
	}

	public void changerCompteur() {

	}

}
