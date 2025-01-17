package testControleur;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controleur.controleurGestionLocataires;
import modele.Genre;
import modele.Locataire;
import vue.IHMDetailsLocataire;
import vue.IHMGestionLocataires;

public class TestControleurGestionLocataires {

	private JTable table;
	private IHMDetailsLocataire vueDetails;
	private IHMGestionLocataires vue;
	private controleurGestionLocataires controleur;

	@Before
	public void setUp() {
		// Create real instances of the classes
		vue = new IHMGestionLocataires();
		table = vue.getTableLocataires();

		// Create the controller instance
		controleur = new controleurGestionLocataires(vue, new Locataire());
	}

	@Test
	public void testAppliquerFiltre_NationaliteFrancaise() throws Exception {
		// Préparer les données
		List<Locataire> locataires = new Locataire().getAllLocataires();

		// Utiliser la réflexion pour accéder à la méthode privée
		Method method = controleurGestionLocataires.class.getDeclaredMethod("appliquerFiltre", List.class, String.class);
		method.setAccessible(true);

		// Appeler la méthode à tester
		List<Locataire> result = (List<Locataire>) method.invoke(controleur, locataires, "Nationalite: Francaise");

		// Vérifier le résultat
		assertThat(result).hasSize(3); // Il ne doit y avoir que 2 locataires français
		assertThat(result).extracting(Locataire::getNom).containsExactly("Poux--Bories", "Deher", "Miegemolle");
	}

	@Test
	public void testAppliquerFiltre_NationaliteEtrangere() throws Exception {
		// Préparer les données
		List<Locataire> locataires = new Locataire().getAllLocataires();

		// Utiliser la réflexion pour accéder à la méthode privée
		Method method = controleurGestionLocataires.class.getDeclaredMethod("appliquerFiltre", List.class, String.class);
		method.setAccessible(true);

		// Appeler la méthode à tester
		List<Locataire> result = (List<Locataire>) method.invoke(controleur, locataires, "Nationalite: Etrangere");

		// Vérifier le résultat
		assertThat(result).hasSize(1);
		assertThat(result).extracting(Locataire::getNom).containsExactly("Koh");
	}

	@Test
	public void testMouseClicked_DoubleClick() {
		// Arrange
		Locataire locataire = new Locataire("YPOU", "Poux--Bories", "Yoan", Genre.MASCULIN, LocalDate.of(2004, 1, 23), "Toulouse", "France", "Etudiant", "06 12 34 56 78", "yoan.poux@gmail.com", LocalDate.of(2024, 5, 12), null, 0);
		controleur = new controleurGestionLocataires(vue, locataire);

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

	@Test
	public void testMouseClicked_SingleClick() {
		// Arrange
		MouseEvent event = new MouseEvent(table, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false);

		// Act
		table.dispatchEvent(event);

		// Assert
		assertTrue(vue.isVisible());
		assertFalse(vueDetails != null && vueDetails.isVisible());
	}

}