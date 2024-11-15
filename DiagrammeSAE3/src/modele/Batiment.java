package modele;

import java.util.ArrayList;
import java.util.List;

public class Batiment extends BienImmobilier {

	private List<BienLouable> biensLouables = new ArrayList<BienLouable>();

	public Batiment(String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres, LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier) {
		super (adresse, numeroFiscal, codePostal, ville, montantTaxesFoncieres, dateAnniversaire, ICCDateDebut, t idBienImmobilier);
	}

}
