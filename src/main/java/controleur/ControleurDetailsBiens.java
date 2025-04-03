package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modele.JDBCBienImmobilier;
import modele.BienImmobilier;
import modele.Logement;
import vue.IHMDetailsBien;
import vue.IHMModificationBien;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMGestionBaux;
import vue.IHMRegularisationCharges;
import vue.IHMDeclarationFiscale;

public class ControleurDetailsBiens implements ActionListener {

    private final IHMDetailsBien vue;
    private final BienImmobilier bien;

    public ControleurDetailsBiens (IHMDetailsBien vue, BienImmobilier bien) {
        this.vue = vue;
        JDBCBienImmobilier modele = new JDBCBienImmobilier();
        this.bien = modele.getById(bien.getIdBienImmobilier()).orElseThrow();
        afficherInformationsBien(vue, this.bien);
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
			IHMModificationBien vueModificationBien = new IHMModificationBien(this.bien);
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
        if (bien instanceof Logement) {
            vue.getLabelTypeBien().setText("Type de bien: " + bien.getClass().getName());
            vue.getLabelSurface().setText("Surface: " + ((Logement) bien).getSurfaceHabitable());
            vue.getLabelNbPieces().setText("Nombre de pièces: " + ((Logement) bien).getNbPieces());
        }
        vue.getLabelStatut().setText("Statut: Loué");
    }

}