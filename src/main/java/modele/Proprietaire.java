package modele;

public class Proprietaire {  
    
    private String idProprietaire;
    private String MotDePasse;

    public Proprietaire (String idProprietaire, String MotDePasse) {
        this.idProprietaire = idProprietaire;
        this.MotDePasse = MotDePasse;
    }

    public String getIdProprietaire() {
        return this.idProprietaire;
    }

    public String getMotDePasse() {
        return this.MotDePasse;
    }

    public void setIdLocataire(String id) {
        this.idProprietaire = id;
    }

    public void setMotDePasse(String MotDePasse){
        this.MotDePasse = MotDePasse;
    }
    
}
