package modele;

import dao.JDBCBienImmobilier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BienImmobilier {

	private int idBienImmobilier;
	private String numeroFiscal;
	private String adresse;
	private int codePostal;
	private String ville;
	private LocalDate dateAnniversaire;
	private int ICCDateDebut;
	private List<Locataire> locataires;
	private List<Compteur> compteurs;
	private List<Assurance> assurances;
	private List<Bail> baux;
	private List<Diagnostic> diagnostics;
	private List<TaxeFonciere> taxesFoncieres;

	private final JDBCBienImmobilier jdbcBienImmobilier = new JDBCBienImmobilier();

	public BienImmobilier() {
		this.locataires = new ArrayList<>();
		this.compteurs = new ArrayList<>();
		this.assurances = new ArrayList<>();
		this.baux = new ArrayList<>();
		this.diagnostics = new ArrayList<>();
		this.taxesFoncieres = new ArrayList<>();
	}

	public BienImmobilier(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal,
						  String ville, LocalDate dateAnniversaire, int ICCDateDebut) {
		this.idBienImmobilier = idBienImmobilier;
		this.numeroFiscal = numeroFiscal;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.dateAnniversaire = dateAnniversaire;
		this.ICCDateDebut = ICCDateDebut;
		this.compteurs = new ArrayList<>();
		this.locataires = new ArrayList<>();
		this.assurances = new ArrayList<>();
		this.baux = new ArrayList<>();
		this.diagnostics = new ArrayList<>();
		this.taxesFoncieres = new ArrayList<>();
	}

	// getters
	public int getIdBienImmobilier() {
		return this.idBienImmobilier;
	}

	public String getNumeroFiscal() {
		return this.numeroFiscal;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public LocalDate getDateAnniversaire() {
		return dateAnniversaire;
	}

	public int getICCDateDebut() {
		return ICCDateDebut;
	}

	public List<TaxeFonciere> getTaxesFoncieres() {
		return taxesFoncieres;
	}

	public List<Locataire> getLocataires() {
		return locataires;
	}

	public List<Assurance> getAssurances() {
		return assurances;
	}

	public List<Bail> getBaux() {
		return baux;
	}
	
	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

    public List<Compteur> getCompteurs() {
		return this.compteurs;
	}

	public void ajouterLocataire(Locataire... l) {
        this.locataires.addAll(Arrays.asList(l));
	}

	public void ajouterAssurance(Assurance... a) {
        this.assurances.addAll(Arrays.asList(a));
	}

	public void ajouterBail(Bail... b) {
        this.baux.addAll(Arrays.asList(b));
	}

	// setters
	public void setIdBienImmobilier(int idBienImmobilier) {
		this.idBienImmobilier = idBienImmobilier;
	}

	public void setNumeroFiscal(String numeroFiscal) {
		this.numeroFiscal = numeroFiscal;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setDateAnniversaire(LocalDate dateAnniversaire) {
		this.dateAnniversaire = dateAnniversaire;
	}

	public void setICCDateDebut(int nouveauICC) {
		this.ICCDateDebut = nouveauICC;
	}

	public void calculerRevenusFonciers() {}

	public double calculerPrixMoyenConsommation() {
		return 0;
	}

	// Couche DAO
	public List<BienImmobilier> getBiens() {
		return jdbcBienImmobilier.getAll();
	}

	public BienImmobilier getBienByNumeroFiscal(String numeroFiscal) {
		return jdbcBienImmobilier.getByNumeroFiscal(numeroFiscal).orElseThrow();
	}

	public BienImmobilier getBienById(int idBienImmobilier) {
		return jdbcBienImmobilier.getById(idBienImmobilier).orElseThrow();
	}

}