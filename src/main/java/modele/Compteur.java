package modele;

import java.time.LocalDate;

public class Compteur {

	private int idCompteur;
	private String numeroCompteur;
	private TypeCompteur typeCompteur;
	private int indexAncien;
	private int indexActuel;
	private LocalDate dateReleveEntree;
	private int consommation;
	private BienImmobilier bien;

	public Compteur(int idCompteur, String numeroCompteur, TypeCompteur typeCompteur, int indexAncien,
					int indexActuel, LocalDate dateReleveEntree, int consommation, BienImmobilier bien) {
		this.idCompteur = idCompteur;
		this.numeroCompteur = numeroCompteur;
		this.typeCompteur = typeCompteur;
		this.indexAncien = indexAncien;
		this.indexActuel = indexActuel;
		this.dateReleveEntree = dateReleveEntree;
		this.consommation = consommation;
		this.bien = bien;
	}

	public int getIdCompteur() {
		return this.idCompteur;
	}
	
	public String getNumero() {
		return this.numeroCompteur;
	}
	
	public TypeCompteur getTypeCompteur() {
		return this.typeCompteur;
	}
	
	public int getIndexAncien() {
		return this.indexAncien;
	}

	public int getIndexActuel() {
		return this.indexActuel;
	}

	public LocalDate getDateReleveEntree() {
		return this.dateReleveEntree;
	}

	public int getConsommation() {
		return this.consommation;
	}

	public BienImmobilier getBien() {
		return this.bien;
	}
	
	public int variationIndex() {
		return this.indexActuel - this.indexAncien;
	}

	public void modifierIndexes(int nouveauIndex) {
		this.indexAncien = this.indexActuel;
		this.indexActuel = nouveauIndex;
	}

	public void ajouterReleve() {}

	public void remplacerCompteur(String numeroCompteur, TypeCompteur typeCompteur) {
		this.numeroCompteur = numeroCompteur;
		this.typeCompteur = typeCompteur;
	}

}
