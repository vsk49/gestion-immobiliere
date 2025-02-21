package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loyer {

	private int idLoyer;
	private LocalDate dateLoyer;
	private double montantLoyer;
	private double provisionPourCharge;
	private BienImmobilier bien;
	private List<Locataire> locataires;

	public Loyer(int idLoyer, LocalDate dateLoyer, double montantLoyer, double provisionPourCharge, BienImmobilier bien) {
		this.idLoyer = idLoyer;
		this.dateLoyer = dateLoyer;
		this.montantLoyer = montantLoyer;
		this.provisionPourCharge = provisionPourCharge;
		this.bien = bien;
		this.locataires = new ArrayList<>();
	}

	public int getIdLoyer() {
		return this.idLoyer;
	}

	public LocalDate getDateLoyer() {
		return this.dateLoyer;
	}

	public double getMontantLoyer() {
		return this.montantLoyer;
	}
	
	public void setMontantLoyer(double nouveauLoyer) {
		this.montantLoyer += nouveauLoyer;
	}

	public double getProvisionPourCharge() {
		return this.provisionPourCharge;
	}
	
	public void setProvisionPourCharge(double nouvelleProvision) {
		this.provisionPourCharge += nouvelleProvision;
	}

	public BienImmobilier getBienLouable() {
		return this.bien;
	}

	public List<Locataire> getLocataires() {
		return this.locataires;
	}
	
	public void ajouterLocataires(Locataire... l) {
        this.locataires.addAll(Arrays.asList(l));
	}
	
}
