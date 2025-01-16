package modele;

import dao.JDBCBatiment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Batiment extends BienImmobilier {

	private final List<BienLouable> biensLouables;
	private final JDBCBatiment jdbcBatiment = new JDBCBatiment();

	public Batiment() {
		super();
		this.biensLouables = new ArrayList<>();
	}

	public Batiment(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
					LocalDate dateAnniversaire, int ICCDateDebut) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, ICCDateDebut);
		this.biensLouables = new ArrayList<>();
	}
	
	public List<BienLouable> getBiensLouables() {
		return this.biensLouables;
	}

	public Batiment getBienById(int idBienImmobilier) {
		return (Batiment) this.jdbcBatiment.getById(idBienImmobilier).orElseThrow();
	}

}
