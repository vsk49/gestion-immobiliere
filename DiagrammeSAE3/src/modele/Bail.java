package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Bail {

	private int idBail;
	private LocalDate dateDebut;
	private double depotDeGarantie;
	private String duree;
	private LocalDate dateSignature;
	private LocalDate dateFin;
	private String indexAncienBail;
	private BienImmobilier bien;
	private Loyer loyer;
	private List<Locataire> locataires = new ArrayList<Locataire>();

	public Bail(LocalDate dateDebut, double depotDeGarantie, String duree, LocalDate dateSignature, LocalDate dateFin, String indexAncienBail, int idBail, BienImmobilier bien, Loyer loyer) {
	this.dateDebut = dateDebut;
	this.depotDeGarantie = depotDeGarantie;
	this.duree = duree;
	this.dateSignature = dateSignature;
	this.dateFin = dateFin;
	this.indexAncienBail = indexAncienBail;
	this.idBail = idBail;
	this.bien = bien;
	this.loyer = loyer;
	}

	public int nbLocataires() {
		// TODO Auto-generated return
		return 0;
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
	
	public String getDuree() {
		return this.duree;
	}
	
	public LocalDate getDateSignature() {
		return this.dateSignature;
	}
	
	public LocalDate getDateFin() {
		return this.dateFin;
	
	
	}public String getIndexAncienBail() {
		return this.indexAncienBail;
	}
	
	public BienImmobilier getBien() {
		return this.bien;
	}
	
	public Loyer getLoyer() {
		return this.loyer;
	}
	
	public List<Locataire> getLocataires() {
		return this.locataires;
	}
}
