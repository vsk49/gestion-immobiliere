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

	public BienImmobilier() {
	}

	public int getIdBienImmobilier() {
		return this.idBienImmobilier;
	}

}
