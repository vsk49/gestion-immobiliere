package modele;

import java.util.ArrayList;
import java.util.List;

public class BienLouable extends BienImmobilier {

	private double surface;
	private int nbPieces;
	private List<FactureTravail> travaux = new ArrayList<>();
	private Compteur compteur;
	private List<Loyer> loyers = new ArrayList<Loyer>();

	public BienLouable() {
	}

	public void changerCompteur(Compteur nvCompteur) {
	}

}
