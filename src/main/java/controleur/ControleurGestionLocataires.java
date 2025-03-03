package controleur;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import dao.JDBCLocataire;
import modele.Locataire;
import vue.*;

public class ControleurGestionLocataires extends MouseAdapter implements ActionListener {

    private final IHMGestionLocataires vue;
    private final List<Locataire> allLocataires = new JDBCLocataire().getAll();

    public ControleurGestionLocataires(IHMGestionLocataires vue) {
        this.vue = vue;
        this.vue.updateLocataires(this.allLocataires);
        addMouseListenersToLocataires();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JPanel panel = (JPanel) e.getSource();
            Locataire locataire = (Locataire) panel.getClientProperty("locataire");
            handleDoubleClick(locataire);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton source) {
            gererBoutonsNonMenu(source);
        } else {
            gererBoutonsDuMenu((JMenuItem) e.getSource());
        }
    }

    public void handleDoubleClick(Locataire locataire) {
        IHMDetailsLocataire vueDetails = new IHMDetailsLocataire(locataire);
        vueDetails.setVisible(true);
        vue.dispose();
    }

    private void gererBoutonsNonMenu(JButton source) {
        switch (source.getActionCommand()) {
            case "Ajout" -> {
                IHMAjouterLocataire vueAjout = new IHMAjouterLocataire();
                this.vue.dispose();
                vueAjout.setVisible(true);
            }
            case "Chercher" -> {
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
                addMouseListenersToLocataires();
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

    private void addMouseListenersToLocataires() {
        for (Component component : vue.getPanelLocataires().getComponents()) {
            if (component instanceof JPanel panel) {
                panel.addMouseListener(this);
            }
        }
    }

}