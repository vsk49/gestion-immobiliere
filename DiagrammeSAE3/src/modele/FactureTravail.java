package modele;

import java.time.LocalDate;

public class FactureTravail {

	private String entreprise;
	private String numeroFacture;
	private LocalDate date;
	private String referenceDevis;
	private double montant;
	private String nature;
	private double montantDevis;

	public FactureTravail(String entreprise, String numeroFacture, LocalDate date, String referenceDevis, double montant, String nature, double montantDevis) {
		this.entreprise = entreprise;
		this.numeroFacture = numeroFacture;
		this.date = date;
		this.referenceDevis = referenceDevis;
		this.montant = montant;
		this.nature = nature;
		this.montantDevis = montantDevis;
	}

}
