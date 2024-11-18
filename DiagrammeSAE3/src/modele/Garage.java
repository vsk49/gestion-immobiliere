package modele;

import java.time.LocalDate;

public class Garage extends BienLouable {
	
	private Logement logement;

	public Garage(int idBienImmobilier, String numeroFiscal, String adresse, String codePostal, String ville,
			LocalDate dateAnniversaire, double montantTaxesFoncieres, double ICCDateDebut, double surface, int nbPieces,
			Compteur compteur, Logement logement) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, montantTaxesFoncieres,
				ICCDateDebut, surface, nbPieces, compteur);
		this.logement = logement;
	}
	
	public Logement getLogementLie() {
		return this.logement;
	}

}
