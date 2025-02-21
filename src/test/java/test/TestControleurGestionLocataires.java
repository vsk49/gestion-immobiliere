package test;

import controleur.ControleurGestionLocataires;
import dao.JDBCLocataire;
import modele.Locataire;
import org.junit.Before;
import org.junit.Test;
import vue.IHMDetailsLocataire;
import vue.IHMGestionLocataires;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestControleurGestionLocataires {

	private JTable table;
	private IHMGestionLocataires vue;
	private ControleurGestionLocataires controleur;

	@Before
	public void setUp() {
		// Create real instances of the classes
		vue = new IHMGestionLocataires();
		table = vue.getTableLocataires();

		// Create the controller instance
		controleur = new ControleurGestionLocataires(vue, new JDBCLocataire());
	}

	@Test
	public void testAppliquerFiltre_NationaliteFrancaise() throws Exception {
		// Préparer les données
		List<Locataire> locataires = new JDBCLocataire().getAll();

		// Utiliser la réflexion pour accéder à la méthode privée
		Method method = ControleurGestionLocataires.class.getDeclaredMethod("appliquerFiltre", List.class, String.class);
		method.setAccessible(true);

		// Appeler la méthode à tester
		@SuppressWarnings("unchecked")
		List<Locataire> result = (List<Locataire>) method.invoke(controleur, locataires, "Nationalite: Francaise");

		// Vérifier le résultat
		assertThat(result).hasSize(3); // Il ne doit y avoir que 2 locataires français
		assertThat(result).extracting(Locataire::getNom).containsExactly("Poux--Bories", "Deher", "Miegemolle");
	}

	@Test
	public void testAppliquerFiltre_NationaliteEtrangere() throws Exception {
		// Préparer les données
		List<Locataire> locataires = new JDBCLocataire().getAll();

		// Utiliser la réflexion pour accéder à la méthode privée
		Method method = ControleurGestionLocataires.class.getDeclaredMethod("appliquerFiltre", List.class, String.class);
		method.setAccessible(true);

		// Appeler la méthode à tester
		@SuppressWarnings("unchecked")
		List<Locataire> result = (List<Locataire>) method.invoke(controleur, locataires, "Nationalite: Etrangere");

		// Vérifier le résultat
		assertThat(result).hasSize(1);
		assertThat(result).extracting(Locataire::getNom).containsExactly("Koh");
	}

	@Test
	public void testMouseClicked_DoubleClick() {
		// Arrange
		JDBCLocataire jdbcLocataire = new JDBCLocataire();
		Locataire locataire = jdbcLocataire.getById("YPOU").orElseThrow();
		controleur = new ControleurGestionLocataires(vue, jdbcLocataire);

		// Add locataire to the table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{"YPOU", "Poux--Bories", "Yoan", "yoan.poux@gmail.com"});

		// Act
		MouseEvent event = new MouseEvent(table, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 2, false);
		table.dispatchEvent(event);

		// Assert
		assertTrue(new IHMDetailsLocataire(locataire).isVisible());
		assertFalse(vue.isActive());
	}

}