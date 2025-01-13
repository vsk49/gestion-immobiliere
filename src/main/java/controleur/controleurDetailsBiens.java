package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modele.BienImmobilier;
import modele.BienLouable;
import vue.IHMDetailsBien;
import vue.IHMModificationBien;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMGestionBaux;
import vue.IHMRegularisationCharges;
import vue.IHMDeclarationFiscale;

public class controleurDetailsBiens implements ActionListener {

    private final IHMDetailsBien vue;

    public controleurDetailsBiens (IHMDetailsBien vue, BienImmobilier bien) {
        this.vue = vue;
        BienImmobilier modele = new BienImmobilier();
        BienImmobilier bienAffiche = modele.getBienByNumeroFiscal(bien.getNumeroFiscal());
        afficherInformationsBien(vue, bienAffiche);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getActionCommand()) {
        case "DeclarationFiscale" :
            IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
            vueDeclarationFiscale.setVisible(true);
            this.vue.dispose();
            break;
        case "RegularisationCharges" :
            IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
            vueRegularisationCharges.setVisible(true);
            this.vue.dispose();
            break;
        case "baux" :
			IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
            vueGestionBaux.setVisible(true);
            this.vue.dispose();
            break;
		case "Retour" :
            IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
            vueGestionBiens.setVisible(true);
            this.vue.dispose();
            break;
        case "locataires" :
            IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
            vueGestionLocataires.setVisible(true);
            this.vue.dispose();
            break;
		case "Modifier" :
			IHMModificationBien vueModificationBien = new IHMModificationBien();
            vueModificationBien.setVisible(true);
            this.vue.setVisible(false);
            break;
        }
    }

    private void afficherInformationsBien(IHMDetailsBien vue, BienImmobilier bien) {
        vue.getLabelAdresse().setText("Adresse: " + bien.getAdresse());
        vue.getLabelCodePostal().setText("Code Postal: " + bien.getCodePostal());
        vue.getLabelVille().setText("Ville: " + bien.getVille());
        vue.getLabelEtage().setText("Etage: N/A");
        vue.getLabelTypeBien().setText("Type de bien: " + bien.getClass().getSimpleName());
        vue.getLabelSurface().setText("Surface: " + ((BienLouable) bien).getSurface());
        vue.getLabelNbPieces().setText("Nombre de pièces: " + ((BienLouable) bien).getNbPieces());
        vue.getLabelStatut().setText("Statut: Loué");
    }

}