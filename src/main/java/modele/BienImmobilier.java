package modele;

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
	private TaxeFonciere taxesFoncieres;
	private int ICCDateDebut;
	private Compteur compteurGeneral;
	private List<Locataire> locataires;
	private List<Assurance> assurances;
	private List<Bail> baux;
	private List<Diagnostic> diagnostics;

	public BienImmobilier(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
			LocalDate dateAnniversaire, TaxeFonciere taxesFoncieres, int ICCDateDebut, Compteur compteurGeneral) {
		this.idBienImmobilier = idBienImmobilier;
		this.numeroFiscal = numeroFiscal;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.dateAnniversaire = dateAnniversaire;
		this.taxesFoncieres = taxesFoncieres;
		this.ICCDateDebut = ICCDateDebut;
		this.locataires = new ArrayList<>();
		this.assurances = new ArrayList<>();
		this.baux = new ArrayList<>();
		this.diagnostics = new ArrayList<>();
		this.compteurGeneral = compteurGeneral;
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

	public TaxeFonciere getTaxesFoncieres() {
		return taxesFoncieres;
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
        this.locataires.addAll(Arrays.asList(l));
	}

	public void ajouterAssurance(Assurance... a) {
        this.assurances.addAll(Arrays.asList(a));
	}

	public void ajouterBail(Bail... b) {
        this.baux.addAll(Arrays.asList(b));
	}
	
	public void setICCDateDebut(int nouveauICC) {
		this.ICCDateDebut = nouveauICC;
	}

	public void calculerRevenusFonciers() {

	}

    public Compteur getCompteurGeneral() {
        return compteurGeneral;
    }

	public void changerCompteur(int indexActuel) {
		this.getCompteurGeneral().modifierIndexes(indexActuel);
	}

	public double calculerPrixMoyenConsommation() {
		return 0;
	}

}
