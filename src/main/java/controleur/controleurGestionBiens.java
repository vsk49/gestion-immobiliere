package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modele.BienImmobilier;
import modele.Locataire;
import vue.*;

public class controleurGestionBiens extends MouseAdapter implements ActionListener {

    private final IHMGestionBiens vue;
    private final BienImmobilier modele;

    public controleurGestionBiens (IHMGestionBiens vue) {
        this.vue = vue;
        this.modele = new BienImmobilier();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JTable table = (JTable) e.getSource();
            int ligne = table.getSelectedRow();
            if (ligne != -1) {
                String numeroFiscal = (String) table.getValueAt(ligne, 1);
                BienImmobilier bien = this.modele.getBienByNumeroFiscal(numeroFiscal);
                IHMDetailsBien vueDetails = new IHMDetailsBien(bien);
                vueDetails.setVisible(true);
                this.vue.dispose();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<BienImmobilier> biens = this.modele.getBiens();
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
                    bien.getNumeroFiscal(),
                    bien.getAdresse(),
                    bien.getCodePostal(),
                    bien.getVille()
            });
        }

        if (e.getSource() instanceof JButton actionCommand) {
            switch (actionCommand.getActionCommand()) {
                case "DeclarationFiscale":
                    IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
                    vueDeclarationFiscale.setVisible(true);
                    this.vue.setVisible(false);
                    break;
                case "RegularisationCharges":
                    IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
                    vueRegularisationCharges.setVisible(true);
                    this.vue.setVisible(false);
                    break;
                case "baux":
                    IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
                    vueGestionBaux.setVisible(true);
                    this.vue.setVisible(false);
                    break;
                case "locataires":
                    IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
                    vueGestionLocataires.setVisible(true);
                    this.vue.setVisible(false);
                    break;
                case "Ajout":
                    IHMAjouterBien vueAjouterBien = new IHMAjouterBien();
                    vueAjouterBien.setVisible(true);
                    this.vue.setVisible(false);
                    break;
                case "Chercher":
                    String numeroFiscal = this.vue.getChampRecherche().getText();
                    BienImmobilier bien = this.modele.getBienByNumeroFiscal(numeroFiscal);
                    if (bien != null) {
                        tableModel.setRowCount(0);
                        tableModel.addRow(new Object[]{
                                bien.getIdBienImmobilier(),
                                bien.getNumeroFiscal(),
                                bien.getAdresse(),
                                bien.getCodePostal(),
                                bien.getVille()
                        });
                    } else {
                        JOptionPane.showMessageDialog(this.vue, "Aucun bien immobilier trouvé avec le numéro fiscal " + numeroFiscal);
                    }
                    break;
            }
        }
    }

    private List<BienImmobilier> appliquerFiltre(List<BienImmobilier> biens, String filter) {
        return switch (filter) {
            case "Batiment" -> biens.stream().filter(b -> b.getNumeroFiscal() == null).toList();
            case "Logement", "Garage" -> biens.stream().filter(b -> b.getNumeroFiscal() != null).toList();
            default -> biens;
        };
    }

}