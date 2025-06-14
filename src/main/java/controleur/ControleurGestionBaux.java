package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



import vue.IHMGestionBaux;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;

public class ControleurGestionBaux implements ActionListener{

    private final IHMGestionBaux vue;
    
    public ControleurGestionBaux(IHMGestionBaux vue) {
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
//        case "Ajout" :
//            IHMAjouterBail vueAjouterBail = new IHMAjouterBail();
//            vueAjouterBail.setVisible(true);
//            this.vue.setVisible(false);
//            break;
        }
    }
    
}
