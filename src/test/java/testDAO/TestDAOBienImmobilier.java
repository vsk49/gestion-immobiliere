package testDAO;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dao.JDBCBienImmobilier;
import dao.JDBCConnexion;
import modele.BienImmobilier;
import modele.Compteur;
import modele.TaxeFonciere;
import modele.TypeCompteur;

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

	@Ignore
	@Test
	public void testGetById() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, new TaxeFonciere(1, 2830.00), 
				2376, new Compteur(1, "1234567890123", 
				TypeCompteur.EAU, 2376, 2463, LocalDate.of(2022, 3, 2), 87));
		this.daoBienImmobilier.insert(bien);
		
		// QUAND le proprietaire recupere le bien
		BienImmobilier bienRecupere = this.daoBienImmobilier.getAll().get(0);
		
		// ALORS le bien est correctement recupere de la BD.
		assertEquals(bien.getNumeroFiscal(), bienRecupere.getNumeroFiscal());
		assertEquals(bien.getAdresse(), bienRecupere.getAdresse());
		assertEquals(bien.getCodePostal(), bienRecupere.getCodePostal());
		assertEquals(bien.getVille(), bienRecupere.getVille());
		assertEquals(bien.getDateAnniversaire().toString(), bienRecupere.getDateAnniversaire().toString());
		assertEquals(bien.getTaxesFoncieres().getMontantBase(), bienRecupere.getTaxesFoncieres().getMontantBase(), 0);
		assertEquals(bien.getICCDateDebut(), bienRecupere.getICCDateDebut());
		assertEquals(bien.getIdBienImmobilier(), bienRecupere.getIdBienImmobilier());	
	}

	@Ignore
	@Test
	public void testInsert() {
		// ÉTANT DONNE un nouveau bien à insérer
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, new TaxeFonciere(1, 2830.00), 
				2376, new Compteur(1, "1234567890123", 
				TypeCompteur.EAU, 2376, 2463, LocalDate.of(2022, 3, 2), 87));

		// QUAND j'insere le bien
		this.daoBienImmobilier.insert(bien);

		// ALORS le bien est correctement inséré dans la base de données
		BienImmobilier bienRecupere = this.daoBienImmobilier.getAll().get(0);
		assertEquals("3101234567890", bienRecupere.getNumeroFiscal());
		assertEquals("40 rue des Lilas", bienRecupere.getAdresse());
		assertEquals(31200, bienRecupere.getCodePostal());
		assertEquals("Toulouse", bienRecupere.getVille());
		assertEquals(dateAnniversaire.toString(), bienRecupere.getDateAnniversaire().toString());
		assertEquals(2830.00, bienRecupere.getTaxesFoncieres().getMontantBase(), 0);
		assertEquals(2376, bienRecupere.getICCDateDebut());
    }

	@Ignore
	@Test
	public void testUpdate() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, new TaxeFonciere(1, 2830.00), 
				2376, new Compteur(1, "1234567890123", 
				TypeCompteur.EAU, 2376, 2463, LocalDate.of(2022, 3, 2), 87));
		this.daoBienImmobilier.insert(bien);
		bien = this.daoBienImmobilier.getAll().get(0);

		// QUAND je mets a jour les information du bien
		bien.setICCDateDebut(2463);
		this.daoBienImmobilier.update(bien);

		// ALORS le bien a ete mise a jour dans la BD.
		BienImmobilier bienRecupere = this.daoBienImmobilier.getById(bien.getIdBienImmobilier()).get();
		assertEquals(2463, bienRecupere.getICCDateDebut());
	}

	@Ignore
	@Test
	public void testDelete() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, new TaxeFonciere(1, 2830.00), 
				2376, new Compteur(1, "1234567890123", 
				TypeCompteur.EAU, 2376, 2463, LocalDate.of(2022, 3, 2), 87));
		this.daoBienImmobilier.insert(bien);
		bien = this.daoBienImmobilier.getAll().get(0);

		// QUAND je supprime ce bien
		this.daoBienImmobilier.delete(bien);

		// ALORS ce bien a bien ete supprime dans la BD.
		assertFalse(this.daoBienImmobilier.getById(bien.getIdBienImmobilier()).isPresent());
	}

	@Ignore
	@Test
	public void testGetAll() {
		// ETANT DONNE 2 biens existants dans la BD
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien1 = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, new TaxeFonciere(1, 2830.00), 
				2376, new Compteur(1, "1234567890123", 
				TypeCompteur.EAU, 2376, 2463, LocalDate.of(2022, 3, 2), 87));
		BienImmobilier bien2 = new BienImmobilier(1, "3101234567890", "40 rue des Lilas", 31200, "Toulouse",
				dateAnniversaire, new TaxeFonciere(1, 2830.00), 
				2376, new Compteur(1, "1234567890123", 
				TypeCompteur.EAU, 2376, 2463, LocalDate.of(2022, 3, 2), 87));
		this.daoBienImmobilier.insert(bien1);
		this.daoBienImmobilier.insert(bien2);
		
		// QUAND le proprietaire recupere tous les biens
		List<BienImmobilier> biensRecuperes = this.daoBienImmobilier.getAll();
		
		// ALORS tous les biens sont bien recuperes
        assertEquals(2, biensRecuperes.size());
	}

}
