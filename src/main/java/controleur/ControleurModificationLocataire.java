package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dao.JDBCLocataire;
import modele.Locataire;
import vue.IHMDeclarationFiscale;
import vue.IHMDetailsLocataire;
import vue.IHMGestionBaux;
import vue.IHMGestionBiens;
import vue.IHMModificationLocataire;
import vue.IHMRegularisationCharges;

public class ControleurModificationLocataire implements ActionListener {

    private final IHMModificationLocataire vue;
    private final Locataire locataire;
    private final JDBCLocataire modele = new JDBCLocataire();

    public ControleurModificationLocataire (IHMModificationLocataire vue, Locataire locataire) {
        this.vue = vue;
		this.locataire = modele.getById(locataire.getIdLocataire()).orElseThrow();
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
                modele.update(this.locataire);
                IHMDetailsLocataire vueDetailsLocataire = new IHMDetailsLocataire(this.locataire);
                this.vue.dispose();
                vueDetailsLocataire.setVisible(true);
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + actionCommand.getActionCommand());
        }
    }
    
    private void remplirChamps() {
		vue.getModifPrenom().setText(locataire.getPrenom());
		vue.getModifNom().setText(locataire.getNom());
		vue.getModifDateNaissance().setDate(locataire.getDateNaissance());
		vue.getModifTelephone().setText(locataire.getTelephone());
		vue.getModifEmail().setText(locataire.getEmail());
    }

}