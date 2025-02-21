package test;

import dao.JDBCBienImmobilier;
import modele.Batiment;
import modele.Garage;
import modele.Logement;
import modele.BienImmobilier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestDAOBienImmobilier {

	private JDBCBienImmobilier dao;
	private BienImmobilier bien1;
	private BienImmobilier bien2;
	private BienImmobilier bien3;

	@Before
	public void setUp() {
		this.dao = new JDBCBienImmobilier();
		this.bien1 = new Batiment("testBatiment", "15 Avenue du Tarn", 31400, "Toulouse", 3, "2 ans");
		this.bien2 = new Logement("3125789461342", "1 Rue du Verdun", 31000, "Toulouse",
				LocalDate.of(2002, 11, 22), 1, 45.5, 2);
		this.bien3 = new Garage("testGarage", "1 Rue du Verdun", 31000, "Toulouse",
				LocalDate.of(2002, 11, 22));
		this.dao.insert(bien1);
		this.dao.insert(bien2);
		this.dao.insert(bien3);
	}

	@After
	public void tearDown() {
		if (this.dao.getById("testBatiment").isPresent()) {
			this.dao.delete(this.bien1);
		}
		if (this.dao.getById("3125789461342").isPresent()) {
			this.dao.delete(this.bien2);
		}
		if (this.dao.getById("testGarage").isPresent()) {
			this.dao.delete(this.bien3);
		}
		if (this.dao.getById("3134567890123").isPresent()) {
			this.dao.delete(this.dao.getById("3134567890123").orElseThrow());
		}
		this.bien1 = null;
		this.bien2 = null;
		this.bien3 = null;
		this.dao = null;
	}

	@Test
	public void testGetById() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		// QUAND le proprietaire recupere le bien
		BienImmobilier bienRecupere1 = this.dao.getById("testBatiment").orElseThrow();
		BienImmobilier bienRecupere2 = this.dao.getById("3125789461342").orElseThrow();
		BienImmobilier bienRecupere3 = this.dao.getById("testGarage").orElseThrow();
		
		// ALORS le bien est correctement recupere de la BD.
		assertEquals(bien1, bienRecupere1);
		assertEquals(bien2, bienRecupere2);
		assertEquals(bien3, bienRecupere3);
	}

	@Test
	public void testInsert() {
		// ÉTANT DONNE un nouveau bien à insérer
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new Logement("3134567890123","17 Avenue du Rangueil",
				31200, "Toulouse", dateAnniversaire, 2, 45.5, 3);

		// QUAND j'insere le bien
		this.dao.insert(bien);

		// ALORS le bien est correctement inséré dans la base de données
		BienImmobilier bienRecupere = this.dao.getById("3134567890123").orElseThrow();
		assertEquals(bien, bienRecupere);
    }

	@Test
	public void testUpdate() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		BienImmobilier bien = this.dao.getById("testBatiment").orElseThrow();

		// QUAND je mets a jour les information du bien
		((Batiment) bien).setPeriodeConstruction("3 ans");
		this.dao.update(bien);

		// ALORS le bien a ete mise a jour dans la BD.
		BienImmobilier bienRecupere = this.dao.getById("testBatiment").orElseThrow();
		assertEquals(bien, bienRecupere);
	}

	@Test
	public void testDelete() {
		// ÉTANT DONNE un bien déjà inséré dans la base de données
		// QUAND je supprime ce bien
		this.dao.delete(bien2);

		// ALORS ce bien a bien ete supprime dans la BD.
		assertFalse(this.dao.getById("3125789461342").isPresent());
	}

	@Test
	public void testGetAll() {
		// ETANT DONNE 5 biens existants dans la BD et j'insere 3 biens supplementaires
		// QUAND le proprietaire recupere tous les biens
		List<BienImmobilier> biensRecuperes = this.dao.getAll();
		
		// ALORS tous les biens sont bien recuperes (8 biens au total)
        assertEquals(8, biensRecuperes.size());
	}

}
