package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loyer {

	private int idLoyer;
	private LocalDate dateLoyer;
	private double montantLoyer;
	private double provisionPourCharge;
	private BienLouable bien;
	private List<Locataire> locataires;

	public Loyer(int idLoyer, LocalDate dateLoyer, double montantLoyer, double provisionPourCharge, BienLouable bien) {
		this.dateLoyer = dateLoyer;
		this.montantLoyer = montantLoyer;
		this.provisionPourCharge = provisionPourCharge;
		this.idLoyer = idLoyer;
		this.bien = bien;
		this.locataires = new ArrayList<>();
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

	public BienLouable getBienLouable() {
		return this.bien;
	}

	public List<Locataire> getLocataires() {
		return this.locataires;
	}
	
	public void ajouterLocataires(Locataire... l) {
		for (Locataire loc : l) {
			this.locataires.add(loc);
		}
	}
	
}
