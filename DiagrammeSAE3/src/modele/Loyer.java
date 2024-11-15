package modele;

public class Loyer {
    
    private int idLoyer;
    private LocalDate dateLoyer;
    private double montantLoyer;
    private double provisionPourCharge;
    private BienLouable bienLouable;
    private Locataire locataire;

    public Loyer(LocalDate dateLoyer, double montantLoyer, double provisionPourCharge, int idLoyer, BienLouable bienLouable, Locataire locataire) {
        this.dateLoyer = dateLoyer;
        this.montantLoyer = montantLoyer;
        this.provisionPourCharge = provisionPourCharge
        this.idLoyer = idLoyer;
        this?bienLouable = bienLouable;
        this.locataire = locataire;
    }

    public int getIdLoyer() {
        return this.idLoyer;
    }
}
