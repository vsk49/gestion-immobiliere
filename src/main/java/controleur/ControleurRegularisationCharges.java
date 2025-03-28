package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.IHMAccueil;
import vue.IHMDeclarationFiscale;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMRegularisationCharges;

public class ControleurRegularisationCharges implements ActionListener {

    private final IHMRegularisationCharges vue;

    public ControleurRegularisationCharges (IHMRegularisationCharges vue){
        this.vue = vue;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
        case "locataires" :
			IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
			vueGestionLocataires.setVisible(true);
			this.vue.setVisible(false);
            break;
        case "biens" :
            IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
            vueGestionBiens.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "baux" :
            IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
            vueGestionBaux.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "declarations fiscales" :
            IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
            vueDeclarationFiscale.setVisible(true);
            this.vue.setVisible(false);
            break;
        case "Valider" :
            IHMAccueil vueAccueil = new IHMAccueil();
            vueAccueil.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }
}