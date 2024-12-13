package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Batiment extends BienImmobilier {

	private List<BienLouable> biensLouables;

	public Batiment(int idBienImmobilier, String numeroFiscal, String adresse, int codePostal, String ville,
			LocalDate dateAnniversaire, TaxeFonciere taxesFoncieres, int ICCDateDebut, Compteur compteurGeneral) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, taxesFoncieres,
				ICCDateDebut, compteurGeneral);
		this.biensLouables = new ArrayList<>();
	}
	
	public List<BienLouable> getBiensLouables() {
		return this.biensLouables;
	}

}
