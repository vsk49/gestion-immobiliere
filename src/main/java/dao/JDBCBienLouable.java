package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import modele.BienImmobilier;
import modele.BienLouable;

public class JDBCBienLouable extends JDBCBienImmobilier implements DAOBienLouable {

    public boolean insert(BienLouable bien) {
        boolean resultat = super.insert(bien);
        if (resultat) {
            try {
                String insertion = "INSERT INTO BIENLOUABLE (IDBIENLOUABLE, NBPIECES, idBienImmobilier) VALUES (?, ?, ?)";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
                statement.setInt(1, bien.getIdBienImmobilier());
                statement.setInt(2, bien.getNbPieces());
                statement.setInt(3, bien.getIdBienImmobilier());
                statement.executeUpdate();
                System.out.println("Le batiment a été inséré");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode() + " : " + e.getMessage());
                resultat = false;
            }
        }
        return resultat;
    }

    @Override
    public Optional<BienImmobilier> getById(Integer id) {
        Optional<BienImmobilier> bien = Optional.empty();
        try {
            String requete = "SELECT * FROM BIENLOUABLE WHERE IDBIENLOUABLE = ?";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
            statement.setInt(1, id);
            ResultSet resultat = statement.executeQuery();
            if (resultat.next()) {
                BienLouable b = (BienLouable) super.getById(resultat.getInt("idBienImmobilier")).orElse(null);
                assert b != null;
                bien = Optional.of(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
        return bien;
    }

    public boolean delete(BienLouable bien) {
        boolean resultat = super.delete(bien);
        if (resultat) {
            try {
                String suppression = "DELETE FROM BIENLOUABLE WHERE IDBIENLOUABLE = ?";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
                statement.setInt(1, bien.getIdBienImmobilier());
                statement.executeUpdate();
                System.out.println("Le batiment a été supprimé");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode() + " : " + e.getMessage());
                resultat = false;
            }
        }
        return resultat;
    }

}
