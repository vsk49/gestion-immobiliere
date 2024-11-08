package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Locataire {
	
	private String nom;
	private String prenom;
	private Genre genre;
	private LocalDate dateNaissance;
	private String lieuNaissance;
	private String nationalite;
	private String profession;
	private String telephone;
	private String email;
	private LocalDate dateEntree;
	private LocalDate dateDepart;
	private double quotite;
	private Caution caution;
	private int idLocataire;
	private List<Bail> baux = new ArrayList<Bail>();
	private List<BienImmobilier> bien = new ArrayList<BienImmobilier>();
	private List<Charge> charges = new ArrayList<Charge>();

	public Locataire(String nom, String prenom, Genre genre, LocalDate dateNaissance, String lieuNaissance, String nationalite, String profession, String telephone, String email, LocalDate dateEntree, LocalDate dateDepart, double quotite, Caution caution, int idLocataire) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance  = lieuNaissance;
		this.nationalite = nationalite;
		this.profession = profession;
		this.telephone = telephone;
		this.email = email;
		this.dateEntree = dateEntree;
		this.dateDepart = dateDepart;
		this.quotite = quotite;
		this.caution = caution;
		this.idLocataire = idLocataire;
	}
	
	public double soldeDeToutCompte() {
		return 0;
	}

	public boolean estLocataireAncien() {
		return false;
	}

	public double nbMoisOccupation() {
		return 0;
	}

	public int getIdLocataire() {
		return this.idLocataire;
	}

}
