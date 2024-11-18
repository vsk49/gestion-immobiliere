package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Batiment extends BienImmobilier {

	private List<BienLouable> biensLouables;

	public Batiment(int idBienImmobilier, String numeroFiscal, String adresse, String codePostal, String ville,
			LocalDate dateAnniversaire, double montantTaxesFoncieres, double ICCDateDebut) {
		super(idBienImmobilier, numeroFiscal, adresse, codePostal, ville, dateAnniversaire, montantTaxesFoncieres,
				ICCDateDebut);
		this.biensLouables = new ArrayList<>();
	}
	
	public List<BienLouable> getBiensLouables() {
		return this.biensLouables;
	}

}
