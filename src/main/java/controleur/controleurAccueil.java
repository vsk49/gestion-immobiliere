package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.IHMAccueil;
import vue.IHMAjouterBien;
import vue.IHMAjouterLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMRegularisationCharges;

public class controleurAccueil implements ActionListener {
	
	private IHMAccueil vue;
	
	public controleurAccueil (IHMAccueil vue) {
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        switch (actionCommand.getText()) {
        case "Ajouter un locataire" :
			IHMAjouterLocataire vueAjouterLocataire = new IHMAjouterLocataire();
			vueAjouterLocataire.setVisible(true);
			this.vue.setVisible(false);
			break;
        case "Ajouter un bien" :
			IHMAjouterBien vueAjouterBien = new IHMAjouterBien();
			vueAjouterBien.setVisible(true);
			this.vue.setVisible(false);
			break;
        case "Ajouter un bail" :
		//	IHMAjouterBail vueAjouterBail = new IHMAjouterBail();
		//	vueAjouterBail.setVisible(true);
		//	this.vue.setVisible(false);
			break;
        case "Consulter les locataires" :
			IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
			vueGestionLocataires.setVisible(true);
			this.vue.setVisible(false);
			break;
        case "Consulter les biens" :
			IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
			vueGestionBiens.setVisible(true);
			this.vue.setVisible(false);
			break;
        case "Consulter les baux" :
			IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
			vueGestionBaux.setVisible(true);
			this.vue.setVisible(false);
			break;
        case "Déclaration fiscale" :
			IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
			vueDeclarationFiscale.setVisible(true);
			this.vue.setVisible(false);
			break;
        case "Finances" :
			IHMRegularisationCharges vueRegularisationCharges = new IHMRegularisationCharges();
			vueRegularisationCharges.setVisible(true);
			this.vue.setVisible(false);
		}
		
	}
}
