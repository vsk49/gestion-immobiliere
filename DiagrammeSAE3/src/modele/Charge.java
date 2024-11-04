package modele;

import java.time.LocalDate;

public abstract class Charge {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int idCharge;
	private double montantEau;
	private double montantCoPropriete;
	private double montantElectricite;

	public Charge() {
	}

	public abstract double montantTotalDeCharge();

	public int getIdCharge() {
		return this.idCharge;
	}

	public double getMontantEau() {
		return this.montantEau;
	}

	public void setMontantEau(final double value) {
		this.montantEau = value;
	}

	public double getMontantCoPropriete() {
		return this.montantCoPropriete;
	}

	public void setMontantCoPropriete(double value) {
		this.montantCoPropriete = value;
	}

	public double getMontantElectricite() {
		return this.montantElectricite;
	}

	public void setMontantElectricite(double value) {
		this.montantElectricite = value;
	}

}
