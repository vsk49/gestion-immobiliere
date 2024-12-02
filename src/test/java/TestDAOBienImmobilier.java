import static org.junit.Assert.*;

import java.sql.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.JDBCBienImmobilier;
import dao.JDBCConnexion;
import modele.BienImmobilier;
import java.time.LocalDate;
import java.util.List;

public class TestDAOBienImmobilier {

	private JDBCBienImmobilier daoBienImmobilier;
	private final Connection connexion = JDBCConnexion.getConnexion();
	private boolean originalAutoCommit;

	@Before
	public void setUp() throws Exception {
		originalAutoCommit = this.connexion.getAutoCommit();
		this.connexion.setAutoCommit(false);
		this.daoBienImmobilier = new JDBCBienImmobilier();
	}

	@After
	public void tearDown() throws Exception {
		this.connexion.rollback();
		connexion.setAutoCommit(originalAutoCommit);
		JDBCConnexion.closeConnexion();
	}

	@Test
	public void testGetById() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, 3187.00, 2376);
		this.daoBienImmobilier.insert(bien);
		
		// QUAND le proprietaire recupere le bien
		BienImmobilier bienRecupere = this.daoBienImmobilier.getAll().get(0);
		
		// ALORS le bien est correctement recupere de la BD.
		assertEquals(bien.getNumeroFiscal(), bienRecupere.getNumeroFiscal());
		assertEquals(bien.getAdresse(), bienRecupere.getAdresse());
		assertEquals(bien.getCodePostal(), bienRecupere.getCodePostal());
		assertEquals(bien.getVille(), bienRecupere.getVille());
		assertEquals(bien.getDateAnniversaire().toString(), bienRecupere.getDateAnniversaire().toString());
		assertEquals(bien.getMontantTaxesFoncieres(), bienRecupere.getMontantTaxesFoncieres(), 0);
		assertEquals(bien.getICCDateDebut(), bienRecupere.getICCDateDebut());
		assertEquals(bien.getIdBienImmobilier(), bienRecupere.getIdBienImmobilier());	
	}

	@Test
	public void testInsert() {
		// ÉTANT DONNE un nouveau bien à insérer
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, 3187.00, 2376);

		// QUAND j'insere le bien
		this.daoBienImmobilier.insert(bien);

		// ALORS le bien est correctement inséré dans la base de données
		BienImmobilier bienRecupere = this.daoBienImmobilier.getAll().get(0);
		assertEquals("3101234567890", bienRecupere.getNumeroFiscal());
		assertEquals("40 rue des Lilas", bienRecupere.getAdresse());
		assertEquals(31200, bienRecupere.getCodePostal());
		assertEquals("Toulouse", bienRecupere.getVille());
		assertEquals(dateAnniversaire.toString(), bienRecupere.getDateAnniversaire().toString());
		assertEquals(3187.00, bienRecupere.getMontantTaxesFoncieres(), 0);
		assertEquals(2376, bienRecupere.getICCDateDebut());
    }

	@Test
	public void testUpdate() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, 3187.00, 2376);
		this.daoBienImmobilier.insert(bien);
		bien = this.daoBienImmobilier.getAll().get(0);

		// QUAND je mets a jour les information du bien
		bien.setICCDateDebut(2463);
		this.daoBienImmobilier.update(bien);

		// ALORS le bien a ete mise a jour dans la BD.
		BienImmobilier bienRecupere = this.daoBienImmobilier.getById(bien.getIdBienImmobilier()).get();
		assertEquals(2463, bienRecupere.getICCDateDebut());
	}

	@Test
	public void testDelete() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, 3187.00, 2376);
		this.daoBienImmobilier.insert(bien);
		bien = this.daoBienImmobilier.getAll().get(0);

		// QUAND je supprime ce bien
		this.daoBienImmobilier.delete(bien);

		// ALORS ce bien a bien ete supprime dans la BD.
		assertFalse(this.daoBienImmobilier.getById(bien.getIdBienImmobilier()).isPresent());
	}

	@Test
	public void testGetAll() {
		// ETANT DONNE 2 biens existants dans la BD
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien1 = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, 3187.00, 2376);
		BienImmobilier bien2 = new BienImmobilier(2, "3198765432100", "10 rue des Princes", 31200, "Toulouse",
				dateAnniversaire, 2094.00, 2454);
		this.daoBienImmobilier.insert(bien1);
		this.daoBienImmobilier.insert(bien2);
		
		// QUAND le proprietaire recupere tous les biens
		List<BienImmobilier> biensRecuperes = this.daoBienImmobilier.getAll();
		
		// ALORS tous les biens sont bien recuperes
        assertEquals(2, biensRecuperes.size());
	}

}
