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

	public Diagnostic(String reference, LocalDate dateRealisation, String type, LocalDate dateExpiration, String classification, String operateur, String numeroRapport, BienImmobilier bien) {
		this.reference = reference;
		this.dateRealisation = dateRealisation;
		this.type = type;
		this.dateExpiration = dateExpiration;
		this.classification = classification;
		this.operateur = operateur;
		this.numeroRapport = numeroRapport;
		this.bien = bien;
	}

}
