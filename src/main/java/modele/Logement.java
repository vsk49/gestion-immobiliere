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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Logement logement)) return false;
		if (!super.equals(o)) return false;
        return numeroEtage == logement.numeroEtage &&
				Double.compare(logement.surfaceHabitable, surfaceHabitable) == 0 &&
				nbPieces == logement.nbPieces;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), numeroEtage, surfaceHabitable, nbPieces);
	}

	@Override
	public String toString() {
		return super.toString() + "Logement{" +
				"numeroEtage=" + numeroEtage +
				", surfaceHabitable=" + surfaceHabitable +
				", nbPieces=" + nbPieces +
				"} ";
	}

}
