package modele;

import java.time.LocalDate;
import java.util.Objects;

public class BienImmobilier {

	private final String idBienImmobilier;
	private final String adresse;
	private final int codePostal;
	private final String ville;
	private final LocalDate dateAcquisition;

	public BienImmobilier(String idBienImmobilier, String adresse, int codePostal, String ville, LocalDate dateAcquisition) {
		this.idBienImmobilier = idBienImmobilier;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.dateAcquisition = dateAcquisition;
	}

	public String getIdBienImmobilier() {
		return this.idBienImmobilier;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public LocalDate getDateAcquisition() {
		return dateAcquisition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BienImmobilier that = (BienImmobilier) o;
		return codePostal == that.codePostal &&
				Objects.equals(idBienImmobilier, that.idBienImmobilier) &&
				Objects.equals(adresse, that.adresse) &&
				Objects.equals(ville, that.ville) &&
				Objects.equals(dateAcquisition, that.dateAcquisition);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBienImmobilier, adresse, codePostal, ville, dateAcquisition);
	}

	@Override
	public String toString() {
		return "BienImmobilier{" +
				"idBienImmobilier='" + idBienImmobilier + '\'' +
				", adresse='" + adresse + '\'' +
				", codePostal=" + codePostal +
				", ville='" + ville + '\'' +
				", dateAcquisition=" + dateAcquisition +
				'}';
	}

}