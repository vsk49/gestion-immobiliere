package modele;

import java.time.LocalDate;

public class Assurance {

	private int idAssurance;
	private TypeAssurance typeAssurance;
	private String nomAssureur;
	private LocalDate dateDebutAssurance;
	private double quotiteJurisprudence;
	private double protectionJuridique;
	private double prime;
	private BienImmobilier bien;

	public Assurance(int idAssurance, TypeAssurance typeAssurance, String nomAssureur, LocalDate dateDebutAssurance,
			double quotiteJurisprudence, double protectionJuridique, double prime, BienImmobilier bien) {
		this.idAssurance = idAssurance;
		this.typeAssurance = typeAssurance;
		this.prime = prime;
		this.dateDebutAssurance = dateDebutAssurance;
		this.nomAssureur = nomAssureur;
		this.quotiteJurisprudence = quotiteJurisprudence;
		this.protectionJuridique = protectionJuridique;
		this.bien = bien;
	}

	public int getIdAssurance() {
		return this.idAssurance;
	}
	
	public TypeAssurance getTypeAssurance() {
		return typeAssurance;
	}

	public String getNomAssureur() {
		return nomAssureur;
	}

	public LocalDate getDateDebutAssurance() {
		return dateDebutAssurance;
	}

	public double getQuotiteJurisprudence() {
		return quotiteJurisprudence;
	}

	public double getProtectionJuridique() {
		return protectionJuridique;
	}

	public double getPrime() {
		return prime;
	}

	public BienImmobilier getBien() {
		return bien;
	}
   
}
