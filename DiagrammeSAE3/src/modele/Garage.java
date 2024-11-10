package modele;

import java.time.LocalDate;

public class Garage extends BienLouable {

	private Logement logement;

	public Garage(String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres,
			LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier, double surface, int nbPieces,
			Compteur compteur, Logement logement) {
		super(adresse, numeroFiscal, codePostal, ville, montantTaxesFoncieres, dateAnniversaire, ICCDateDebut,
				idBienImmobilier, surface, nbPieces, compteur);
		this.logement = logement;
	}

}
