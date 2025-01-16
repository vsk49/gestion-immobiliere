package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import modele.BienImmobilier;
import modele.BienLouable;

public class JDBCBienLouable extends JDBCBienImmobilier {

    @Override
    public boolean insert(BienImmobilier bienLouable) {
        boolean resultat = super.insert(bienLouable);
        if (resultat) {
            try {
                // insertion dans la table BienLouable
                String insertion = "INSERT INTO BIENLOUABLE (IDBIENLOUABLE, SURFACE, NBPIECES, idBienImmobilier) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
                statement.setInt(1, bienLouable.getIdBienImmobilier());
                statement.setDouble(2, ((BienLouable) bienLouable).getSurface());
                statement.setInt(3, ((BienLouable) bienLouable).getNbPieces());
                statement.setInt(4, bienLouable.getIdBienImmobilier());
                statement.executeUpdate();
                System.out.println("Le batiment a été inséré");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode() + " : " + e.getMessage());
            }
        }
        return resultat;
    }

    @Override
    public Optional<BienImmobilier> getById(Integer id) {
        Optional<BienImmobilier> bien = Optional.empty();
        try {
            // chercher les donnees dans la table Batiment
            String requeteBienLouable = "SELECT * FROM BIENLOUABLE WHERE IDBIENLOUABLE = ?";
            PreparedStatement statementBienLouable = JDBCConnexion.getConnexion().prepareStatement(requeteBienLouable);
            statementBienLouable.setInt(1, id);
            ResultSet resultatBienLouable = statementBienLouable.executeQuery();

            if (resultatBienLouable.next()) {
                // garder idBienImmobilier selon le resultat
                int idBienImmobilier = resultatBienLouable.getInt("idBienImmobilier");

                // chercher dans la table BienImmobilier en utilisant la clef etrangere idBienImmobilier
                BienLouable bienTrouve = (BienLouable) super.getById(idBienImmobilier).orElseThrow();

                // remettre les proprietes de BienLouable
                bienTrouve.setNbPieces(resultatBienLouable.getInt("NBPIECES"));
                bienTrouve.setSurface(resultatBienLouable.getInt("SURFACE"));

                bien = Optional.of(bienTrouve);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
        return bien;
    }

    @Override
    public boolean delete(BienImmobilier bienLouable) {
        boolean resultat = false;
        try {
            // suppression dans la table Batiment
            String suppression = "DELETE FROM BIENLOUABLE WHERE IDBIENLOUABLE = ?";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
            statement.setInt(1, bienLouable.getIdBienImmobilier());
            statement.executeUpdate();

            // suppression dans la table BienImmobilier
            resultat = super.delete(bienLouable);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    @Override
    public boolean update(BienImmobilier bienLouable) {
        boolean resultat = super.update(bienLouable);
        if (resultat) {
            try {
                // mise a jour dans la table BienLouable
                String misAJour = "UPDATE BIENLOUABLE SET SURFACE = ?, NBPIECES = ? WHERE IDBIENLOUABLE = ?";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
                statement.setDouble(1, ((BienLouable) bienLouable).getSurface());
                statement.setInt(2, ((BienLouable) bienLouable).getNbPieces());
                statement.setInt(3, bienLouable.getIdBienImmobilier());
                statement.executeUpdate();
                System.out.println("Le bien louable a ete mis a jour.");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode() + " : " + e.getMessage());
            }
        }
        return resultat;
    }

    @Override
    public Optional<BienImmobilier> getByNumeroFiscal(String numeroFiscal) {
        Optional<BienImmobilier> bien = Optional.empty();
        try {
            BienImmobilier b = super.getByNumeroFiscal(numeroFiscal).orElseThrow();
            if (b instanceof BienLouable bienLouable) {
                String requete = "SELECT * FROM BIENLOUABLE WHERE IDBIENIMMOBILIER = ?";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
                statement.setInt(1, bienLouable.getIdBienImmobilier());
                ResultSet resultat = statement.executeQuery();
                if (resultat.next()) {
                    bienLouable.setNbPieces(resultat.getInt("NBPIECES"));
                    bienLouable.setSurface(resultat.getDouble("SURFACE"));
                    bien = Optional.of(bienLouable);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
        return bien;
    }

}
