package modele;

import java.time.LocalDate;

public class Loyer {

	private int idLoyer;
	private LocalDate dateLoyer;
	private double montantLoyer;
	private double provisionPourCharge;
	private Logement logement;
	private Locataire locataire;

	public Loyer(int idLoyer, LocalDate dateLoyer, double montantLoyer, double provisionPourCharge, Logement logement,
			Locataire locataire) {
		this.dateLoyer = dateLoyer;
		this.montantLoyer = montantLoyer;
		this.provisionPourCharge = provisionPourCharge;
		this.idLoyer = idLoyer;
		this.logement = logement;
		this.locataire = locataire;
	}

	public int getIdLoyer() {
		return this.idLoyer;
	}

	public void setIdLoyer(int value) {
		this.idLoyer = value;
	}

	public LocalDate getDateLoyer() {
		return this.dateLoyer;
	}

	public double getMontantLoyer() {
		return this.montantLoyer;
	}

	public double getProvisionPourCharge() {
		return this.provisionPourCharge;
	}

	public BienLouable getLogement() {
		return this.logement;
	}

	public Locataire getLocataire() {
		return this.locataire;
	}
	
}
