package modele;
import java.util.ArrayList;
import java.util.List;

public class BienLouable extends BienImmobilier {
    private double surface;
    private int nbPieces;
    private List<FactureTravail> travaux = new ArrayList<FactureTravail> ();
    private Compteur compteur;

    public BienLouable(double surface, int nbPieces, List<FactureTravail> travaux, Compteur compteur) {
        this.surface = surface;
        this.nbPieces = nbPieces;
        this.travaux = travaux;
        this.compteur = compteur;
    }

    public void addTravail (FactureTravail travail){
        this.travaux.add(travail);
    }

    public double getSurface(){
        return this.surface;
    }

    public int getNbPièces (){
        return this.nbPieces;
    }

    public List<FactureTravail> getTravaux(){
        return this.travaux;
    }

    public Compteur getCompteur(){
        return this.compteur;
    }

    public void changerCompteur(Compteur nvCompteur) {
        this.compteur.setCpt(nvCompteur);
    }

}
