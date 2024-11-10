package modele;

import java.time.LocalDate;

public class Logement extends BienLouable {

	public Logement(String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres,
			LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier, double surface, int nbPieces,
			Compteur compteur) {
		super(adresse, numeroFiscal, codePostal, ville, montantTaxesFoncieres, dateAnniversaire, ICCDateDebut,
				idBienImmobilier, surface, nbPieces, compteur);
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

}
