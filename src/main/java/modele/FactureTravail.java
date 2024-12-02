package modele;

import java.time.LocalDate;

public class FactureTravail {

	private int idFactureTravail;
	private String numeroFacture;
	private LocalDate dateFacture;
	private String nature;
	private double montant;
	private String entreprise;
	private String referenceDevis;
	private double montantDevis;
	private BienLouable bien;

	public FactureTravail(int idFactureTravail, String numeroFacture, LocalDate dateFacture, String nature, double montant,
			String entreprise, String referenceDevis, double montantDevis, BienLouable bien) {
		this.idFactureTravail = idFactureTravail;
		this.numeroFacture = numeroFacture;
		this.dateFacture = dateFacture;
		this.nature = nature;
		this.montant = montant;
		this.entreprise = entreprise;
		this.referenceDevis = referenceDevis;
		this.montantDevis = montantDevis;
		this.bien = bien;
	}

	public int getIdFactureTravail() {
		return idFactureTravail;
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}

	public LocalDate getDateFacture() {
		return dateFacture;
	}

	public String getNature() {
		return nature;
	}

	public double getMontant() {
		return montant;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public String getReferenceDevis() {
		return referenceDevis;
	}

	public double getMontantDevis() {
		return montantDevis;
	}

	public BienLouable getBien() {
		return bien;
	}

	public void associerDevis(String referenceDevis, double montantDevis) {
		this.referenceDevis = referenceDevis;
		this.montantDevis = montantDevis;
	}

	public void genererRapportTravail() {

	}

	public void archiverFactureTravail() {

	}
	
}
