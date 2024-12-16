package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;


import modele.Genre;
import modele.Locataire;
import vue.IHMDetailsLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMModificationLocataire;

public class controleurModificationLocataire implements ActionListener {

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
            Locataire l = new Locataire("DUDU", "Dupont", "Francois", Genre.MASCULIN,
                    LocalDate.of(1990, 5, 13), "Toulouse", "Francais",
                    "Enseignant", "0123456789", "francois.dupont@gmail.com",
                    null, null, 1.0);
            IHMDetailsLocataire vueDetailsLocataire = new IHMDetailsLocataire(l);
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