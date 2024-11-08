package modele;

import java.util.ArrayList;
import java.util.List;

public class BienLouable extends BienImmobilier {

	private double surface;
	private int nbPieces;
	private Compteur compteur;
	private List<FactureTravail> travaux = new ArrayList<>();
	private List<Loyer> loyers = new ArrayList<Loyer>();

	public BienLouable(double surface, int nbPieces, Compteur compteur) {
		this.surface = surface;
		this.nbPieces = nbPieces;
		this.compteur = compteur;
	}

	public void changerCompteur(double indexActuel) {
		this.compteur.setIndexActuel(indexActuel);
	}

}
