package controleur;

import java.sql.Connection;
import java.sql.SQLException;

import dao.JDBCConnexion;

public class ConnexionABaseDeDonnee {

    public void seConnecter() throws SQLException {
        // On essaie de récupérer une connexion à partir de l'instance unique de JDBCConnexion
        try {
            // Obtenir la connexion
            Connection connection = JDBCConnexion.getConnexion();
            
            // Si la connexion est réussie, afficher un message de succès
            if (connection != null) {
                System.out.println("Connexion réussie à la base de données !");
            }
        } catch (Exception e) {
            // Gestion d'autres exceptions générales (par exemple, si getConnexion() échoue)
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
    }


    /*
    public static void initialize(String url, String user, String password) throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
}