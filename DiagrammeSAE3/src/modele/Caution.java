package modele;

public class Caution {
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String nationalite;
    private String adresse;
    private String codePostal;
    private String ville;
    private String profession;
    private String employeur;
    private double revenusMensuelsNets;
    private String typeContratTravail;
    private String anciennete;
    private String lienLocataire;
    private String duree;
    private String dateSignature;
    private double montantCautionne;

    public Caution(String nom, String prenom, String dateNaissance, String lieuNaissance, String nationalite, String adresse, String codePostal, String ville, String profession, String employeur, String revenusMensuelsNets, String typeContratTravail, String anciennete, String lienLocataire, String duree, String dateSignature, double montantCautionne) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.codePostal  =codePostal;
        this.ville = ville;
        this.profession = profession;
        this.employeur = employeur
    }

}
