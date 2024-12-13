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

	public Compteur(int idCompteur, String numeroCompteur, TypeCompteur typeCompteur, int indexAncien,
					int indexActuel, LocalDate dateReleveEntree, int consommation) {
		this.idCompteur = idCompteur;
		this.numeroCompteur = numeroCompteur;
		this.typeCompteur = typeCompteur;
		this.indexAncien = indexAncien;
		this.indexActuel = indexActuel;
		this.dateReleveEntree = dateReleveEntree;
		this.consommation = consommation;
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
	
	public int variationIndex() {
		return this.indexActuel - this.indexAncien;
	}

	public void modifierIndexes(int nouveauIndex) {
		this.indexAncien = this.indexActuel;
		this.indexActuel = nouveauIndex;
	}
	
	public LocalDate getDateReleveEntree() {
		return this.dateReleveEntree;
	}

	public int getConsommation() {
		return this.consommation;
	}

	public void ajouterReleve() {

	}

	public void remplacerCompteur(String numeroCompteur, TypeCompteur typeCompteur) {
		this.numeroCompteur = numeroCompteur;
		this.typeCompteur = typeCompteur;
	}

}
