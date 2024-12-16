package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import vue.IHMGestionLocataires;

public class controleurGestionLocataires implements ActionListener{

    private enum Etat {
        DEBUT_SESSION, AJOUT, LOCATAIRE_TROUVE, FIN_SESSION
    }

    private Etat etat;
    private IHMGestionLocataires vue;
    private final Locataire modele;
    
    public controleurGestionLocataires (IHMGestionLocataires vue) {
        this.vue = vue;
        this.modele = new Locataire();
        this.etat = Etat.DEBUT_SESSION;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (this.etat) {
            case DEBUT_SESSION :
                List<Locataire> locataires = this.modele.getAllLocataires();
                JTable table = this.vue.getTableLocataires();
                for (Locataire locataire : locataires) {
                    ((DefaultTableModel) table.getModel()).addRow(new Object[] {
                            locataire.getIdLocataire(), locataire.getNom(), locataire.getPrenom()});
                }
                break;
            case AJOUT :
                break;
            case LOCATAIRE_TROUVE :
                break;
            case FIN_SESSION :
                this.vue.dispose();
        }
//        switch (actionCommand.getActionCommand()) {
//        case "DeclarationFiscale" :
//            IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
//            vueDeclarationFiscale.setVisible(true);
//            this.vue.setVisible(false);
//            break;
//        case "RegularisationCharges" :
//            IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
//            vueRegularisationCharges.setVisible(true);
//            this.vue.setVisible(false);
//            break;
//        case "baux" :
//            IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
//            vueGestionBaux.setVisible(true);
//            this.vue.setVisible(false);
//            break;
//        case "biens" :
//            IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
//            vueGestionBiens.setVisible(true);
//            this.vue.setVisible(false);
//            break;
//        case "Ajout" :
//            IHMAjouterLocataire vueAjouterLocataire = new IHMAjouterLocataire();
//            vueAjouterLocataire.setVisible(true);
//            this.vue.setVisible(false);
//            break;
//        }
    }
}
