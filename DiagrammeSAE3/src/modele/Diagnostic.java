package modele;

import java.time.LocalDate;

public class Diagnostic {

	private String reference;
	private LocalDate dateRealisation;
	private String type;
	private LocalDate dateExpiration;
	private String classification;
	private String operateur;
	private String numeroRapport;
	private BienImmobilier bien;

	public Diagnostic() {
	}

}
