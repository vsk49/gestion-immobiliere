
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.JDBCLocataire;
import modele.Locataire;
import vue.*;

public class ControleurGestionLocataires extends MouseAdapter implements ActionListener {

    private final IHMGestionLocataires vue;
    private final List<Locataire> allLocataires;

    public ControleurGestionLocataires(IHMGestionLocataires vue, JDBCLocataire modele) {
        this.vue = vue;
        this.allLocataires = modele.getAll();
        this.vue.updateLocataires(this.allLocataires);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton source) {
            gererBoutonsNonMenu(source);
        } else if (e.getSource() instanceof JMenuItem source) {
            gererBoutonsDuMenu(source);
        }
    }

    // gestion des boutons chercher et ajout
    private void gererBoutonsNonMenu(JButton source) {
        switch (source.getActionCommand()) {
            // ouvre la vue d'ajout de locataire
            case "Ajout" -> {
                IHMAjouterLocataire vueAjout = new IHMAjouterLocataire();
                this.vue.dispose();
                vueAjout.setVisible(true);
            }
            case "Chercher" -> {
                // recherche par ID, si vide, affiche tous les locataires
                String id = this.vue.getChampRecherche().getText();
                if (id.isEmpty()) {
                    this.vue.updateLocataires(this.allLocataires);
                } else {
                    try {
                        Locataire locataire = this.allLocataires.stream()
                                .filter(l -> l.getIdLocataire().equals(id))
                                .findFirst()
                                .orElseThrow();
                        this.vue.updateLocataires(List.of(locataire));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(vue, "L'ID n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            case "Detail" -> {
                this.allLocataires.stream()
                .filter(l -> l.getIdLocataire().equals(idLocataire))
                .findFirst()
                .ifPresentOrElse(
                    detailedLocataire -> new IHMDetailsLocataire(detailedLocataire).setVisible(true),
                    () -> JOptionPane.showMessageDialog(vue, "Locataire introuvable", "Erreur", JOptionPane.ERROR_MESSAGE)
                );
            }
            case "Modifier" -> {
                this.allLocataires.stream()
                .filter(l -> l.getIdLocataire().equals(idLocataire))
                .findFirst()
                .ifPresentOrElse(
                    detailedLocataire -> new IHMModificationLocataire(detailedLocataire).setVisible(true),
                    () -> JOptionPane.showMessageDialog(vue, "Locataire introuvable", "Erreur", JOptionPane.ERROR_MESSAGE)
                );
            }
        }
    }

    // gestion des boutons du menu
    private void gererBoutonsDuMenu(JMenuItem source) {
        switch (source.getText()) {
            case "Accueil" -> {
                IHMAccueil vueAccueil = new IHMAccueil();
                this.vue.dispose();
                vueAccueil.setVisible(true);
            }
            case "Mes Locataires" -> {
                IHMGestionLocataires vueLocataires = new IHMGestionLocataires();
                this.vue.dispose();
                vueLocataires.setVisible(true);
            }
            case "Mes Biens" -> {
                IHMGestionBiens vueBiens = new IHMGestionBiens();
                this.vue.dispose();
                vueBiens.setVisible(true);
            }
            case "Mes Baux" -> {
                IHMGestionBaux vueBaux = new IHMGestionBaux();
                this.vue.dispose();
                vueBaux.setVisible(true);
            }
            case "Déclaration Fiscale" -> {
                IHMDeclarationFiscale vueDeclaration = new IHMDeclarationFiscale();
                this.vue.dispose();
                vueDeclaration.setVisible(true);
            }
            case "Régularisation de Charges" -> {
                IHMRegularisationCharges vueRegularisation = new IHMRegularisationCharges();
                this.vue.dispose();
                vueRegularisation.setVisible(true);
            }
            default -> throw new IllegalArgumentException("Action Inconnue : " + source.getActionCommand());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JPanel panel) {
            Locataire locataire = (Locataire) panel.getClientProperty("locataire");
            if (locataire != null) {
                // Retrieve the locataire information from the database
                Locataire detailedLocataire = this.allLocataires.stream()
                        .filter(l -> l.getIdLocataire().equals(locataire.getIdLocataire()))
                        .findFirst()
                        .orElse(null);
                if (detailedLocataire != null) {
                    // Open the new window displaying the locataire information
                    new IHMDetailsLocataire(detailedLocataire).setVisible(true);
                    this.vue.dispose();
                } else {
                    JOptionPane.showMessageDialog(vue, "Locataire not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}