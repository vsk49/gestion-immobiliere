package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import vue.IHMDetailsBien;
import vue.IHMModificationBien;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMGestionBaux;
import vue.IHMRegularisationCharges;
import vue.IHMDeclarationFiscale;

public class controleurDetailsBiens implements ActionListener{

    private IHMDetailsBien vue;
    
    public void controleurDetailsBien (IHMDetailsBien vue) {
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
		case "Retour" :
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
			IHMModificationBien vueModificationBien = new IHMModificationBien();
            vueModificationBien.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }
    
}