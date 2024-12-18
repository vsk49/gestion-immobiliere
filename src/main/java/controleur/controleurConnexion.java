package controleur;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dao.JDBCConnexion;
import vue.IHMAccueil;
    import vue.IHMConnexion;
    import vue.IHMInscription;

public class controleurConnexion implements ActionListener{

    private IHMConnexion vue;
    
    public controleurConnexion (IHMConnexion vue) {
        this.vue = vue;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Inscription" :
            IHMInscription vueInscription = new IHMInscription();
            vueInscription.setVisible(true);
            this.vue.dispose();
            break;
        case "Valider" :
            String identifiant = vue.getIdentifiant();
            String motDePasse = vue.getMotDePasse();
            
            if (identifiant.isEmpty() || motDePasse.isEmpty()) {
                vue.afficherMessageErreur("Les champs identifiant et mot de passe ne doivent pas être vides.");
                return;
            }
            if (connecterALaBaseDeDonnees(identifiant, motDePasse)) {
                    JOptionPane.showMessageDialog(vue, "Connexion réussie à la base de données !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    IHMAccueil vueAccueil = new IHMAccueil();
                    vueAccueil.setVisible(true);
                    vue.dispose();
                } else {
                    vue.afficherMessageErreur("Échec de la connexion. Veuillez vérifier vos informations.");
                }
            break;
        case "Annuler" :
            this.vue.dispose();
            break;
        }
    }

    private boolean connecterALaBaseDeDonnees(String identifiant, String motDePasse) {
        try {
            // On initialise la connexion via la classe JDBCConnexion
            Connection connection = JDBCConnexion.getConnexion();

            // Valider les informations d'identifiant et de mot de passe
            // Adapter cette logique si un système de table d'utilisateurs est mis en place
            if (connection != null && identifiant.equals("SAE3A01") && motDePasse.equals("$iutinfo")) {
                return true; // Connexion réussie
            } else {
                System.out.println("Échec de l'authentification : identifiant ou mot de passe incorrect.");
            }
        } catch (Exception ex) {
            System.err.println("Erreur de connexion à la base de données : " + ex.getMessage());
        }

        return false; // Connexion échouée
    } 
}  
