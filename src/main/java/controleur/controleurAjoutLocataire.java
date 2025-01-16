package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;

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
                Object[] donnees = this.vue.getInformations();
                // idLocataire = 1ere lettre du prenom + 3 premieres lettres du nom
                this.modele.setIdLocataire((
                        (String) donnees[1]).substring(0, 1).toUpperCase()
                        + ((String) donnees[0]).substring(0, 3).toUpperCase());
                this.modele.setNom((String) donnees[0]);
                this.modele.setPrenom((String) donnees[1]);
                this.modele.setDateNaissance((LocalDate) donnees[2]);
                this.modele.setTelephone((String) donnees[3]);
                this.modele.setEmail((String) donnees[4]);
                this.modele.setDateEntree((LocalDate)donnees[5]);
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
