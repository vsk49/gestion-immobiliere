package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Batiment extends BienImmobilier {

	private List<BienLouable> biensLouables = new ArrayList<BienLouable>();

	public Batiment(String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres,
			LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier) {
		super(adresse, adresse, adresse, adresse, ICCDateDebut, dateAnniversaire, ICCDateDebut, idBienImmobilier);
	}

}
