package modele;

import java.time.LocalDate;

public class Caution {

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
	private int idCaution;

	public Caution() {
	}

	public int getIdCaution() {
		return this.idCaution;
	}

}
