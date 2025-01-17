package testVue;

import static org.junit.Assert.*;

import dao.JDBCLocataire;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import modele.Locataire;
import vue.IHMDetailsLocataire;

import java.awt.*;

public class TestIHMDetailsLocataire {

    private IHMDetailsLocataire vue;
    private final JDBCLocataire donneesLocataire = new JDBCLocataire();

    @Before
    public void setUp() {
        Locataire locataire = this.donneesLocataire.getById("VKOH").orElseThrow();
        vue = new IHMDetailsLocataire(locataire);
    }

    @After
    public void tearDown() {
        vue.dispose();
    }

    @Test
    public void testInitialisationComponents() {
        assertNotNull(vue);
        assertEquals("Détails du locataire", vue.getTitle());
        assertTrue(vue.isVisible());
        assertEquals(JFrame.MAXIMIZED_BOTH, vue.getExtendedState());
    }

    @Test
    public void testLabelInitialization() {
        assertEquals("Koh", vue.getModifNom().getText());
        assertEquals("Virgil Shaun", vue.getModifPrenom().getText());
        assertEquals("09 April 2004", vue.getModifDateNaissance().getText());
        assertEquals("06 11 16 22 42", vue.getModifTelephone().getText());
        assertEquals("virgilskoh@gmail.com", vue.getModifEmail().getText());
        assertEquals("05 March 2024", vue.getModifDateEntree().getText());
        assertEquals("M", vue.getModifGenre().getText());
        assertEquals("Toulouse", vue.getModifLieuNaissance().getText());
        assertEquals("Malaisie", vue.getModifNationalite().getText());
        assertEquals("Etudiant", vue.getModifProfession().getText());
    }

    @Test
    public void testButtonActionCommands() {
        JButton boutonRetour = getButtonByActionCommand("Retour");
        assertNotNull(boutonRetour);
        assertEquals("Retour", boutonRetour.getActionCommand());

        JButton boutonModifier = getButtonByActionCommand("Modifier");
        assertNotNull(boutonModifier);
        assertEquals("Modifier", boutonModifier.getActionCommand());

        JButton boutonGBiens = getButtonByActionCommand("biens");
        assertNotNull(boutonGBiens);
        assertEquals("biens", boutonGBiens.getActionCommand());

        JButton boutonGBaux = getButtonByActionCommand("baux");
        assertNotNull(boutonGBaux);
        assertEquals("baux", boutonGBaux.getActionCommand());

        JButton boutonGDeclFisc = getButtonByActionCommand("declarationFiscale");
        assertNotNull(boutonGDeclFisc);
        assertEquals("declarationFiscale", boutonGDeclFisc.getActionCommand());

        JButton boutonGFinances = getButtonByActionCommand("finances");
        assertNotNull(boutonGFinances);
        assertEquals("finances", boutonGFinances.getActionCommand());
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