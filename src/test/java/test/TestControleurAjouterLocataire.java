package test;

import controleur.ControleurAjoutLocataire;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import vue.IHMAjouterLocataire;
import vue.IHMGestionLocataires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestControleurAjouterLocataire {

    private IHMAjouterLocataire vue;
    private ControleurAjoutLocataire controleur;

    @Before
    public void setUp() {
        // Create real instances of the classes
        vue = new IHMAjouterLocataire();
        controleur = new ControleurAjoutLocataire(vue);
    }

    @After
    public void tearDown() {
        vue.dispose();
    }

    @Test
    public void testActionPerformed_Valider() {
        // Set up the state of the vue instance
        vue.getTextFieldNom().setText("Doe");
        vue.getTextFieldPrenom().setText("John");
        vue.getDatePickerNaissance().setDate(LocalDate.of(1990, 1, 1));
        vue.getTextFieldTelephone().setText("01 23 45 67 89");
        vue.getTextFieldEmail().setText("john.doe@example.com");
        vue.getDatePickerEntree().setDate(LocalDate.of(2020, 1, 1));
        vue.getTextFieldLieuNaissance().setText("Paris");
        vue.getTextFieldNationalite().setText("France");
        vue.getTextProfession().setText("Ingenieur");
        vue.getRadioButtonHomme().setSelected(true);

        // Act
        JButton buttonValider = getButtonByActionCommand("Valider");
        assertNotNull(buttonValider);
        ActionEvent event = new ActionEvent(buttonValider, ActionEvent.ACTION_PERFORMED, "Valider");
        controleur.actionPerformed(event);

        // Assert
        IHMGestionLocataires vueGestion = new IHMGestionLocataires();
        assertTrue(vueGestion.isVisible());
        assertEquals(5, vueGestion.getTableLocataires().getRowCount());
    }

    @Test
    public void testActionPerformed_Annuler() {
        // Arrange
        JButton buttonAnnuler = getButtonByActionCommand("Annuler");
        assertNotNull(buttonAnnuler);

        // Act
        ActionEvent event = new ActionEvent(buttonAnnuler, ActionEvent.ACTION_PERFORMED, "Annuler");
        controleur.actionPerformed(event);

        // Assert
        assertFalse(vue.isVisible());
        assertTrue(new IHMGestionLocataires().isVisible());
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