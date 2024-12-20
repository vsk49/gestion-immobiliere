package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import modele.Locataire;
import vue.IHMDeclarationFiscale;
import vue.IHMDetailsLocataire;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMModificationLocataire;
import vue.IHMRegularisationCharges;

public class controleurDetailsLocataire implements ActionListener {

	private final IHMDetailsLocataire vue;
	private final Locataire locataire;
	
	public controleurDetailsLocataire (IHMDetailsLocataire vue, Locataire locataire) {
		this.vue = vue;
		this.locataire = locataire;
		this.vue.getModifPrenom().setText(locataire.getPrenom());
		vue.getModifNom().setText(locataire.getNom());
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String dateStr = locataire.getDateNaissance().format(formatter);
		vue.getModifDateNaissance().setText(dateStr);
		vue.getModifTelephone().setText(locataire.getTelephone());
		vue.getModifEmail().setText(locataire.getEmail());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
        switch (actionCommand) {
			case "declarationFiscale" :
				IHMDeclarationFiscale vueDeclarationFiscale = new IHMDeclarationFiscale();
				vueDeclarationFiscale.setVisible(true);
				this.vue.setVisible(false);
				break;
			case "finances" :
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
				this.vue.setVisible(false);
				vueGestionBiens.setVisible(true);
				break;
			case "Retour" :
				IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
				this.vue.dispose();
				vueGestionLocataires.setVisible(true);
				break;
			case "Modifier" :
				IHMModificationLocataire vueModificationLocataire = new IHMModificationLocataire(this.locataire);
				vueModificationLocataire.setVisible(true);
				this.vue.setVisible(false);
        }
	}

}
