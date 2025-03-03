package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import dao.JDBCLocataire;
import modele.Locataire;
import vue.IHMDetailsLocataire;
import vue.IHMModificationLocataire;

public class ControleurModificationLocataire implements ActionListener {

    private final IHMModificationLocataire vue;
    private final Locataire locataire;
    private final JDBCLocataire modele = new JDBCLocataire();
    private final Map<String, GestionnaireEvenement> gestionnaires = new HashMap<>();

    public ControleurModificationLocataire(IHMModificationLocataire vue, Locataire locataire) {
        this.vue = vue;
        this.locataire = modele.getById(locataire.getIdLocataire()).orElseThrow();
        this.remplirChamps();
        initialiserActions();
    }

    private void initialiserActions() {
        gestionnaires.put("Reinitialiser", new ReinitialiserHandler());
        gestionnaires.put("Annuler", new AnnulerHandler());
        gestionnaires.put("Valider", new ValiderHandler());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionCommand = (JButton) e.getSource();
        GestionnaireEvenement handler = gestionnaires.get(actionCommand.getActionCommand());
        if (handler != null) {
            handler.gererAction();
        }
    }

    private void remplirChamps() {
        vue.getModifPrenom().setText(locataire.getPrenom());
        vue.getModifNom().setText(locataire.getNom());
        vue.getModifDateNaissance().setDate(locataire.getDateNaissance());
        vue.getModifTelephone().setText(locataire.getTelephone());
        vue.getModifEmail().setText(locataire.getEmail());
    }

    private interface GestionnaireEvenement {
        void gererAction();
    }

    private class ReinitialiserHandler implements GestionnaireEvenement {
        @Override
        public void gererAction() {
            remplirChamps();
        }
    }

    private class AnnulerHandler implements GestionnaireEvenement {
        @Override
        public void gererAction() {
            IHMDetailsLocataire vueDetailLocataire = new IHMDetailsLocataire(locataire);
            vue.dispose();
            vueDetailLocataire.setVisible(true);
        }
    }

    private class ValiderHandler implements GestionnaireEvenement {
        @Override
        public void gererAction() {
            locataire.setNom(vue.getModifNom().getText());
            locataire.setPrenom(vue.getModifPrenom().getText());
            locataire.setDateNaissance(vue.getModifDateNaissance().getDate());
            locataire.setEmail(vue.getModifEmail().getText());
            locataire.setTelephone(vue.getModifTelephone().getText());
            modele.update(locataire);
            IHMDetailsLocataire vueDetailsLocataire = new IHMDetailsLocataire(locataire);
            vue.dispose();
            vueDetailsLocataire.setVisible(true);
        }
    }

}