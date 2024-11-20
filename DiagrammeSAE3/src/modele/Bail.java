package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bail {

	private int idBail;
	private LocalDate dateDebut;
	private double depotDeGarantie;
	private double dureeOccupation;
	private LocalDate dateSignature;
	private LocalDate dateFin;
	private int indexAncienBail;
	private BienImmobilier bien;
	private Loyer loyer;
	private List<Locataire> locataires; 

	public Bail(int idBail, LocalDate dateDebut, double depotDeGarantie, double duree, LocalDate dateSignature,
			LocalDate dateFin, int indexAncienBail, BienImmobilier bien, Loyer loyer) {
		this.idBail = idBail;
		this.dateDebut = dateDebut;
		this.depotDeGarantie = depotDeGarantie;
		this.dureeOccupation = duree;
		this.dateSignature = dateSignature;
		this.dateFin = dateFin;
		this.indexAncienBail = indexAncienBail;
		this.bien = bien;
		this.loyer = loyer;
		this.locataires = new ArrayList<>();
	}

	public int nbLocataires() {
		return this.locataires.size();
	}

	public boolean estFini() {
		return LocalDate.now().isAfter(this.dateFin);
	}

	public int getIdBail() {
		return this.idBail;
	}

	public LocalDate getDateDebut() {
		return this.dateDebut;
	}

	public double getDepotDeGarantie() {
		return this.depotDeGarantie;
	}

	public double getDureeOccupation() {
		return this.dureeOccupation;
	}

	public LocalDate getDateSignature() {
		return this.dateSignature;
	}

	public LocalDate getDateFin() {
		return this.dateFin;
	}

	public int getIndexAncienBail() {
		return this.indexAncienBail;
	}

	public BienImmobilier getBienImmobilier() {
		return this.bien;
	}

	public Loyer getLoyer() {
		return this.loyer;
	}

	public List<Locataire> getLocataires() {
		return this.locataires;
	}
	
}
