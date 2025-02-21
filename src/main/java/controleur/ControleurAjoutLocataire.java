package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dao.JDBCLocataire;
import modele.Locataire;
import vue.IHMAjouterLocataire;
import vue.IHMDeclarationFiscale;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMGestionLocataires;
import vue.IHMRegularisationCharges;

public class ControleurAjoutLocataire implements ActionListener {

    private final IHMAjouterLocataire vue;
    private final JDBCLocataire modele;

    public ControleurAjoutLocataire(IHMAjouterLocataire vue) {
        this.modele = new JDBCLocataire();
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
                Locataire l = construireLocataireSelonLesChamps();
                this.modele.insert(l);
                this.vue.dispose();
                IHMGestionLocataires vueGestion = new IHMGestionLocataires();
                vueGestion.setVisible(true);
                break;
            case "Annuler" :
                IHMGestionLocataires vueGestionLoc = new IHMGestionLocataires();
                vueGestionLoc.setVisible(true);
                this.vue.dispose();
                break;
            default :
                throw new IllegalArgumentException("Unexpected value: " + action.getActionCommand());
        }
    }

    private Locataire construireLocataireSelonLesChamps() {
        String idLocataire = this.vue.getTextFieldNom().getText().substring(0, 1).toUpperCase()
                + this.vue.getTextFieldPrenom().getText().substring(0, 3).toUpperCase();
        return new Locataire(idLocataire, this.vue.getTextFieldNom().getText(),
                this.vue.getTextFieldPrenom().getText(), this.vue.getDatePickerNaissance().getDate(),
                this.vue.getTextFieldEmail().getText(), this.vue.getTextFieldTelephone().getText());
    }

}
