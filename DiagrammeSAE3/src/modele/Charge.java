package modele;

import java.time.LocalDate;

public abstract class Charge {

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int idCharge;
	private double montantEau;
	private double montantCoPropriete;
	private double montantElectricite;

	public Charge(LocalDate dateDebut, LocalDate dateFin, int idCharge, double montantEau, double montantCoPropriete, double montantElectricite) {
		this.dateDebut = dateDebut;
		this.dateFin;
		this.idCharge = idCharge;
		this.montantEau = montantEau;
		this.montantCoPropriete = montantCoPropriete;
		thiss.montantElectricite = montantElectricite;
	}

	public double getMontantTotalDeCharge(){
		return this.montantEau + this.montantCoPropriete + thiss.montantElectricite;
	};

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
