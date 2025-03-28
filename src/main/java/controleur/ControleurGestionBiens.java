package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.JDBCBienImmobilier;
import modele.Batiment;
import modele.BienImmobilier;
import modele.Logement;
import vue.IHMAjouterBien;
import vue.IHMDeclarationFiscale;
import vue.IHMDetailsBien;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMRegularisationCharges;

public class ControleurGestionBiens extends MouseAdapter implements ActionListener {

    private final IHMGestionBiens vue;
    private final JDBCBienImmobilier modele;

    public ControleurGestionBiens (IHMGestionBiens vue) {
        this.vue = vue;
        this.modele = new JDBCBienImmobilier();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JTable table = (JTable) e.getSource();
            int ligne = table.getSelectedRow();
            if (ligne != -1) {
                String numeroFiscal = (String) table.getValueAt(ligne, 1);
                System.out.println("Numero fiscal : "+ numeroFiscal); // Débogage manuel
                if (numeroFiscal == null) {
                    BienImmobilier bien = this.modele.getById(String.valueOf(ligne + 1)).orElseThrow();
                    if (bien instanceof Batiment batiment) {
                        IHMDetailsBien vueDetails = new IHMDetailsBien(batiment);
                        vueDetails.setVisible(true);
                        this.vue.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this.vue, "L'objet sélectionné n'est pas un Batiment.");
                    }
                } else {
                    BienImmobilier bien = this.modele.getById(numeroFiscal).orElseThrow();
                    if (bien instanceof Logement logement) {
                        IHMDetailsBien vueDetails = new IHMDetailsBien(logement);
                        vueDetails.setVisible(true);
                        this.vue.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this.vue, "L'objet sélectionné n'est pas un Logement.");
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
                    bien.getDateAcquisition().toString()
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
                    BienImmobilier bien = this.modele.getById(numeroFiscal).orElseThrow();
                    tableModel.setRowCount(0);
                    tableModel.addRow(new Object[]{
                            bien.getIdBienImmobilier(),
                            bien.getAdresse(),
                            bien.getCodePostal(),
                            bien.getVille(),
                            bien.getDateAcquisition().toString()
                    });
                    break;
            }
        }
    }

    private List<BienImmobilier> appliquerFiltre(List<BienImmobilier> biens, String filter) {
        return switch (filter) {
            case "Batiment" -> biens.stream().filter(b -> b.getIdBienImmobilier() == null).toList();
            case "Logement", "Garage" -> biens.stream().filter(b -> b.getIdBienImmobilier() != null).toList();
            default -> biens;
        };
    }

}