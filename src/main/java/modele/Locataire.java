package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.JDBCCharge;
import dao.JDBCLocataire;

public class Locataire {

	private String idLocataire;
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
	private List<Caution> cautions;
	private List<Bail> baux; 
	private List<BienImmobilier> biens;
	private List<Charge> charges;
    private final JDBCLocataire donneesLocataire = new JDBCLocataire();

	public Locataire() {
		this.cautions = new ArrayList<>();
		this.baux = new ArrayList<>();
		this.biens = new ArrayList<>();
		this.charges = new ArrayList<>();
	}

	public Locataire(String idLocataire, String nom, String prenom, Genre genre, LocalDate dateNaissance, String lieuNaissance,
			String nationalite, String profession, String telephone, String email, LocalDate dateEntree,
			LocalDate dateDepart, double quotite) {
		this.idLocataire = idLocataire;
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.profession = profession;
		this.telephone = telephone;
		this.email = email;
		this.dateEntree = dateEntree;
		this.dateDepart = dateDepart;
		this.quotite = quotite;
		this.cautions = new ArrayList<>();
		this.baux = new ArrayList<>();
		this.biens = new ArrayList<>();
        JDBCCharge donneesCharges = new JDBCCharge();
        this.charges = donneesCharges.getByLocataire(this);
	}

	public boolean estLocataireAncien() {
		return false;
	}

	public double nbMoisOccupation() {
		return 0;
	}

	public String getIdLocataire() {
		return this.idLocataire;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	public String getLieuNaissance() {
		return this.lieuNaissance;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public String getProfession() {
		return this.profession;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public LocalDate getDateEntree() {
		return this.dateEntree;
	}

	public LocalDate getDateDepart() {
		return this.dateDepart;
	}

	public double getQuotite() {
		return this.quotite;
	}

	public List<Caution> getCautions() {
		return this.cautions;
	}
	
	public void ajouterCaution(Caution... cautions) {
        this.cautions.addAll(Arrays.asList(cautions));
	}

	public List<Bail> getBaux() {
		return this.baux;
	}

	public List<BienImmobilier> getBiens() {
		return this.biens;
	}

	public List<Charge> getCharges() {
		return this.charges;
	}

	public void archiverLocataire() {
		this.dateDepart = LocalDate.now();
	}

	public void setIdLocataire(String id) { this.idLocataire = id; }

	public void setNom(String nom){
		this.nom = nom;
	}

	public void setPrenom(String prenom) { this.prenom = prenom; }

	public void setDateNaissance(LocalDate date){
		this.dateNaissance = date;
	}

	public void setTelephone(String tel){
		this.telephone = tel;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setDateEntree(LocalDate date){
		this.dateEntree = date;
	}

	// partie DAO

	public void enregistrerLocataire() { this.donneesLocataire.insert(this); }

	public void mettreAJourLocataire() {
		this.donneesLocataire.update(this);
	}

	public List<Locataire> getAllLocataires() {
		return this.donneesLocataire.getAll();
	}

	public Locataire getLocatairesById(String idLocataire) {
		return this.donneesLocataire.getById(idLocataire).orElseThrow();
	}

	public List<Locataire> getLocatairesByNom(String nom) {
		return this.donneesLocataire.getAll().stream().filter(locataire -> locataire.getNom().equals(nom))
				.toList();
	}

}
