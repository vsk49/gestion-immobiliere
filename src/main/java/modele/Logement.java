package modele;

import java.time.LocalDate;
import java.util.Objects;

public class Logement extends BienImmobilier {

	private int numeroEtage;
	private double surfaceHabitable;
	private int nbPieces;

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

	public void setNumeroEtage(int numeroEtage) {
		this.numeroEtage = numeroEtage;
	}

	public double getSurfaceHabitable() {
		return this.surfaceHabitable;
	}

	public void setSurfaceHabitable(double v) {
		this.surfaceHabitable = v;
	}

	public int getNbPieces() {
		return this.nbPieces;
	}

	public void setNbPieces(int n) {
		this.nbPieces = n;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Logement logement)) return false;
		if (!super.equals(o)) return false;
        return this.numeroEtage == logement.numeroEtage
				        && Double.compare(this.surfaceHabitable, logement.surfaceHabitable) == 0
				        && this.nbPieces == logement.nbPieces;
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
