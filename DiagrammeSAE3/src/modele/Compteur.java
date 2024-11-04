package modele;

import java.time.LocalDate;

public class Compteur {
    
    private String Type;
    private String numero;
    private String indexActuel;
    private LocalDate dateReleveEntree;
    private String indexAncien;
    private int idCompteur;
    
    public Compteur(String numero) {
    }

    public int getAncienIndex() {
        return 0;
    }

    public int getIdCompteur() {
        return this.idCompteur;
    }

}
