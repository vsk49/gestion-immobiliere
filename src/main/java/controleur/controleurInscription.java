package controleur;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    
    import javax.swing.JButton;
    
    import vue.IHMConnexion;
    import vue.IHMInscription;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.JDBCConnexion;

public class controleurInscription implements ActionListener {

    private IHMInscription vue;
    
    public controleurInscription (IHMInscription vue) {
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Valider" :
            String identifiant = vue.getIdentifiant();
            String motDePasse = vue.getMotDePasse();

            if (identifiant.isEmpty() || motDePasse.isEmpty()) {
                vue.afficherMessageErreur("Les champs identifiant et mot de passe ne doivent pas être vides.");
                return;
            }

            if (ajouterUtilisateur(identifiant, motDePasse)) {
                vue.afficherMessageSucces("Inscription réussie !");
                IHMConnexion vueConnexion = new IHMConnexion();
                vueConnexion.setVisible(true);
                vue.dispose(); // Fermer la fenêtre après succès
            } else {
                vue.afficherMessageErreur("Échec de l'inscription. L'utilisateur existe déjà ou une erreur est survenue.");
            }
            break;
        case "Annuler" :
            IHMConnexion vueConnexion = new IHMConnexion();
            vueConnexion.setVisible(true);
            vue.dispose(); // Fermer la fenêtre après succès
            break;
        }
    }

    private boolean ajouterUtilisateur(String identifiant, String motDePasse) {
         try (Connection connection = JDBCConnexion.getConnexion();
         Statement statement = connection.createStatement()) {

        // Vérifier si l'utilisateur existe déjà
        String checkUserSQL = "SELECT COUNT(*) AS count FROM ALL_USERS WHERE USERNAME = UPPER('" + identifiant + "')";
        try (ResultSet resultSet = statement.executeQuery(checkUserSQL)) {
            if (resultSet.next() && resultSet.getInt("count") > 0) {
                System.err.println("L'utilisateur existe déjà.");
                vue.afficherMessageErreur("L'utilisateur '" + identifiant + "' existe déjà dans la base de données.");
                return false; // Arrêter ici si l'utilisateur existe déjà
            }
        }

        // Commande SQL pour créer un utilisateur
        String createUserSQL = "CREATE USER " + identifiant + " IDENTIFIED BY \"" + motDePasse + "\"";

        // Exécuter la commande
        statement.executeUpdate(createUserSQL);

        // Ajouter des privilèges basiques à l'utilisateur
        String grantPrivilegesSQL = "GRANT CONNECT, RESOURCE TO " + identifiant;
        statement.executeUpdate(grantPrivilegesSQL);

        System.out.println("Utilisateur créé et privilèges accordés.");
        return true;

        } catch (SQLException ex) {
            System.err.println("Erreur lors de la création de l'utilisateur : " + ex.getMessage());
            return false;
        }
    } 
}