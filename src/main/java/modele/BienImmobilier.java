package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BienImmobilier {

	private int idBienImmobilier;
	private String numeroFiscal;
	private String adresse;
	private int codePostal;
	private String ville;
	private LocalDate dateAnniversaire;
	private double montantTaxesFoncieres;
	private int ICCDateDebut;
	private List<Locataire> locataires;
	private List<Assurance> assurances;
	private List<Bail> baux;
	private List<Diagnostic> diagnostics;

	public BienImmobilier(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
			LocalDate dateAnniversaire, double montantTaxesFoncieres, int ICCDateDebut) {
		this.idBienImmobilier = idBienImmobilier;
		this.numeroFiscal = numeroFiscal;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.dateAnniversaire = dateAnniversaire;
		this.montantTaxesFoncieres = montantTaxesFoncieres;
		this.ICCDateDebut = ICCDateDebut;
		this.locataires = new ArrayList<>();
		this.assurances = new ArrayList<>();
		this.baux = new ArrayList<>();
		this.diagnostics = new ArrayList<>();
	}

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

	public double getMontantTaxesFoncieres() {
		return montantTaxesFoncieres;
	}

	public int getICCDateDebut() {
		return ICCDateDebut;
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

	public void ajouterLocataire(Locataire... l) {
		for (Locataire locataire : l) {
			this.locataires.add(locataire);
		}
	}

	public void ajouterAssurance(Assurance... a) {
		for (Assurance assurance : a) {
			this.assurances.add(assurance);
		}
	}

	public void ajouterBail(Bail... b) {
		for (Bail bail : b) {
			this.baux.add(bail);
		}
	}
	
	public void setICCDateDebut(int nouveauICC) {
		this.ICCDateDebut = nouveauICC;
	}

	public void calculerRevenusFonciers() {

	}
	
}
