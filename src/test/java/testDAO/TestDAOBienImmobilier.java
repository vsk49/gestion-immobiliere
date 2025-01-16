package testDAO;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import dao.JDBCBienImmobilier;
import dao.JDBCConnexion;
import modele.BienImmobilier;

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
	public void testGetByNumeroFiscal() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(5, "3134567890123",
				"17 Avenue du Rangueil", 31200, "Toulouse",
				dateAnniversaire,2376);
		this.daoBienImmobilier.insert(bien);
		
		// QUAND le proprietaire recupere le bien
		BienImmobilier bienRecupere = this.daoBienImmobilier.getByNumeroFiscal("3134567890123").orElseThrow();
		
		// ALORS le bien est correctement recupere de la BD.
		assertEquals(bien.getNumeroFiscal(), bienRecupere.getNumeroFiscal());
		assertEquals(bien.getAdresse(), bienRecupere.getAdresse());
		assertEquals(bien.getCodePostal(), bienRecupere.getCodePostal());
		assertEquals(bien.getVille(), bienRecupere.getVille());
		assertEquals(bien.getDateAnniversaire().toString(), bienRecupere.getDateAnniversaire().toString());
		assertEquals(bien.getICCDateDebut(), bienRecupere.getICCDateDebut());
		assertEquals(bien.getIdBienImmobilier(), bienRecupere.getIdBienImmobilier());	
	}

	@Test
	public void testInsert() {
		// ÉTANT DONNE un nouveau bien à insérer
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(5, "3134567890123",
				"17 Avenue du Rangueil", 31200, "Toulouse",
				dateAnniversaire,2376);

		// QUAND j'insere le bien
		this.daoBienImmobilier.insert(bien);

		// ALORS le bien est correctement inséré dans la base de données
		BienImmobilier bienRecupere = this.daoBienImmobilier.getByNumeroFiscal("3134567890123").orElseThrow();
		assertEquals("3134567890123", bienRecupere.getNumeroFiscal());
		assertEquals("17 Avenue du Rangueil", bienRecupere.getAdresse());
		assertEquals(31200, bienRecupere.getCodePostal());
		assertEquals("Toulouse", bienRecupere.getVille());
		assertEquals(dateAnniversaire.toString(), bienRecupere.getDateAnniversaire().toString());
		assertEquals(2376, bienRecupere.getICCDateDebut());
    }

	@Test
	public void testUpdate() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(5, "3134567890123",
				"17 Avenue du Rangueil", 31200, "Toulouse",
				dateAnniversaire,2376);
		this.daoBienImmobilier.insert(bien);
		bien = this.daoBienImmobilier.getByNumeroFiscal("3134567890123").orElseThrow();

		// QUAND je mets a jour les information du bien
		bien.setICCDateDebut(2463);
		this.daoBienImmobilier.update(bien);

		// ALORS le bien a ete mise a jour dans la BD.
		BienImmobilier bienRecupere = this.daoBienImmobilier.getById(bien.getIdBienImmobilier()).orElseThrow();
		assertEquals(2463, bienRecupere.getICCDateDebut());
	}

	@Test
	public void testDelete() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(5, "3134567890123",
				"17 Avenue du Rangueil", 31200, "Toulouse",
				dateAnniversaire,2376);
		this.daoBienImmobilier.insert(bien);
		bien = this.daoBienImmobilier.getByNumeroFiscal("3134567890123").orElseThrow();

		// QUAND je supprime ce bien
		this.daoBienImmobilier.delete(bien);

		// ALORS ce bien a bien ete supprime dans la BD.
		assertFalse(this.daoBienImmobilier.getByNumeroFiscal("3134567890123").isPresent());
	}

	@Test
	public void testGetAll() {
		// ETANT DONNE 4 biens existants dans la BD et j'insere 2 biens supplementaires
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien1 = new BienImmobilier(5, "3134567890123",
				"17 Avenue du Rangueil", 31200, "Toulouse",
				dateAnniversaire,2376);
		BienImmobilier bien2 = new BienImmobilier(6, "3145678901234",
				"18 Avenue du Rangueil", 31200, "Toulouse",
				dateAnniversaire,2376);
		this.daoBienImmobilier.insert(bien1);
		this.daoBienImmobilier.insert(bien2);
		
		// QUAND le proprietaire recupere tous les biens
		List<BienImmobilier> biensRecuperes = this.daoBienImmobilier.getAll();
		
		// ALORS tous les biens sont bien recuperes (6 biens au total)
        assertEquals(6, biensRecuperes.size());
	}

}
