package modele;

public class Garage extends BienLouable {
    
    private Logement logement;

    public Garage(Logement logement, double surface, int nbPieces, Compteur compteur, String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres, LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier) {
        this.logement = logement;
        super (surface, nbPieces, compteur, adresse, numeroFiscal, codePostal, ville, montantTaxesFoncieres, dateAnniversaire, ICCDateDebut, idBienImmobilier);
    }

}
