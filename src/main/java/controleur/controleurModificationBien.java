package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import vue.IHMDetailsBien;
import vue.IHMConnexion;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBaux;
import vue.IHMGestionLocataires;
import vue.IHMInscription;
import vue.IHMModificationBien;

public class controleurModificationBien implements ActionListener{

    private IHMModificationBien vue;

    public controleurModificationBien (IHMModificationBien vue) {
        this.vue = vue;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Valider" :
        case "Annuler" :
            IHMDetailsBien vueDetailsBien = new IHMDetailsBien();
            vueDetailsBien.setVisible(true);
            this.vue.setVisible(false);
            break;
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
        }
    }
    
}
