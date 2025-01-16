package modele;

import dao.JDBCBienLouable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BienLouable extends BienImmobilier {

	private double surface;
	private int nbPieces;
	private List<FactureTravail> facturesTravaux;
	private List<Loyer> loyers;
	private final JDBCBienLouable jdbcBienLouable = new JDBCBienLouable();

	public BienLouable() {
		super();
		this.facturesTravaux = new ArrayList<>();
		this.loyers = new ArrayList<>();
	}

	public BienLouable(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
			LocalDate dateAnniversaire, int ICCDateDebut, double surface, int nbPieces) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, ICCDateDebut);
		this.surface = surface;
		this.nbPieces = nbPieces;
		this.facturesTravaux = new ArrayList<>();
		this.loyers = new ArrayList<>();
	}

	// getters
	public double getSurface() {
		return this.surface;
	}

	public int getNbPieces() {
		return this.nbPieces;
	}

	public List<FactureTravail> getFacturesTravaux() {
		return this.facturesTravaux;
	}

	public List<Loyer> getLoyers() {
		return this.loyers;
	}

	// setters
	public void setSurface(double surface) {
		this.surface = surface;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	// Couche DAO
	public BienLouable getBienById(int idBienImmobilier) {
		return (BienLouable) this.jdbcBienLouable.getById(idBienImmobilier).orElseThrow();
	}

	public BienLouable getBienByNumeroFiscal(String numeroFiscal) {
		return (BienLouable) this.jdbcBienLouable.getByNumeroFiscal(numeroFiscal).orElseThrow();
	}

}
