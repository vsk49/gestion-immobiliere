package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Batiment extends BienImmobilier {

	private int nombreEtages;
	private String periodeConstruction;
	private final Map<String, BienImmobilier> biens;

	public Batiment(String idBatiment, String adresse, int codePostal, String ville, int nombreEtages, String periodeConstruction) {
		super(idBatiment, adresse, codePostal, ville, null);
		this.nombreEtages = nombreEtages;
		this.periodeConstruction = periodeConstruction;
		this.biens = new HashMap<>();
	}

	public int getNombreEtages() {
		return this.nombreEtages;
	}

	public void setNombreEtages(int nombreEtages) {
		if (nombreEtages <= 0)
			throw new IllegalArgumentException("Le nombre d'étages doit être supérieur à 0.");
		this.nombreEtages = nombreEtages;
	}

	public String getPeriodeConstruction() {
		return this.periodeConstruction;
	}

	public Map<String, BienImmobilier> getBiensLies() {
		return this.biens;
	}

	public void setPeriodeConstruction(String periodeConstruction) {
		this.periodeConstruction = periodeConstruction;
	}

	public void ajouterBien(BienImmobilier... biens) {
		for (BienImmobilier bien : biens) {
			this.biens.put(bien.getIdBienImmobilier(), bien);
		}
	}

	public void supprimerBien(String idBien) {
		this.biens.remove(idBien);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Batiment batiment)) return false;
		if (!super.equals(o)) return false;
        return nombreEtages == batiment.nombreEtages &&
				Objects.equals(periodeConstruction, batiment.periodeConstruction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), nombreEtages, periodeConstruction);
	}

	@Override
	public String toString() {
		return super.toString() + "Batiment{" +
				"nombreEtages=" + nombreEtages +
				", periodeConstruction='" + periodeConstruction + '\'' +
				", biens=" + biens +
				'}';
	}

}
