package modele;

import dao.JDBCProprietaire;

public class Proprietaire {  
    
    private String idProprietaire;
    private String MotDePasse;
    private final JDBCProprietaire bd = new JDBCProprietaire();

    public Proprietaire() {}

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

    // partie DAO
    public Proprietaire getProprietaireByCredentials(String id, String mdp) {
        return this.bd.getByCredentials(id, mdp).orElse(null);
    } 

    public boolean enregistrerProprietaire() {
        return this.bd.insert(this);
    }
    
}
