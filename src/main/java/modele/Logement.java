package modele;

import java.time.LocalDate;
import java.util.Objects;

public class Logement extends BienImmobilier {

	private final int numeroEtage;
	private final double surfaceHabitable;
	private final int nbPieces;

	public Logement(String idLogement, String adresse, int codePostal, String ville,
					LocalDate dateAcquisition, int numeroEtage, double surfaceHabitable, int nbPieces) {
		super(idLogement, adresse, codePostal, ville, dateAcquisition);
		this.numeroEtage = numeroEtage;
		this.surfaceHabitable = surfaceHabitable;
		this.nbPieces = nbPieces;
	}

	// getters
	public int getNumeroEtage() {
		return this.numeroEtage;
	}

	public double getSurfaceHabitable() {
		return this.surfaceHabitable;
	}

	public int getNbPieces() {
		return this.nbPieces;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), numeroEtage, nbPieces, surfaceHabitable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Logement other))
			return false;
		return super.equals(obj) && numeroEtage == other.numeroEtage && nbPieces == other.nbPieces
				&& Double.doubleToLongBits(surfaceHabitable) == Double.doubleToLongBits(other.surfaceHabitable);
	}

}
