package testControleur;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.JTable;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import controleur.controleurGestionLocataires;
import dao.JDBCLocataire;
import modele.Genre;
import modele.Locataire;
import vue.IHMDetailsLocataire;
import vue.IHMGestionLocataires;

public class testControleurLocataire {

	@Mock
    private JTable mockTable;

    @Mock
    private Locataire mockLocataire;

    @Mock
    private IHMDetailsLocataire mockVueDetails;

    @Mock
    private IHMGestionLocataires mockVue;

    @Mock
    private JDBCLocataire mockModele;

    @InjectMocks
    private controleurGestionLocataires controleur;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testAppliquerFiltre_NationaliteFrancaise() throws Exception {
		// Préparer les données
		LocalDate dateNaissance1 = LocalDate.of(2002, 11, 9);
		LocalDate dateEntree1 = LocalDate.of(2022, 5, 3);
		LocalDate dateDepart1 = null;
		LocalDate dateNaissance2 = LocalDate.of(2001, 10, 8);
		LocalDate dateEntree2 = LocalDate.of(2021, 4, 3);
		LocalDate dateDepart2 = null;
		LocalDate dateNaissance3 = LocalDate.of(2003, 12, 11);
		LocalDate dateEntree3 = LocalDate.of(2023, 3, 3);
		LocalDate dateDepart3 = null;
		List<Locataire> locataires = Arrays.asList(
			new Locataire("DJEA", "Durang", "Jean", Genre.MASCULIN, dateNaissance1, "France",
				"France", "Etudiant", "0606060606", "jeandurang@mail.test",
				dateEntree1, dateDepart1, 0),
			new Locataire("SJOH", "Smith", "John", Genre.MASCULIN, dateNaissance2, "USA",
				"Etats-Unis", "Etudiant", "0625784146", "SmithJ@mail.test",
				dateEntree2, dateDepart2, 0),
			new Locataire("DMAR", "Dupont", "Marie", Genre.FEMININ, dateNaissance3, "France",
				"France", "Plombier", "0632052691", "DupontLePlombier@mail.test",
				dateEntree3, dateDepart3, 0)
		);

		// Instancier le contrôleur
		IHMGestionLocataires mockVue = Mockito.mock(IHMGestionLocataires.class);
		controleurGestionLocataires controleur = new controleurGestionLocataires(mockVue, mockLocataire);

		// Utiliser la réflexion pour accéder à la méthode privée
		Method method = controleurGestionLocataires.class.getDeclaredMethod("appliquerFiltre", List.class, String.class);
		method.setAccessible(true);

		// Appeler la méthode à tester
		List<Locataire> result = (List<Locataire>) method.invoke(controleur, locataires, "Nationalite: Francaise");

		// Vérifier le résultat
		assertThat(result).hasSize(2); // Il ne doit y avoir que 2 locataires français
		assertThat(result).extracting(Locataire::getNom).containsExactly("Durang", "Dupont");
	}

	@Test
	public void testAppliquerFiltre_NationaliteEtrangere() throws Exception {
		// Préparer les données
		LocalDate dateNaissance1 = LocalDate.of(2002, 11, 9);
		LocalDate dateEntree1 = LocalDate.of(2022, 5, 3);
		LocalDate dateDepart1 = null;
		LocalDate dateNaissance2 = LocalDate.of(2001, 10, 8);
		LocalDate dateEntree2 = LocalDate.of(2021, 4, 3);
		LocalDate dateDepart2 = null;
		LocalDate dateNaissance3 = LocalDate.of(2003, 12, 11);
		LocalDate dateEntree3 = LocalDate.of(2023, 3, 3);
		LocalDate dateDepart3 = null;
		List<Locataire> locataires = Arrays.asList(
			new Locataire("DJEA", "Durang", "Jean", Genre.MASCULIN, dateNaissance1, "France",
				"France", "Etudiant", "0606060606", "jeandurang@mail.test",
				dateEntree1, dateDepart1, 0),
			new Locataire("SJOH", "Smith", "John", Genre.MASCULIN, dateNaissance2, "USA",
				"Etats-Unis", "Etudiant", "0625784146", "SmithJ@mail.test",
				dateEntree2, dateDepart2, 0),
			new Locataire("DMAR", "Dupont", "Marie", Genre.FEMININ, dateNaissance3, "France",
				"France", "Plombier", "0632052691", "DupontLePlombier@mail.test",
				dateEntree3, dateDepart3, 0)
		);

		// Instancier le contrôleur
		IHMGestionLocataires mockVue = Mockito.mock(IHMGestionLocataires.class);
		controleurGestionLocataires controleur = new controleurGestionLocataires(mockVue, mockLocataire);

		// Utiliser la réflexion pour accéder à la méthode privée
		Method method = controleurGestionLocataires.class.getDeclaredMethod("appliquerFiltre", List.class, String.class);
		method.setAccessible(true);

		// Appeler la méthode à tester
		List<Locataire> result = (List<Locataire>) method.invoke(controleur, locataires, "Nationalite: Etrangere");

		// Vérifier le résultat
		assertThat(result).hasSize(1); // Il doit y avoir 1 locatapublic class controleurGestionLocatairesTest {
	}

	@Test
    public void testMouseClicked_DoubleClick() {
		// Préparer les données
		LocalDate dateNaissance1 = LocalDate.of(2002, 11, 9);
		LocalDate dateEntree1 = LocalDate.of(2022, 5, 3);
		LocalDate dateDepart1 = null;
		List<Locataire> locataires = Arrays.asList(
			new Locataire("DJEA", "Durang", "Jean", Genre.MASCULIN, dateNaissance1, "France",
				"France", "Etudiant", "0606060606", "jeandurang@mail.test",
				dateEntree1, dateDepart1, 0));

        // Arrange
        MouseEvent mockEvent = mock(MouseEvent.class);
        when(mockEvent.getClickCount()).thenReturn(2);
        when(mockEvent.getSource()).thenReturn(mockTable);
        when(mockTable.getSelectedRow()).thenReturn(0);
        when(mockTable.getValueAt(0, 0)).thenReturn("EDEH");
        when(mockModele.getById("EDEH")).thenReturn(Optional.of(mockLocataire));

        // Act
        controleur.mouseClicked(mockEvent);

        // Assert
        verify(mockModele).getById("EDEH");
        verify(mockVue).dispose();
        verify(mockVueDetails).setVisible(true);
    }

    @Test
    public void testMouseClicked_SingleClick() {
        // Arrange
        MouseEvent mockEvent = mock(MouseEvent.class);
        when(mockEvent.getClickCount()).thenReturn(1);

        // Act
        controleur.mouseClicked(mockEvent);

        // Assert
        verify(mockModele, never()).getById(anyString());
        verify(mockVue, never()).dispose();
        verify(mockVueDetails, never()).setVisible(true);
    }
}
