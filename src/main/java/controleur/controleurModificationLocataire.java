package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

import modele.Locataire;
import vue.IHMDeclarationFiscale;
import vue.IHMDetailsLocataire;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMModificationLocataire;
import vue.IHMRegularisationCharges;

public class controleurModificationLocataire implements ActionListener {

    private IHMModificationLocataire vue;
    private Locataire locataire;
    private Locataire locModifie;

    public controleurModificationLocataire (IHMModificationLocataire vue, Locataire locataire) {
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
            case "Reinitialiser" :
                this.vue.getModifPrenom().setText(locataire.getPrenom());
                vue.getModifNom().setText(locataire.getNom());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                String dateStr = locataire.getDateNaissance().format(formatter);
                vue.getModifDateNaissance().setText(dateStr);
                vue.getModifTelephone().setText(locataire.getTelephone());
                vue.getModifEmail().setText(locataire.getEmail());
                break;
            case "Annuler" :
                IHMDetailsLocataire vueDetailLocataire = new IHMDetailsLocataire(this.locataire);
                this.vue.dispose();
                vueDetailLocataire.setVisible(true);
                break;
            case "Valider" :
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                LocalDate dateNaissance = LocalDate.parse(this.vue.getModifDateNaissance().getText(), formatter2);
                this.locataire.setNom(this.vue.getModifNom().getText());
                this.locataire.setPrenom(this.vue.getModifPrenom().getText());
                this.locataire.setDateNaissance(dateNaissance);
                this.locataire.setEmail(this.vue.getModifEmail().getText());
                this.locataire.setTelephone(this.vue.getModifTelephone().getText());
                this.locataire.mettreAJourLocataire();
                IHMDetailsLocataire vueDetailLocataireModif = new IHMDetailsLocataire(this.locataire);
                vueDetailLocataireModif.setVisible(true);
                this.vue.dispose();
        }
    }
    
}