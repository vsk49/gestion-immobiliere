package modele;

import java.time.LocalDate;

public class Charge {

	private int idCharge;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private double montantEau;
	private double montantCoPropriete;
	private double montantElectricite;

	public Charge(int idCharge, LocalDate dateDebut, LocalDate dateFin, double montantEau, double montantCoPropriete,
			double montantElectricite) {
		this.idCharge = idCharge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montantEau = montantEau;
		this.montantCoPropriete = montantCoPropriete;
		this.montantElectricite = montantElectricite;
	}

	public int getIdCharge() {
		return this.idCharge;
	}

	public LocalDate getDateDebut() {
		return this.dateDebut;
	}

	public LocalDate getDateFin() {
		return this.dateFin;
	}

	public double getMontantEau() {
		return this.montantEau;
	}

	public void setMontantEau(double value) {
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

	public double getMontantReelDeCharge() {
		return this.montantEau + this.montantCoPropriete + this.montantElectricite;
	}

}
