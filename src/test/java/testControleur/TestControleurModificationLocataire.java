package testControleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import controleur.controleurModificationLocataire;
import modele.Genre;
import modele.Locataire;
import vue.IHMDetailsLocataire;
import vue.IHMModificationLocataire;

import javax.swing.*;

import static org.junit.Assert.*;

public class TestControleurModificationLocataire {

    private IHMModificationLocataire vue;
    private Locataire locataire;
    private controleurModificationLocataire controleur;

    @Before
    public void setUp() {
        // Create real instances of the classes
        locataire = new Locataire().getLocatairesById("VKOH");

        vue = new IHMModificationLocataire(locataire);
        controleur = new controleurModificationLocataire(vue, locataire);
    }

    @Test
    public void testActionPerformed_Valider() {
        // Set up the state of the vue instance
        vue.getModifNom().setText("Doe");
        vue.getModifPrenom().setText("John");
        vue.getModifDateNaissance().setDate(LocalDate.of(1990, 1, 1));
        vue.getModifTelephone().setText("1234567890");
        vue.getModifEmail().setText("john.doe@example.com");
        vue.getModifDateEntree().setDate(LocalDate.of(2020, 1, 1));
        vue.getModifLieuNaissance().setText("Paris");
        vue.getModifNationalite().setText("French");
        vue.getModifProfession().setText("Engineer");
        vue.getModifHomme().setSelected(true);

        JButton buttonValider = getButtonByActionCommand("Valider");
        assertNotNull(buttonValider);

        // Act
        ActionEvent event = new ActionEvent(buttonValider, ActionEvent.ACTION_PERFORMED, "Valider");
        controleur.actionPerformed(event);

        // Assert
        Locataire locataireModifie = new Locataire().getLocatairesById("VKOH");
        assertTrue(new IHMDetailsLocataire(locataireModifie).isVisible());
        assertEquals("Doe", locataireModifie.getNom());
        assertEquals("John", locataireModifie.getPrenom());
        assertEquals(LocalDate.of(1990, 1, 1), locataireModifie.getDateNaissance());
        assertEquals("1234567890", locataireModifie.getTelephone());
        assertEquals("john.doe@example.com", locataireModifie.getEmail());
        assertEquals(LocalDate.of(2020, 1, 1), locataireModifie.getDateEntree());
        assertEquals("Paris", locataireModifie.getLieuNaissance());
        assertEquals("French", locataireModifie.getNationalite());
        assertEquals("Engineer", locataireModifie.getProfession());
        assertEquals(Genre.MASCULIN, locataireModifie.getGenre());
    }

    @Test
    public void testActionPerformed_Annuler() {
        JButton buttonAnnuler = getButtonByActionCommand("Annuler");
        assertNotNull(buttonAnnuler);

        // Act
        ActionEvent event = new ActionEvent(buttonAnnuler, ActionEvent.ACTION_PERFORMED, "Annuler");
        controleur.actionPerformed(event);

        // Assert
        IHMDetailsLocataire vueDetails = new IHMDetailsLocataire(locataire);
        assertTrue(vueDetails.isVisible());
    }

    private JButton getButtonByActionCommand(String actionCommand) {
        for (Component component : vue.getContentPane().getComponents()) {
            if (component instanceof JPanel) {
                JButton button = findButtonInPanel((JPanel) component, actionCommand);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }

    private JButton findButtonInPanel(JPanel panel, String actionCommand) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton button) {
                if (actionCommand.equals(button.getActionCommand())) {
                    return button;
                }
            } else if (component instanceof JPanel) {
                JButton button = findButtonInPanel((JPanel) component, actionCommand);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }
}