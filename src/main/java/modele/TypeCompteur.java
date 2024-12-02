package modele;

public enum TypeCompteur {

	EAU("eau"), ELECTRICITE("electricite");

	private final String denomination;

	TypeCompteur(String denomination) {
		this.denomination = denomination;
	}

	public String getDenomination() {
		return denomination;
	}
	
}