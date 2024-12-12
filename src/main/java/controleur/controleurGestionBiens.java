package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import vue.IHMGestionBaux;
import vue.IHMAjouterBail;
import vue.IHMAjouterBien;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;

public class controleurGestionBiens implements ActionListener{

    private IHMGestionBiens vue;
    
    public controleurGestionBiens (IHMGestionBiens vue) {
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "DeclarationFiscale" :
            IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
            vueDeclarationFiscale.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "RegularisationCharges" :
            IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
            vueRegularisationCharges.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "baux" :
            IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
            vueGestionBaux.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "locataires" :
            IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
            vueGestionLocataires.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "Ajout" :
            IHMAjouterBien vueAjouterBien = new IHMAjouterBien();
            vueAjouterBien.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }  
}