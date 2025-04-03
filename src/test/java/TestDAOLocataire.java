import modele.CreateBD;
import modele.InputData;
import modele.JDBCLocataire;
import modele.Locataire;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test de la classe JDBCLocataire")
class TestDAOLocataire {

	private JDBCLocataire daoLocataire;
	private Locataire locataire1;
	private Locataire locataire2;

	@BeforeEach
	void setUp() {
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

	@AfterEach
	void tearDown() {
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
	@DisplayName("ÉTANT DONNE un locataire déjà inséré dans la base de données, " +
				 "QUAND le proprietaire recupere le locataire, " +
				 "ALORS le locataire est correctement recupere de la BD.")
	void testGetById() {
		Locataire locataireRecupere = this.daoLocataire.getById("DJEA").orElseThrow();
		assertEquals(this.locataire1, locataireRecupere);
	}

	@Test
	@DisplayName("ÉTANT DONNE un nouveau locataire à insérer" +
				 "QUAND j'insere le locataire" +
				 "ALORS le locataire est correctement inséré dans la base de données")
	void testInsert() {
		Locataire test = new Locataire("JDOE", "Doe", "Jim",
				LocalDate.of(2000, 5, 12), "jimmydoe@gmail.com", "01 23 45 67 89");
		this.daoLocataire.insert(test);
		Locataire locataireRecupere = this.daoLocataire.getById("JDOE").orElseThrow();
		assertEquals(test, locataireRecupere);
    }

	@Test
	@DisplayName("ÉTANT DONNE un locataire déjà inséré dans la base de données" +
				 "QUAND je mets à jour les informations du locataire" +
				 "ALORS le locataire est correctement mis à jour dans la base de données")
	void testUpdate() {
		Locataire locataireRecupere = this.daoLocataire.getById("DJEA").orElseThrow();
		locataireRecupere.setEmail("testing.update@gmail.com");
		this.daoLocataire.update(locataireRecupere);
		assertNotEquals(this.locataire1, locataireRecupere);
	}

	@Test
	@DisplayName("ÉTANT DONNE un locataire déjà inséré dans la base de données" +
				 "QUAND je supprime le locataire" +
				 "ALORS le locataire est correctement supprimé de la base de données")
	void testDelete() {
		this.daoLocataire.delete(this.locataire1);
		assertFalse(this.daoLocataire.getById(this.locataire1.getIdLocataire()).isPresent());
	}

	@Test
	@DisplayName("ÉTANT DONNE plusieurs locataires dans la base de données" +
				 "QUAND je récupère tous les locataires" +
				 "ALORS tous les locataires sont correctement récupérés")
	void testGetAll() {
		List<Locataire> locataireRecuperes = this.daoLocataire.getAll();
        assertEquals(6, locataireRecuperes.size());
	}

}