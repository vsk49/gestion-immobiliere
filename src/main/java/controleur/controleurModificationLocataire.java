package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import vue.IHMDetailsLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMModificationLocataire;

public class controleurModificationLocataire implements ActionListener{

    private IHMModificationLocataire vue;

    public controleurModificationLocataire (IHMModificationLocataire vue) {
        this.vue = vue;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Valider" :
        case "Annuler" :
            IHMDetailsLocataire vueDetailsLocataire = new IHMDetailsLocataire();
            vueDetailsLocataire.setVisible(true);
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
        case "biens" :
            IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
            vueGestionBiens.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }
    
}