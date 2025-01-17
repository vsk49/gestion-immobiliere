package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Genre;
import modele.Locataire;
import vue.IHMDeclarationFiscale;
import vue.IHMDetailsLocataire;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMModificationLocataire;
import vue.IHMRegularisationCharges;

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
                this.locataire.setNom(this.vue.getModifNom().getText());
                this.locataire.setPrenom(this.vue.getModifPrenom().getText());
                this.locataire.setDateNaissance(this.vue.getModifDateNaissance().getDate());
                this.locataire.setEmail(this.vue.getModifEmail().getText());
                this.locataire.setTelephone(this.vue.getModifTelephone().getText());
                this.locataire.setDateEntree(this.vue.getModifDateEntree().getDate());
                this.locataire.setLieuNaissance(this.vue.getModifLieuNaissance().getText());
                this.locataire.setNationalite(this.vue.getModifNationalite().getText());
                this.locataire.setProfession(this.vue.getModifProfession().getText());
                if (this.vue.getModifHomme().isSelected()) {
                    this.locataire.setGenre(Genre.MASCULIN);
                } else {
                    this.locataire.setGenre(Genre.FEMININ);
                }
                this.locataire.mettreAJourLocataire();
                IHMDetailsLocataire vueDetailsLocataire = new IHMDetailsLocataire(this.locataire);
                this.vue.dispose();
                vueDetailsLocataire.setVisible(true);
        }
    }
    
    private void remplirChamps() {
		this.vue.getModifPrenom().setText(locataire.getPrenom());
		vue.getModifNom().setText(locataire.getNom());
		vue.getModifDateNaissance().setDate(locataire.getDateNaissance());
		vue.getModifTelephone().setText(locataire.getTelephone());
		vue.getModifEmail().setText(locataire.getEmail());
        vue.getModifDateEntree().setDate(locataire.getDateEntree());
        vue.getModifLieuNaissance().setText(locataire.getLieuNaissance());
        vue.getModifNationalite().setText(locataire.getNationalite());
        vue.getModifProfession().setText(locataire.getProfession());
        if (locataire.getGenre().getLibelle().equals("M")) {
            vue.getModifHomme().setSelected(true);
        } else {
            vue.getModifFemme().setSelected(true);
        }
    }

}