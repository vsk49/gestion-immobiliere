package test;

import controleur.ControleurDetailsLocataire;
import modele.Locataire;
import org.junit.Before;
import org.junit.Test;
import vue.*;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestControleurDetailsLocataire {

    private IHMDetailsLocataire vue;
    private Locataire locataire;
    private ControleurDetailsLocataire controleur;

    @Before
    public void setUp() {
        // Create real instances of the classes
        locataire = new Locataire("DJOH", "Doe", "John",
                LocalDate.of(1990, 1, 1), "01234567890", "john.doe@example.com");
        vue = new IHMDetailsLocataire(locataire);

        // Set up the state of the vue instance
        vue.getModifNom().setText(locataire.getNom());
        vue.getModifPrenom().setText(locataire.getPrenom());
        vue.getModifDateNaissance().setText(locataire.getDateNaissance().toString());
        vue.getModifTelephone().setText(locataire.getTelephone());
        vue.getModifEmail().setText(locataire.getEmail());

        // Create the controller instance
        controleur = new ControleurDetailsLocataire(vue, locataire);
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