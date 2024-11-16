package modele;

import java.time.LocalDate;

public class Logement extends BienLouable {
	
	private Garage garage;

	public Logement(int idBienImmobilier, String numeroFiscal, String adresse, String codePostal, String ville,
			LocalDate dateAnniversaire, double montantTaxesFoncieres, double ICCDateDebut, double surface, int nbPieces,
			Compteur compteur, Garage garage) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, montantTaxesFoncieres,
				ICCDateDebut, surface, nbPieces, compteur);
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

}
