package modele;

public class Assurance {
    private TypeAssurance type;
    private double prime;
    private String dateDebutAssurance;
    private String nomAssureur;
    private double quotiteJurisprudence;
    private double protectionJuridique;

    public Assurance(TypeAssurance t, double prime, String dateDeb, String nom, double quotite, double pj) {
        this.type = t;
        this.prime = prime;
        this.dateDebutAssurance = dateDeb;
        this.nomAssureur = nom;
        this.quotiteJurisprudence = quotite;
        this.protectionJuridique = pj;
    }

    public TypeAssurance getType(){
        return this.type;
    }

    public double getPrime(){
        return this.prime;
    }

    public String getDateDebut(){
        return this.dateDebutAssurance;
    }

    public String getNomAssureur(){
        return this.nomAssureur;
    }

    public double getQuotite() {
        return this.quotiteJurisprudence;
    }

    public double getProtectionJuridique () {
        return this.protectionJuridique;
    }
}