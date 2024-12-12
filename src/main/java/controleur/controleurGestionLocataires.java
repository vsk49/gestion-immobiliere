package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import vue.IHMGestionBaux;
import vue.IHMAjouterBail;
import vue.IHMAjouterLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;

public class controleurGestionLocataires implements ActionListener{

    private IHMGestionLocataires vue;
    
    public controleurGestionLocataires (IHMGestionLocataires vue) {
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
        case "biens" :
            IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
            vueGestionBiens.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "Ajout" :
            IHMAjouterLocataire vueAjouterLocataire = new IHMAjouterLocataire();
            vueAjouterLocataire.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }
}
