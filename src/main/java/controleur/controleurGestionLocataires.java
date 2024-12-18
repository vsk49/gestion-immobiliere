package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import vue.IHMAjouterLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMDetailsLocataire;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMRegularisationCharges;

public class controleurGestionLocataires extends MouseAdapter implements ActionListener {

    private final IHMGestionLocataires vue;
    private final Locataire modele;
    
    public controleurGestionLocataires(IHMGestionLocataires vue) {
        this.vue = vue;
        this.modele = new Locataire();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Locataire> locataires = this.modele.getAllLocataires();
        JTable table = this.vue.getTableLocataires();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        if (e.getSource() instanceof JComboBox<?> comboBox) {
            String filtre = (String) comboBox.getSelectedItem();
            assert filtre != null;
            locataires = appliquerFiltre(locataires, filtre);
        }

        for (Locataire locataire : locataires) {
            tableModel.addRow(new Object[]{
                    locataire.getIdLocataire(),
                    locataire.getNom(),
                    locataire.getPrenom(),
                    locataire.getEmail()
            });
        }

        if (e.getSource() instanceof JButton source) {
            switch (source.getActionCommand()) {
                case "Ajout" -> {
                    IHMAjouterLocataire vueAjout = new IHMAjouterLocataire();
                    this.vue.dispose();
                    vueAjout.setVisible(true);
                }
                case "biens" -> {
                    IHMGestionBiens vueBiens = new IHMGestionBiens();
                    this.vue.dispose();
                    vueBiens.setVisible(true);
                }
                case "baux" -> {
                    IHMGestionBaux vueBaux = new IHMGestionBaux();
                    this.vue.dispose();
                    vueBaux.setVisible(true);
                }
                case "DeclarationFiscale" -> {
                    IHMDeclarationFiscale vueDeclaration = new IHMDeclarationFiscale();
                    this.vue.dispose();
                    vueDeclaration.setVisible(true);
                }
                case "RegularisationCharges" -> {
                    IHMRegularisationCharges vueRegularisation = new IHMRegularisationCharges();
                    this.vue.dispose();
                    vueRegularisation.setVisible(true);
                }
                case "Chercher" -> {
                    String nom = this.vue.getChampRecherche().getText();
                    List<Locataire> locatairesTrouves = this.modele.getLocatairesByNom(nom);
                    tableModel.setRowCount(0);
                    for (Locataire locataire : locatairesTrouves) {
                        tableModel.addRow(new Object[]{
                            locataire.getIdLocataire(),
                            locataire.getNom(),
                            locataire.getPrenom(),
                            locataire.getEmail()
                        });
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JTable table = (JTable) e.getSource();
            int ligne = table.getSelectedRow();
            if (ligne != -1) {
                String idLocataire = (String) table.getValueAt(ligne, 0);
                Locataire locataire = this.modele.getLocatairesById(idLocataire);
                IHMDetailsLocataire vueDetails = new IHMDetailsLocataire(locataire);
                vueDetails.setVisible(true);
            }
        }
    }

    private List<Locataire> appliquerFiltre(List<Locataire> locataires, String filter) {
        return switch (filter) {
            case "Nationalite: Francaise" -> locataires.stream()
                    .filter(locataire -> locataire.getNationalite().equals("France"))
                    .toList();
            case "Nationalite: Etrangere" -> locataires.stream()
                    .filter(locataire -> !locataire.getNationalite().equals("France"))
                    .toList();
            default -> locataires;
        };
    }

}