package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

import modele.Locataire;
import vue.*;

public class controleurModificationLocataire implements ActionListener {

    private final IHMModificationLocataire vue;
    private final Locataire locataire;

    public controleurModificationLocataire (IHMModificationLocataire vue, Locataire locataire) {
        this.vue = vue;
        Locataire modele = new Locataire();
		this.locataire = modele.getLocatairesById(locataire.getIdLocataire());
        this.remplirChamps();
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
            case "biens" :
                IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
                vueGestionBiens.setVisible(true);
                this.vue.dispose();
                break;
            case "Reinitialiser" :
                this.remplirChamps();
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
                IHMGestionLocataires vueGestionLocataires = new IHMGestionLocataires();
                this.vue.dispose();
                vueGestionLocataires.setVisible(true);
        }
    }
    
    private void remplirChamps() {
		this.vue.getModifPrenom().setText(locataire.getPrenom());
		vue.getModifNom().setText(locataire.getNom());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String dateStr = locataire.getDateNaissance().format(formatter);
		vue.getModifDateNaissance().setText(dateStr);
		vue.getModifTelephone().setText(locataire.getTelephone());
		vue.getModifEmail().setText(locataire.getEmail());
    }

}