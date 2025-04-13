package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

import modele.*;
import vue.*;

public class ControleurModificationBien implements ActionListener {

    private final IHMModificationBien vue;
    private final BienImmobilier bien;
    private final Map<String, GestionnaireEvenement> gestionnaires = new HashMap<>();

    public ControleurModificationBien(IHMModificationBien vue, BienImmobilier bien) {
        this.vue = vue;
        JDBCBienImmobilier modele = new JDBCBienImmobilier();
        this.bien = modele.getById(bien.getIdBienImmobilier()).orElseThrow();
        remplirChamps();
        initialiserActions();
    }

    private void initialiserActions() {
        gestionnaires.put("Valider", new ValiderHandler());
        gestionnaires.put("Annuler", new AnnulerHandler());
        gestionnaires.put("Reinitialiser", new ReinitialiserHandler());
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
        JDBCLocation location = new JDBCLocation();
        vue.getTextFieldAdresse().setText(bien.getAdresse());
        vue.getTextFieldVille().setText(bien.getVille());
        vue.getTextFieldCodePostal().setText(String.valueOf(bien.getCodePostal()));
        if (bien instanceof Logement logement) {
            vue.getTextFieldTypeBien().setText("Logement");
            vue.getTextFieldSurface().setText(String.valueOf(logement.getSurfaceHabitable()));
            vue.getTextFieldNbPieces().setText(String.valueOf(logement.getNbPieces()));
            vue.getTextFieldStatut().setText(location.isLoue(bien.getIdBienImmobilier()) ? "Loué" : "Disponible");
        } else if (bien instanceof Batiment batiment) {
            vue.getTextFieldTypeBien().setText("Batiment");
            vue.getTextFieldEtage().setText(String.valueOf(batiment.getNombreEtages()));
        }
    }

    private interface GestionnaireEvenement {
        void gererAction();
    }

    private class ValiderHandler implements GestionnaireEvenement {
        @Override
        public void gererAction() {
            bien.setAdresse(vue.getTextFieldAdresse().getText());
            bien.setCodePostal(Integer.parseInt(vue.getTextFieldCodePostal().getText()));
            bien.setVille(vue.getTextFieldVille().getText());
            if (bien instanceof Logement logement) {
                logement.setSurfaceHabitable(Double.parseDouble(vue.getTextFieldSurface().getText()));
                logement.setNbPieces(Integer.parseInt(vue.getTextFieldNbPieces().getText()));
            } else if (bien instanceof Batiment batiment) {
                batiment.setNombreEtages(Integer.parseInt(vue.getTextFieldEtage().getText()));
            }
            JDBCBienImmobilier modele = new JDBCBienImmobilier();
            modele.update(bien);
            IHMDetailsBien vueDetailsBien = new IHMDetailsBien(bien);
            vueDetailsBien.setVisible(true);
            vue.dispose();
        }
    }

    private class AnnulerHandler implements GestionnaireEvenement {
        @Override
        public void gererAction() {
            IHMDetailsBien vueDetailsBien = new IHMDetailsBien(bien);
            vueDetailsBien.setVisible(true);
            vue.dispose();
        }
    }

    private class ReinitialiserHandler implements GestionnaireEvenement {
        @Override
        public void gererAction() {
            remplirChamps();
        }
    }

}