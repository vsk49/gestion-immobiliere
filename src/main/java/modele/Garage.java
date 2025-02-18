package modele;

import java.time.LocalDate;

public class Garage extends BienImmobilier {

	public Garage(String idGarage, String adresse, int codePostal, String ville, LocalDate dateAcquisition) {
		super(idGarage, adresse, codePostal, ville, dateAcquisition);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Garage)) return false;
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString() + "Garage{} ";
	}

}
