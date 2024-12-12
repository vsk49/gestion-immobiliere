package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import vue.IHMDetailsBail;
import vue.IHMModificationBail;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMGestionBaux;
import vue.IHMRegularisationCharges;
import vue.IHMDeclarationFiscale;

public class controleurDetailsBail implements ActionListener{

    private IHMDetailsBail vue;
    
    public void controleurDetailsBien (IHMDetailsBail vue) {
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
        case "Retour" :
			IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
            vueGestionBaux.setVisible(true);
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
		case "Modifier" :
			IHMModificationBail vueModificationBien = new IHMModificationBail();
            vueModificationBien.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }
    
}