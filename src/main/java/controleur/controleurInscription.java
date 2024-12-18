package controleur;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    
    import javax.swing.JButton;
    
    import vue.IHMConnexion;
    import vue.IHMInscription;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    import dao.JDBCConnexion;

public class controleurInscription implements ActionListener {

    private IHMInscription vue;
    
    public controleurInscription (IHMInscription vue) {
        this.vue = vue;
    }

    public void inscrireUtilisateur(String identifiant, String motDePasse) {
        Connection connection = null;

        try {
            // Obtenir la connexion partagée
            connection = JDBCConnexion.getConnexion();

            if (connection == null) {
                System.err.println("Aucune connexion disponible à la base de données.");
                return;
            }

            String query = "INSERT INTO utilisateurs (identifiant, motdepasse) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // Définir les valeurs des paramètres
                statement.setString(1, identifiant);
                statement.setString(2, motDePasse);

                // Exécuter la requête
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Utilisateur ajouté avec succès !");
                    vue.afficherMessage("Inscription réussie !");
                } else {
                    System.err.println("Échec de l'ajout de l'utilisateur.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            vue.afficherMessageErreur("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    // Méthode appelée lorsque le bouton "Valider" est cliqué
    public void handleBoutonValider() {
        String identifiant = vue.getIdentifiant(); // Méthode pour récupérer le texte du champ identifiant
        String motDePasse = vue.getMotDePasse(); // Méthode pour récupérer le texte du champ mot de passe

        // Validation de base
        if (identifiant.isEmpty() || motDePasse.isEmpty()) {
            vue.afficherMessageErreur("Les champs ne peuvent pas être vides !");
            return;
        }

        // Inscrire l'utilisateur
        inscrireUtilisateur(identifiant, motDePasse);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Annuler" :
            IHMConnexion vueConnexion = new IHMConnexion();
            vueConnexion.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "Valider" :
            String identifiant = vue.getIdentifiant(); // Récupère l'identifiant depuis le champ texte
            String motDePasse = vue.getMotDePasse();  // Récupère le mot de passe depuis le champ texte
            if (identifiant.isEmpty() || motDePasse.isEmpty()) {
                vue.afficherMessageErreur("Les champs identifiant et mot de passe doivent être remplis.");
                return;
            }
            inscrireUtilisateur(identifiant, motDePasse);
        }
    }
} 
