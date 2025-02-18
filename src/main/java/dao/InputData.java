package dao;

import java.time.LocalDate;

import modele.*;

public class InputData {

    private static final JDBCLocataire donneesLocataires = new JDBCLocataire();
    private static final JDBCProprietaire donneesProprietaire = new JDBCProprietaire();
    private static final JDBCBienImmobilier donneesBienImmobilier = new JDBCBienImmobilier();
    private static final String VILLE = "Toulouse";

    private static final Locataire[] locataires = {
            new Locataire("YPOU", "Poux--Bories", "Yoan", LocalDate.of(2002, 2, 10),
                    "yoan.poux@gmail.com", "06 12 34 56 78"),
            new Locataire("VKOH", "Koh", "Virgil Shaun", LocalDate.of(2004, 4, 9),
                    "virgilskoh@gmail.com" , "06 11 16 22 42"),
            new Locataire("EDEH", "Deher", "Enzo", LocalDate.of(2004, 5, 6),
                    "enzo.deher@gmail.com", "06 98 76 54 32"),
            new Locataire("RMIE", "Miegemolle", "Romain", LocalDate.of(2004, 6, 7),
                    "romain.miegemolle@gmail.com", "06 13 24 58 91")
    };

    private static final Proprietaire[] proprietaire = {
            new Proprietaire("SAE3A01", "$iutinfo")
    };

    private static final BienImmobilier[] biens = {
            new Logement("3101234567890", "40 rue des Lilas", 31000,
                    VILLE, LocalDate.of(2020, 2, 2), 2, 18.00, 2),
            new Batiment("90 boulevard du 6 juin 1944",31000, VILLE,4,"2 ans"),
            new Logement("3198765432100", "10 rue des Princes", 31000,
                    VILLE, LocalDate.of(2020, 4, 4), 3, 18.00, 2),
            new Logement("3101234567891", "41 rue des Lilas", 31000,
                    VILLE, LocalDate.of(2020, 5, 5), 1, 22.00, 3),
            new Garage("90 boulevard du 6 juin 1944", 31000, VILLE, LocalDate.of(2020, 6, 6))
    };

    public static void main(String[] args) {
        supprimerDonnees();
        insererDonnees();
        JDBCConnexion.closeConnexion();
    }

    private static void insererDonnees() {
        for (Locataire locataire : locataires) {
            donneesLocataires.insert(locataire);
        }
        for (Proprietaire proprietaire : proprietaire) {
            donneesProprietaire.insert(proprietaire);
        }
        for (BienImmobilier bien : biens) {
            donneesBienImmobilier.insert(bien);
        }
    }

    private static void supprimerDonnees() {
        for (Locataire locataire : locataires) {
            donneesLocataires.delete(locataire);
        }
        for (Proprietaire proprietaire : proprietaire) {
            donneesProprietaire.delete(proprietaire);
        }
        for (BienImmobilier bien : biens) {
            donneesBienImmobilier.delete(bien);
        }
    }

}
