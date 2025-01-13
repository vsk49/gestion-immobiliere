package modele;

import java.time.LocalDate;

public class Garage extends BienLouable {
	
	private final Logement logement;

	public Garage(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
			LocalDate dateAnniversaire, int ICCDateDebut, double surface, int nbPieces, Logement logement) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, ICCDateDebut, surface, nbPieces);
		this.logement = logement;
	}
	
	public Logement getLogementLie() {
		return this.logement;
	}

}
