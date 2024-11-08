package modele;

import java.time.LocalDate;

public class Assurance {
    
	private int idAssurance;
    private TypeAssurance type;
    private double prime;
    private LocalDate dateDebutAssurance;
    private String nomAssureur;
    private double quotiteJurisprudence;
    private double protectionJuridique;

    public Assurance(int idAssurance, TypeAssurance type, double prime, LocalDate dateDebutAssurance, String nomAssureur, double quotiteJurisprudence, double protectionJuridique) {
        this.idAssurance = idAssurance;
        this.type = type;
        this.prime = prime;
        this.dateDebutAssurance = dateDebutAssurance;
        this.nomAssureur = nomAssureur;
        this.quotiteJurisprudence = quotiteJurisprudence;
        this.protectionJuridique = protectionJuridique;
    }

    public int getIdAssurance() {
        return this.idAssurance;
    }

}
