package modele;

import java.time.LocalDate;

public class Charge {

	private int idCharge;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	// private Compteur compteur;

	public Charge(int idCharge, LocalDate dateDebut, LocalDate dateFin) {
		this.idCharge = idCharge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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

	public double getMontantCharge() {
		return 0;
	}

	public String getDetailsRegularisation() {
		return "";
	}

	public void genererRapportRegularisation() {

	}

}
