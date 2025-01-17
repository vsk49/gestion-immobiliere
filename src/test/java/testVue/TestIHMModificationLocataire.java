package testVue;

import static org.junit.Assert.*;

import dao.JDBCLocataire;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import modele.Locataire;
import vue.IHMModificationLocataire;

import java.awt.*;

public class TestIHMModificationLocataire {

    private IHMModificationLocataire vue;
    private final JDBCLocataire donneeslocataire = new JDBCLocataire();

    @Before
    public void setUp() {
        Locataire locataire = this.donneeslocataire.getById("VKOH").orElseThrow();
        vue = new IHMModificationLocataire(locataire);
    }

    @Test
    public void testInitialisationVue() {
        assertNotNull(vue);
        assertEquals("Modification du locataire", vue.getTitle());
        assertTrue(vue.isVisible());
        assertEquals(JFrame.MAXIMIZED_BOTH, vue.getExtendedState());
    }

    @Test
    public void testRecuperationChampsStringLocataire() {
        assertEquals("Koh", vue.getModifNom().getText());
        assertEquals("Virgil Shaun", vue.getModifPrenom().getText());
        assertEquals("06 11 16 22 42", vue.getModifTelephone().getText());
        assertEquals("virgilskoh@gmail.com", vue.getModifEmail().getText());
        assertEquals("Toulouse", vue.getModifLieuNaissance().getText());
        assertEquals("Malaisie", vue.getModifNationalite().getText());
        assertEquals("Etudiant", vue.getModifProfession().getText());
    }

    @Test
    public void testDatePickerInitialization() {
        assertNotNull(vue.getModifDateNaissance());
        assertNotNull(vue.getModifDateEntree());
        assertEquals("09.04.2004", vue.getModifDateNaissance().getText());
        assertEquals("05.03.2024", vue.getModifDateEntree().getText());
    }

    @Test
    public void testRadioButtonInitialization() {
        assertTrue(vue.getModifHomme().isSelected());
        assertFalse(vue.getModifFemme().isSelected());
    }

    @Test
    public void testButtonActionCommands() {
        JButton boutonAnnuler = getButtonByActionCommand("Annuler");
        assertNotNull(boutonAnnuler);
        assertEquals("Annuler", boutonAnnuler.getActionCommand());

        JButton boutonReinitialiser = getButtonByActionCommand("Reinitialiser");
        assertNotNull(boutonReinitialiser);
        assertEquals("Reinitialiser", boutonReinitialiser.getActionCommand());

        JButton boutonValider = getButtonByActionCommand("Valider");
        assertNotNull(boutonValider);
        assertEquals("Valider", boutonValider.getActionCommand());

        JButton boutonGBiens = getButtonByActionCommand("biens");
        assertNotNull(boutonGBiens);
        assertEquals("biens", boutonGBiens.getActionCommand());

        JButton boutonGBaux = getButtonByActionCommand("baux");
        assertNotNull(boutonGBaux);
        assertEquals("baux", boutonGBaux.getActionCommand());

        JButton boutonGDeclFisc = getButtonByActionCommand("DeclarationFiscale");
        assertNotNull(boutonGDeclFisc);
        assertEquals("DeclarationFiscale", boutonGDeclFisc.getActionCommand());

        JButton boutonGFinances = getButtonByActionCommand("RegularisationCharges");
        assertNotNull(boutonGFinances);
        assertEquals("RegularisationCharges", boutonGFinances.getActionCommand());
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