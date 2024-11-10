package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BienLouable extends BienImmobilier {

	private double surface;
	private int nbPieces;
	private Compteur compteur;
	private List<FactureTravail> travaux = new ArrayList<>();
	private List<Loyer> loyers = new ArrayList<Loyer>();

	public BienLouable(String adresse, String numeroFiscal, String codePostal, String ville,
			double montantTaxesFoncieres, LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier,
			double surface, int nbPieces, Compteur compteur) {
		super(adresse, numeroFiscal, codePostal, ville, montantTaxesFoncieres, dateAnniversaire, ICCDateDebut,
				idBienImmobilier);
		this.surface = surface;
		this.nbPieces = nbPieces;
		this.compteur = compteur;
	}

	public void changerCompteur(double indexActuel) {
		this.compteur.setIndexActuel(indexActuel);
	}

}
