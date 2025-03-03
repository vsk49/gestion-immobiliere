import dao.CreateBD;
import dao.InputData;
import dao.JDBCLocataire;
import modele.Locataire;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class TestDAOLocataire {

	private JDBCLocataire daoLocataire;
	private Locataire locataire1;
	private Locataire locataire2;

	@Before
	public void setUp() {
		CreateBD.main(null);
		InputData.main(null);
		this.daoLocataire = new JDBCLocataire();
		this.locataire1 = new Locataire("DJEA", "Durang", "Jean",
				LocalDate.of(2001, 10, 8), "jean.durang@mail.com", "0606060606");
		this.locataire2 = new Locataire("DMAR", "Dupont", "Marc",
				LocalDate.of(2002, 11, 22), "0607070707", "marc.dupont@gmail.com");
		this.daoLocataire.insert(locataire1);
		this.daoLocataire.insert(locataire2);
	}

	@After
	public void tearDown() {
		if (this.daoLocataire.getById("DJEA").isPresent()) {
			this.daoLocataire.delete(this.locataire1);
		}
		if (this.daoLocataire.getById("DMAR").isPresent()) {
			this.daoLocataire.delete(this.locataire2);
		}
		if (this.daoLocataire.getById("JDOE").isPresent()) {
			this.daoLocataire.delete(this.daoLocataire.getById("JDOE").orElseThrow());
		}
		this.locataire1 = null;
		this.locataire2 = null;
		this.daoLocataire = null;
	}

	@Test
	public void testGetById() {
		// ÉTANT DONNE un locataire déjà inséré dans la base de données
		// QUAND le proprietaire recupere le locataire
		Locataire locataireRecupere = this.daoLocataire.getById("DJEA").orElseThrow();
		
		// ALORS le locataire est correctement recupere de la BD.
		assertEquals(this.locataire1, locataireRecupere);
	}

	@Test
	public void testInsert() {
		// ÉTANT DONNE un nouveau locataire à insérer
		Locataire test = new Locataire("JDOE", "Doe", "Jim",
				LocalDate.of(2000, 5, 12), "jimmydoe@gmail.com", "01 23 45 67 89");

		// QUAND j'insere le locataire
		this.daoLocataire.insert(test);

		// ALORS le locataire est correctement inséré dans la base de données
		Locataire locataireRecupere = this.daoLocataire.getById("JDOE").orElseThrow();
		assertEquals(test, locataireRecupere);
    }

	@Test
	public void testUpdate() {
		// ÉTANT DONNE un locataire déjà inséré dans la base de données
		Locataire locataireRecupere = this.daoLocataire.getById("DJEA").orElseThrow();

		// QUAND je mets a jour les information du locataire
		locataireRecupere.setEmail("testing.update@gmail.com");
		this.daoLocataire.update(locataireRecupere);

		// ALORS le locataire a ete mise a jour dans la BD.
		assertNotEquals(this.locataire1, locataireRecupere);
	}

	@Test
	public void testDelete() {
		// ÉTANT DONNE un locataire déjà inséré dans la base de données
		// QUAND je supprime ce locataire
		this.daoLocataire.delete(this.locataire1);

		// ALORS ce locataire a correctement ete supprime dans la BD.
		assertFalse(this.daoLocataire.getById(this.locataire1.getIdLocataire()).isPresent());
	}

	@Test
	public void testGetAll() {
		// ETANT DONNE 4 locataire existants dans la BD et j'insere 2 locataires
		// QUAND le proprietaire recupere tous les locataire
		List<Locataire> locataireRecuperes = this.daoLocataire.getAll();
		
		// ALORS tous les locataire sont bien recuperes
        assertEquals(6, locataireRecuperes.size());
	}

}