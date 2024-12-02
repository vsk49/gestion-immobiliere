package modele;

import java.time.LocalDate;

public class Compteur {

	private int idCompteur;
	private String numero;
	private TypeCompteur typeCompteur;
	private int indexAncien;
	private int indexActuel;
	private LocalDate dateReleveEntree;
	private int volumeEauConsommee;

	public Compteur(int idCompteur, String numero, TypeCompteur typeCompteur, int indexAncien, int indexActuel,
			LocalDate dateReleveEntree) {
		this.idCompteur = idCompteur;
		this.numero = numero;
		this.typeCompteur = typeCompteur;
		this.indexAncien = indexAncien;
		this.indexActuel = indexActuel;
		this.dateReleveEntree = dateReleveEntree;
	}

	public int getIdCompteur() {
		return this.idCompteur;
	}
	
	public String getNumero() {
		return this.numero;
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
	
	public int getConsommation() {
		return this.indexActuel - this.indexAncien;
	}

	public void setIndexActuel(int indexActuel) {
		this.indexActuel = indexActuel;
	}
	
	public LocalDate getDateReleveEntree() {
		return this.dateReleveEntree;
	}

	public void ajouterReleve() {

	}

	public void remplacerCompteur(String numero, TypeCompteur typeCompteur) {
		this.numero = numero;
		this.typeCompteur = typeCompteur;
	}

}
