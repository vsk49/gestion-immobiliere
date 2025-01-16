package modele;

import dao.JDBCLogement;

import java.time.LocalDate;

public class Logement extends BienLouable {
	
	private final Garage garage;
	private final JDBCLogement jdbcBienLouable = new JDBCLogement();

	public Logement() {
		super();
		this.garage = null;
	}

	public Logement(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
			LocalDate dateAnniversaire, int ICCDateDebut, double surface, int nbPieces, Garage garage) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, ICCDateDebut, surface, nbPieces);
		this.garage = garage;
	}

	public boolean estEnColocation() {
		return this.getLocataires().size() > 1;
	}

	public LocalDate getDateDepartLocataire(String id) {
		return this.getLocataires().stream().filter(locataire -> locataire.getIdLocataire().equals(id))
				.findFirst().orElseThrow().getDateDepart();
	}

	public double getQuotiteLocataire(String id) {
		return this.getLocataires().stream().filter(locataire -> locataire.getIdLocataire().equals(id))
				.findFirst().orElseThrow().getQuotite();
	}
	
	public Garage getGarageLie() {
		return this.garage;
	}

	public void changerCompteur() {

	}

	// Couche DAO
	public Logement getBienByNumeroFiscal(String numeroFiscal) {
		return (Logement) this.jdbcBienLouable.getByNumeroFiscal(numeroFiscal).orElseThrow();
	}

}
