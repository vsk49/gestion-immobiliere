package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Genre;
import modele.Locataire;
import vue.IHMAjouterLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMRegularisationCharges;

public class controleurAjoutLocataire implements ActionListener {

    private final IHMAjouterLocataire vue;
    private final Locataire modele;

    public controleurAjoutLocataire(IHMAjouterLocataire vue) {
        this.modele = new Locataire();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton action = (JButton) e.getSource();
        switch (action.getActionCommand()) {
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
            case "biens" :
                IHMGestionBiens vueGestionBiens = new IHMGestionBiens();
                vueGestionBiens.setVisible(true);
                this.vue.dispose();
                break;
            case "baux" :
                IHMGestionBaux vueGestionBaux = new IHMGestionBaux();
                vueGestionBaux.setVisible(true);
                this.vue.dispose();
                break;
            case "Valider" :
                // idLocataire = 1ere lettre du prenom + 3 premieres lettres du nom
                this.modele.setIdLocataire(this.vue.getTextFieldNom().getText().substring(0, 1).toUpperCase()
                        + this.vue.getTextFieldPrenom().getText().substring(0, 3).toUpperCase());
                this.modele.setNom(this.vue.getTextFieldNom().getText());
                this.modele.setPrenom(this.vue.getTextFieldPrenom().getText());
                this.modele.setDateNaissance(this.vue.getDatePickerNaissance().getDate());
                this.modele.setTelephone(this.vue.getTextFieldTelephone().getText());
                this.modele.setEmail(this.vue.getTextFieldEmail().getText());
                this.modele.setDateEntree(this.vue.getDatePickerEntree().getDate());
                this.modele.setLieuNaissance(this.vue.getTextFieldLieuNaissance().getText());
                this.modele.setNationalite(this.vue.getTextFieldNationalite().getText());
                this.modele.setProfession(this.vue.getTextProfession().getText());
                if (this.vue.getRadioButtonHomme().isSelected()) {
                    this.modele.setGenre(Genre.MASCULIN);
                } else {
                    this.modele.setGenre(Genre.FEMININ);
                }
                this.modele.enregistrerLocataire();
                this.vue.dispose();
                IHMGestionLocataires vueGestion = new IHMGestionLocataires();
                vueGestion.setVisible(true);
                break;
            case "Annuler" :
                IHMGestionLocataires vueGestionLoc = new IHMGestionLocataires();
                vueGestionLoc.setVisible(true);
                this.vue.dispose();
        }
    }

}
