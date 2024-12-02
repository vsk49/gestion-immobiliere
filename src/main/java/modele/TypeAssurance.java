package modele;

public enum TypeAssurance {
	PROPRIETAIRE("proprietaire"), AIDE_JURIDIQUE("aideJuridique");

	private final String denomination;

	TypeAssurance(String denomination) {
		this.denomination = denomination;
	}

	public String getDenomination() {
		return denomination;
	}

}