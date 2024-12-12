package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import vue.IHMDetailsBail;
import vue.IHMConnexion;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMInscription;
import vue.IHMModificationBail;

public class controleurModificationBail implements ActionListener{

    private IHMModificationBail vue;

    public controleurModificationBail (IHMModificationBail vue) {
        this.vue = vue;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Annuler" :
        case "Valider" :
            IHMDetailsBail vueDetailsBail = new IHMDetailsBail();
            vueDetailsBail.setVisible(true);
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
        case "biens" :
            IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
            vueGestionBiens.setVisible(true);
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
