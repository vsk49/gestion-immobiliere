package modele;

public abstract class Charge {
    private String recuperable;
    private String dateDebut;
    private String dateFin;
    
    public Charge() {
    }

    public abstract double montantTotalDeCharge();

}
