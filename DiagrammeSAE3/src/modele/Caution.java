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

	public Caution(String nom, String prenom, LocalDate dateNaissance, String nationalite, String adresse, String codePostal, String ville, String profession, String employeur, double revenusMensuelsNets, String typeContratTravail, String lienLocataire, LocalDate dateSignature, double montantCautionne, int idCaution) {
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
		return this.idCaution;
	}

}
