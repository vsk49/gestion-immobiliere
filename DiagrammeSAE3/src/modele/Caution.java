package modele;

import java.time.LocalDate;

public class Caution {

	private int idCaution;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	private String adresse;
	private String codePostal;
	private String ville;
	private String profession;
	private String employeur;
	private double revenusMensuelsNets;
	private String typeContratTravail;
	private String lienLocataire;
	private LocalDate dateSignature;
	private double montantCautionne;

	public Caution(int idCaution, String nom, String prenom, LocalDate dateNaissance, String nationalite,
			String adresse, String codePostal, String ville, String profession, String employeur,
			double revenusMensuelsNets, String typeContratTravail, String lienLocataire, LocalDate dateSignature,
			double montantCautionne) {
		this.idCaution = idCaution;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.profession = profession;
		this.employeur = employeur;
		this.revenusMensuelsNets = revenusMensuelsNets;
		this.typeContratTravail = typeContratTravail;
		this.lienLocataire = lienLocataire;
		this.dateSignature = dateSignature;
		this.montantCautionne = montantCautionne;
	}

	public int getIdCaution() {
		return idCaution;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getProfession() {
		return profession;
	}

	public String getEmployeur() {
		return employeur;
	}

	public double getRevenusMensuelsNets() {
		return revenusMensuelsNets;
	}

	public String getTypeContratTravail() {
		return typeContratTravail;
	}

	public String getLienLocataire() {
		return lienLocataire;
	}

	public LocalDate getDateSignature() {
		return dateSignature;
	}

	public double getMontantCautionne() {
		return montantCautionne;
	}

}
