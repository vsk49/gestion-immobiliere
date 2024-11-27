package modele;

import java.time.LocalDate;

public class Diagnostic {

	private int idDiagnostic;
	private String reference;
	private LocalDate dateRealisation;
	private String type;
	private LocalDate dateExpiration;
	private String classification;
	private String operateur;
	private String numeroRapport;
	private BienImmobilier bien;

	public Diagnostic(int idDiagnostic, String reference, LocalDate dateRealisation, String type,
			LocalDate dateExpiration, String classification, String operateur, String numeroRapport,
			BienImmobilier bien) {
		this.idDiagnostic = idDiagnostic;
		this.reference = reference;
		this.dateRealisation = dateRealisation;
		this.type = type;
		this.dateExpiration = dateExpiration;
		this.classification = classification;
		this.operateur = operateur;
		this.numeroRapport = numeroRapport;
		this.bien = bien;
	}

	public int getIdDiagnostic(){
		return this.idDiagnostic;
	}
	
	public String getReference(){
		return this.reference;
	}

	public LocalDate getDateRealisation(){
		return this.dateRealisation;
	}

	public String getType(){
		return this.type;
	}

	public LocalDate getDateExpiraion(){
		return this.dateExpiration;
	}

	public String getClassification(){
		return this.classification;
	}

	public String getOperateur(){
		return this.operateur;
	}

	public String getNumeroRapport(){
		return this.numeroRapport;
	}

	public BienImmobilier getBien(){
		return this.bien;
	}
}
