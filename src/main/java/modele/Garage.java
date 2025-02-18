package modele;

import java.time.LocalDate;

public class Garage extends BienImmobilier {

	public Garage(String adresse, int codePostal, String ville, LocalDate dateAcquisition) {
		super(null, adresse, codePostal, ville, dateAcquisition);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
