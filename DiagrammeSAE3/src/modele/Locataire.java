package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Locataire {
	
	private String nom;
	private String prenom;
	private Genre genre;
	private LocalDate dateNaissance;
	private String lieuNaissance;
	private String nationalite;
	private String profession;
	private String telephone;
	private String email;
	private LocalDate dateEntree;
	private LocalDate dateDepart;
	private double quotite;
	private int idLocataire;
	private List<BienImmobilier> bien = new ArrayList<BienImmobilier>();
	private Caution caution;
	private List<Charge> charges = new ArrayList<Charge>();
	private Bail bail;

	public double soldeDeToutCompte() {
		return 0;
	}

	public boolean estLocataireAncien() {
		return false;
	}

	public double nbMoisOccupation() {
		return 0;
	}

	public Locataire() {
	}

	public int getIdLocataire() {
		return this.idLocataire;
	}

}
