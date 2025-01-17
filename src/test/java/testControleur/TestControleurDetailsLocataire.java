package testControleur;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

import modele.Genre;
import org.junit.Before;
import org.junit.Test;

import controleur.controleurDetailsLocataire;
import modele.Locataire;
import vue.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestControleurDetailsLocataire {

    private IHMDetailsLocataire vue;
    private Locataire locataire;
    private controleurDetailsLocataire controleur;

    @Before
    public void setUp() {
        // Create real instances of the classes
        locataire = new Locataire("YPOU", "Doe", "John", Genre.MASCULIN,
                LocalDate.of(1990, 1, 1), "Paris", "French",
                "Engineer", "1234567890", "john.doe@example.com",
                LocalDate.of(2020, 1, 1), null, 1.0);
        vue = new IHMDetailsLocataire(locataire);

        // Set up the state of the vue instance
        vue.getModifPrenom().setText(locataire.getPrenom());
        vue.getModifNom().setText(locataire.getNom());
        vue.getModifDateNaissance().setText(locataire.getDateNaissance().toString());
        vue.getModifTelephone().setText(locataire.getTelephone());
        vue.getModifEmail().setText(locataire.getEmail());
        vue.getModifDateEntree().setText(locataire.getDateEntree().toString());
        vue.getModifGenre().setText(locataire.getGenre().getLibelle());
        vue.getModifLieuNaissance().setText(locataire.getLieuNaissance());
        vue.getModifNationalite().setText(locataire.getNationalite());
        vue.getModifProfession().setText(locataire.getProfession());

        // Create the controller instance
        controleur = new controleurDetailsLocataire(vue, locataire);
    }

    @Test
    public void testActionPerformed_declarationFiscale() {
        ActionEvent event = new ActionEvent(vue, ActionEvent.ACTION_PERFORMED, "declarationFiscale");
        controleur.actionPerformed(event);
        // Verify the expected behavior
        assertFalse(vue.isActive());
        assertTrue(new IHMDeclarationFiscale().isVisible());
    }

    @Test
    public void testActionPerformed_finances() {
        ActionEvent event = new ActionEvent(vue, ActionEvent.ACTION_PERFORMED, "finances");
        controleur.actionPerformed(event);
        // Verify the expected behavior
        assertFalse(vue.isActive());
        assertTrue(new IHMRegularisationCharges().isVisible());
    }

    @Test
    public void testActionPerformed_baux() {
        ActionEvent event = new ActionEvent(vue, ActionEvent.ACTION_PERFORMED, "baux");
        controleur.actionPerformed(event);
        // Verify the expected behavior
        assertFalse(vue.isActive());
        assertTrue(new IHMGestionBaux().isVisible());
    }

    @Test
    public void testActionPerformed_biens() {
        ActionEvent event = new ActionEvent(vue, ActionEvent.ACTION_PERFORMED, "biens");
        controleur.actionPerformed(event);
        // Verify the expected behavior
        assertFalse(vue.isActive());
        assertTrue(new IHMGestionBiens().isVisible());
    }

    @Test
    public void testActionPerformed_Retour() {
        ActionEvent event = new ActionEvent(vue, ActionEvent.ACTION_PERFORMED, "Retour");
        controleur.actionPerformed(event);
        // Verify the expected behavior
        assertFalse(vue.isActive());
        assertTrue(new IHMGestionLocataires().isVisible());
    }

    @Test
    public void testActionPerformed_Modifier() {
        ActionEvent event = new ActionEvent(vue, ActionEvent.ACTION_PERFORMED, "Modifier");
        controleur.actionPerformed(event);
        // Verify the expected behavior
        assertFalse(vue.isActive());
        assertTrue(new IHMModificationLocataire(locataire).isVisible());
    }
    
}