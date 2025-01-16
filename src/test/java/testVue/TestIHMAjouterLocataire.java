package testVue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import vue.IHMAjouterLocataire;

public class TestIHMAjouterLocataire {

    private IHMAjouterLocataire vue;

    @Before
    public void setUp() {
        vue = new IHMAjouterLocataire();
    }

    @Test
    public void testInitialisationComponents() {
        assertNotNull(vue);
        assertEquals("Ajout de locataire", vue.getTitle());
        assertTrue(vue.isVisible());
        assertEquals(JFrame.MAXIMIZED_BOTH, vue.getExtendedState());
    }

    @Test
    public void testTextFieldInitialization() {
        Object[] informations = vue.getInformations();
        
        assertEquals(5, informations.length);
        assertEquals("", informations[0]); 
        assertEquals("", informations[1]); 
        assertEquals("", informations[2]); 
        assertEquals("", informations[3]); 
        assertEquals("", informations[4]); 
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

        JButton boutonAnnuler = getButtonByActionCommand("Annuler");
        assertNotNull(boutonAnnuler);
        assertEquals("Annuler", boutonAnnuler.getActionCommand());

        JButton boutonValider = getButtonByActionCommand("Valider");
        assertNotNull(boutonValider);
        assertEquals("Valider", boutonValider.getActionCommand());
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
            if (component instanceof JButton) {
                JButton button = (JButton) component;
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