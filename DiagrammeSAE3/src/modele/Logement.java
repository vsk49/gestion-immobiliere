package modele;

public class Logement extends BienLouable {
    
    private Garage garage;

    public boolean estEnColocation() {
        return false;
    }

    public Logement() {
    }

    public String getDateDepartLocataire(String id) {
        return null;
    }

    public double getQuotiteLocataire(String id) {
        return 0;
    }

}
