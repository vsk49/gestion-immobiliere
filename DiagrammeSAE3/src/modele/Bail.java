package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bail {

	private LocalDate dateDebut;
	private double depotDeGarantie;
	private String duree;
	private LocalDate dateSignature;
	private LocalDate dateFin;
	private String indexAncienBail;
	private int idBail;
	private List<Locataire> locataires = new ArrayList<Locataire>();
	private BienImmobilier bien;
	private Loyer loyer;

	public Bail() {
	}

	public int nbLocataires() {
		// TODO Auto-generated return
		return 0;
	}

	public boolean estFini() {
		// TODO Auto-generated return
		return false;
	}

	public int getIdBail() {
		return this.idBail;
	}

}
