package controleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

import modele.JDBCLocataire;
import modele.Locataire;
import vue.*;

public class ControleurGestionLocataires extends MouseAdapter implements ActionListener {

    private final IHMGestionLocataires vue;
    private final List<Locataire> allLocataires = new JDBCLocataire().getAll();
    private final Map<String, ActionItemMenu> menuActions = new HashMap<>();

    public ControleurGestionLocataires(IHMGestionLocataires vue) {
        this.vue = vue;
        this.vue.updateLocataires(this.allLocataires);
        addMouseListenersToLocataires();
        initializeMenuActions();
    }

    private void initializeMenuActions() {
        menuActions.put("Accueil", new AccueilAction());
        menuActions.put("Mes Locataires", new MesLocatairesAction());
        menuActions.put("Mes Biens", new MesBiensAction());
        menuActions.put("Mes Baux", new MesBauxAction());
        menuActions.put("Déclaration Fiscale", new DeclarationFiscaleAction());
        menuActions.put("Régularisation de Charges", new RegularisationChargesAction());
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

    private void handleDoubleClick(Locataire locataire) {
        IHMDetailsLocataire vueDetails = new IHMDetailsLocataire(locataire);
        vueDetails.setVisible(true);
        vue.dispose();
    }

    private void gererBoutonsNonMenu(JButton source) {
        if (source.getActionCommand().equals("Chercher")) {
            String id = this.vue.getChampRecherche().getText();
            if (!id.isEmpty()) {
                try {
                    Locataire locataire = this.allLocataires.stream()
                            .filter(l -> l.getIdLocataire().equals(id))
                            .findFirst()
                            .orElseThrow();
                    this.vue.updateLocataires(List.of(locataire));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vue, "L'ID n'existe pas", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                this.vue.updateLocataires(this.allLocataires);
            }
            addMouseListenersToLocataires();
        } else {
            IHMAjouterLocataire vueAjout = new IHMAjouterLocataire();
            this.vue.dispose();
            vueAjout.setVisible(true);
        }
    }

    private void gererBoutonsDuMenu(JMenuItem source) {
        ActionItemMenu action = menuActions.get(source.getText());
        if (action != null) {
            action.gererEvenement();
        } else {
            throw new IllegalArgumentException("Action Inconnue : " + source.getText());
        }
    }

    // Ajoute un MouseListener à chaque locataire
    private void addMouseListenersToLocataires() {
        for (Component component : vue.getPanelLocataires().getComponents()) {
            if (component instanceof JPanel panel) {
                panel.addMouseListener(this);
            }
        }
    }

    // Inner interface for menu actions
    private interface ActionItemMenu {
        void gererEvenement();
    }

    // Inner classes for each menu action
    private class AccueilAction implements ActionItemMenu {
        @Override
        public void gererEvenement() {
            IHMAccueil vueAccueil = new IHMAccueil();
            vue.dispose();
            vueAccueil.setVisible(true);
        }
    }

    private class MesLocatairesAction implements ActionItemMenu {
        @Override
        public void gererEvenement() {
            IHMGestionLocataires vueLocataires = new IHMGestionLocataires();
            vue.dispose();
            vueLocataires.setVisible(true);
        }
    }

    private class MesBiensAction implements ActionItemMenu {
        @Override
        public void gererEvenement() {
            IHMGestionBiens vueBiens = new IHMGestionBiens();
            vue.dispose();
            vueBiens.setVisible(true);
        }
    }

    private class MesBauxAction implements ActionItemMenu {
        @Override
        public void gererEvenement() {
            IHMGestionBaux vueBaux = new IHMGestionBaux();
            vue.dispose();
            vueBaux.setVisible(true);
        }
    }

    private class DeclarationFiscaleAction implements ActionItemMenu {
        @Override
        public void gererEvenement() {
            IHMDeclarationFiscale vueDeclaration = new IHMDeclarationFiscale();
            vue.dispose();
            vueDeclaration.setVisible(true);
        }
    }

    private class RegularisationChargesAction implements ActionItemMenu {
        @Override
        public void gererEvenement() {
            IHMRegularisationCharges vueRegularisation = new IHMRegularisationCharges();
            vue.dispose();
            vueRegularisation.setVisible(true);
        }
    }

}