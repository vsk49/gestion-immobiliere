package modele;

public class Loyer {
    
    private String dateLoyer;
    private double montantLoyer;
    private double provisionPourCharge;
    private int idLoyer;
    private BienLouable bienLouable;
    private Locataire locataire;

    public Loyer() {
    }

    public int getIdLoyer() {
        return this.idLoyer;
    }

    public void setIdLoyer(final int value) {
        this.idLoyer = value;
    }

}
