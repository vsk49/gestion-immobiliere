package modele;

import java.util.ArrayList;
import java.util.List;

public class BienLouable extends BienImmobilier {

	private double surface;
	private int nbPieces;
	private Compteur compteur;
	private List<FactureTravail> travaux = new ArrayList<>();
	private List<Loyer> loyers = new ArrayList<Loyer>();

	public BienLouable(double surface, int nbPieces, Compteur compteur, String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres, LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier) {
		this.surface = surface;
		this.nbPieces = nbPieces;
		this.compteur = compteur;
		super (adresse, numeroFiscal, codePostal, ville, montantTaxesFoncieres, dateAnniversaire, ICCDateDebut, int idBienImmobilier);
	}

	public void changerCompteur(double indexActuel) {
		this.compteur.setIndexActuel(indexActuel);
	}

}
