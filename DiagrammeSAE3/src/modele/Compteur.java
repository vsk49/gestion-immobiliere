package modele;

import java.time.LocalDate;

public class Compteur {
    
    private int numero;
    private TypeCompteur type;
    private double indexActuel;
    private double indexAncien;
    private LocalDate dateReleveEntree;
    
    public Compteur(int numero, TypeCompteur type, double indexActuel, double indexAncien, LocalDate dateReleveEntree) {
        this.numero = numero;
        this.type = type;
        this.indexActuel = indexActuel;
        this.indexAncien = indexAncien;
        this.dateReleveEntree = dateReleveEntree;
    }

    public double getAncienIndex() {
        return this.indexAncien;
    }

    public int getNumeroCompteur() {
        return this.numero;
    }

    public void setIndexActuel(double indexActuel){
        this.indexActuel = indexActuel;
    }

}
