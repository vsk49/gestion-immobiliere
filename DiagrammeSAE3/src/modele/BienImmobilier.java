package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BienImmobilier {
	
	private String adresse;
	private String numeroFiscal;
	private String codePostal;
	private String ville;
	private double montantTaxesFoncieres;
	private LocalDate dateAnniversaire;
	public double ICCDateDebut;
	private int idBienImmobilier;
	private List<Locataire> locataires = new ArrayList<Locataire>();
	private List<Assurance> assurances = new ArrayList<Assurance>();
	private List<Bail> baux = new ArrayList<Bail>();

	public BienImmobilier(String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres, LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier) {
		this.adresse = adresse;
		this.numeroFiscal = numeroFiscal;
		this.codePostal = codePostal;
		this.ville = ville;
		this.montantTaxesFoncieres = montantTaxesFoncieres;
		this.dateAnniversaire = dateAnniversaire;
		this.ICCDateDebut = ICCDateDebut;
		this.idBienImmobilier = idBienImmobilier;
	}

	public int getIdBienImmobilier() {
		return this.idBienImmobilier;
	}

}
