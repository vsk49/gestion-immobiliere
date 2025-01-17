package testVue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import vue.IHMGestionLocataires;

import java.awt.*;

public class TestIHMGestionLocataires {

    private IHMGestionLocataires vue;

    @Before
    public void setUp() {
        vue = new IHMGestionLocataires();
    }

    @After
    public void tearDown() {
        vue.dispose();
    }

    @Test
    public void testInitialisationComponents() {
        assertNotNull(vue);
        assertEquals("Gestion des Locataires", vue.getTitle());
        assertTrue(vue.isVisible());
        assertEquals(JFrame.MAXIMIZED_BOTH, vue.getExtendedState());
    }

    @Test
    public void testTableInitialization() {
        JTable table = vue.getTableLocataires();
        assertNotNull(table);
        assertEquals(4, table.getColumnCount());
        assertEquals("ID", table.getColumnName(0));
        assertEquals("Nom", table.getColumnName(1));
        assertEquals("Prenom", table.getColumnName(2));
        assertEquals("Email", table.getColumnName(3));
    }

    @Test
    public void testChampRechercheInitialization() {
        JTextField champRecherche = vue.getChampRecherche();
        assertNotNull(champRecherche);
        assertEquals(10, champRecherche.getColumns());
    }

    @Test
    public void testButtonActionCommands() {
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

        JButton boutonAjout = getButtonByActionCommand("Ajout");
        assertNotNull(boutonAjout);
        assertEquals("Ajout", boutonAjout.getActionCommand());

        JButton boutonRecherche = getButtonByActionCommand("Chercher");
        assertNotNull(boutonRecherche);
        assertEquals("Chercher", boutonRecherche.getActionCommand());
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