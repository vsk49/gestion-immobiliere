package modele;

import java.time.LocalDate;

public abstract class Charge {

	private int idCharge;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private double montantEau;
	private double montantCoPropriete;
	private double montantElectricite;

	public Charge(LocalDate dateDebut, LocalDate dateFin, int idCharge, double montantEau, double montantCoPropriete, double montantElectricite) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idCharge = idCharge;
		this.montantEau = montantEau;
		this.montantCoPropriete = montantCoPropriete;
		this.montantElectricite = montantElectricite;
	}

	public int getIdCharge() {
		return this.idCharge;
	}

	public LocalDate getDateDebut(){
		return this.dateDebut;
	}

	public LocalDate getDateFin(){
		return this.dateFin;
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

	public double getMontantTotalDeCharge(){
		return this.montantEau + this.montantCoPropriete + this.montantElectricite;
	}
	
}
