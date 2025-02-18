package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Batiment extends BienImmobilier {

	private final int nombreEtages;
	private String periodeConstruction;
	private final Map<String, BienImmobilier> biens;

	public Batiment(String adresse, int codePostal, String ville, int nombreEtages, String periodeConstruction) {
		super(null, adresse, codePostal, ville, null);
		this.nombreEtages = nombreEtages;
		this.periodeConstruction = periodeConstruction;
		this.biens = new HashMap<>();
	}

	public int getNombreEtages() {
		return this.nombreEtages;
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
	public int hashCode() {
		return Objects.hash(super.hashCode(), nombreEtages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Batiment other))
			return false;
		return super.equals(obj) && nombreEtages == other.nombreEtages;
	}

}
