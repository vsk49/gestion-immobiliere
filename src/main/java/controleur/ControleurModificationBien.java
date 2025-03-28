package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import dao.JDBCBienImmobilier;
import modele.BienImmobilier;
import vue.IHMDetailsBien;
import vue.IHMDeclarationFiscale;
import vue.IHMRegularisationCharges;
import vue.IHMGestionBaux;
import vue.IHMGestionLocataires;
import vue.IHMModificationBien;

public class ControleurModificationBien implements ActionListener {

    private final IHMModificationBien vue;
    private final BienImmobilier bien;

    public ControleurModificationBien (IHMModificationBien vue, BienImmobilier bien) {
        this.vue = vue;
        JDBCBienImmobilier modele = new JDBCBienImmobilier();
        this.bien = modele.getById(bien.getIdBienImmobilier()).orElseThrow();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "Valider" :
        case "Annuler" :
            IHMDetailsBien vueDetailsBien = new IHMDetailsBien(this.bien);
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
