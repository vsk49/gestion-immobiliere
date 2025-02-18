package modele;

import java.time.LocalDate;
import java.util.Objects;

public class BienImmobilier {

	private String idBienImmobilier;
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

	public void setIdBienImmobilier(String idBienImmobilier) {
		this.idBienImmobilier = idBienImmobilier;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, codePostal, dateAcquisition, idBienImmobilier, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof BienImmobilier other))
			return false;
        return Objects.equals(adresse, other.adresse) && codePostal == other.codePostal
				&& Objects.equals(dateAcquisition, other.dateAcquisition)
				&& Objects.equals(idBienImmobilier, other.idBienImmobilier) && Objects.equals(ville, other.ville);
	}

}