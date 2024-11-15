package modele;

public class Logement extends BienLouable {

    public Logement(double surface, int nbPieces, Compteur compteur, String adresse, String numeroFiscal, String codePostal, String ville, double montantTaxesFoncieres, LocalDate dateAnniversaire, double ICCDateDebut, int idBienImmobilier) {
        super(surface, nbPieces, compteur, adresse, numeroFiscal, codePostal, ville, montantTaxesFoncieres, dateAnniversaire, ICCDateDebut, idBienImmobilier);
    }

    public boolean estEnColocation() {
        return false;
    }

    public String getDateDepartLocataire(String id) {
        return null;
    }

    public double getQuotiteLocataire(String id) {
        return 0;
    }

}
