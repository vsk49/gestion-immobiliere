package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BienLouable extends BienImmobilier {

	private double surface;
	private int nbPieces;
	private Compteur compteur;
	private List<FactureTravail> facturesTravaux;
	private List<Loyer> loyers;

	public BienLouable(int idBienImmobilier, String numeroFiscal, String adresse, String codePostal, String ville,
			LocalDate dateAnniversaire, double montantTaxesFoncieres, double ICCDateDebut, double surface, int nbPieces,
			Compteur compteur) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, montantTaxesFoncieres,
				ICCDateDebut);
		this.surface = surface;
		this.nbPieces = nbPieces;
		this.compteur = compteur;
		this.facturesTravaux = new ArrayList<>();
		this.loyers = new ArrayList<>();
	}

	public double getSurface() {
		return this.surface;
	}

	public int getNbPieces() {
		return this.nbPieces;
	}

	public List<FactureTravail> getFacturesTravaux() {
		return this.facturesTravaux;
	}

	public List<Loyer> getLoyers() {
		return this.loyers;
	}

	public void changerCompteur(int indexActuel) {
		this.compteur.setIndexActuel(indexActuel);
	}

}
