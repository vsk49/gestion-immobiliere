package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modele.JDBCBienImmobilier;
import modele.BienImmobilier;
import vue.*;

public class ControleurGestionBiens extends MouseAdapter implements ActionListener {

    private final IHMGestionBiens vue;
    private final JDBCBienImmobilier modele;
    private final Map<String, ActionItemMenu> menuActions = new HashMap<>();

    public ControleurGestionBiens (IHMGestionBiens vue) {
        this.vue = vue;
        this.modele = new JDBCBienImmobilier();
        initializeMenuActions();
        // initialize the table with all properties
        List<BienImmobilier> biens = this.modele.getAll();
        JTable tableBiens = this.vue.getTableBiens();
        DefaultTableModel tableModel = (DefaultTableModel) tableBiens.getModel();
        tableModel.setRowCount(0);
        for (BienImmobilier bien : biens) {
            tableModel.addRow(new Object[]{
                    bien.getIdBienImmobilier(),
                    bien.getAdresse(),
                    bien.getCodePostal(),
                    bien.getVille(),
                    // checking the date acquisition
                    (bien.getDateAcquisition() != null) ? bien.getDateAcquisition().toString() : "N/A"
            });
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JTable table = (JTable) e.getSource();
            int ligne = table.getSelectedRow();
            if (ligne != -1) {
                String idBienImmobilier = (String) table.getValueAt(ligne, 0);
                BienImmobilier bien = this.modele.getById(idBienImmobilier).orElseThrow();
                IHMDetailsBien vueDetails = new IHMDetailsBien(bien);
                vueDetails.setVisible(true);
                this.vue.dispose();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            gererBoutonsNonMenu(e, (DefaultTableModel) this.vue.getTableBiens().getModel());
        } else if (e.getSource() instanceof JMenuItem menuItem) {
            ActionItemMenu action = menuActions.get(menuItem.getText());
            action.gererEvenement();
        } else {
            gererAffichageBiens(e);
        }
    }

    private void initializeMenuActions() {
        menuActions.put("Accueil", new AccueilAction());
        menuActions.put("Mes Locataires", new MesLocatairesAction());
        menuActions.put("Mes Biens", new MesBiensAction());
        menuActions.put("Mes Baux", new MesBauxAction());
        menuActions.put("Déclaration Fiscale", new DeclarationFiscaleAction());
        menuActions.put("Régularisation de Charges", new RegularisationChargesAction());
    }

    private void gererBoutonsNonMenu(ActionEvent e, DefaultTableModel tableModel) {
        if (e.getSource() instanceof JButton actionCommand) {
            if (actionCommand.getActionCommand().equals("Ajout")) {
                IHMAjouterBien vueAjouterBien = new IHMAjouterBien();
                this.vue.setVisible(false);
                vueAjouterBien.setVisible(true);
            } else {
                String numeroFiscal = this.vue.getChampRecherche().getText();
                BienImmobilier bien = this.modele.getById(numeroFiscal).orElseThrow();
                tableModel.setRowCount(0);
                tableModel.addRow(new Object[]{
                        bien.getIdBienImmobilier(),
                        bien.getAdresse(),
                        bien.getCodePostal(),
                        bien.getVille(),
                        // checking the date acquisition
                        (bien.getDateAcquisition() != null) ? bien.getDateAcquisition().toString() : "N/A"
                });
            }
        }
    }

    private void gererAffichageBiens(ActionEvent e) {
        List<BienImmobilier> biens = this.modele.getAll();
        JTable tableBiens = this.vue.getTableBiens();
        DefaultTableModel tableModel = (DefaultTableModel) tableBiens.getModel();
        tableModel.setRowCount(0);
        if (e.getSource() instanceof JComboBox<?> comboBox) {
            String filtre = (String) comboBox.getSelectedItem();
            assert filtre != null;
            biens = appliquerFiltre(biens, filtre);
        }
        for (BienImmobilier bien : biens) {
            tableModel.addRow(new Object[]{
                    bien.getIdBienImmobilier(),
                    bien.getAdresse(),
                    bien.getCodePostal(),
                    bien.getVille(),
                    // checking the date acquisition
                    (bien.getDateAcquisition() != null) ? bien.getDateAcquisition().toString() : "N/A"
            });
        }
    }

    private List<BienImmobilier> appliquerFiltre(List<BienImmobilier> biens, String filter) {
        return switch (filter) {
            case "Batiment" -> biens.stream().filter(b -> b.getDateAcquisition() == null).toList();
            case "Garage" -> biens.stream()
                    .filter(b -> b.getIdBienImmobilier().length() < 13 && b.getDateAcquisition() != null)
                    .toList();
            case "Logement" -> biens.stream().filter(b -> b.getIdBienImmobilier().length() == 13).toList();
            default -> biens;
        };
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