import modele.JDBCBienImmobilier;
import modele.Batiment;
import modele.Garage;
import modele.Logement;
import modele.BienImmobilier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TestDAOBienImmobilier {

	private JDBCBienImmobilier dao;
	private BienImmobilier bien1;
	private BienImmobilier bien2;
	private BienImmobilier bien3;

	@BeforeEach
	void setUp() {
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

	@AfterEach
	void tearDown() {
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
	@DisplayName("ÉTANT DONNE un bien déjà inséré dans la base de données, " +
				 "QUAND le proprietaire recupere le bien, " +
				 "ALORS le bien est correctement recupere de la BD.")
	void testGetById() {
		BienImmobilier bienRecupere1 = this.dao.getById("testBatiment").orElseThrow();
		BienImmobilier bienRecupere2 = this.dao.getById("3125789461342").orElseThrow();
		BienImmobilier bienRecupere3 = this.dao.getById("testGarage").orElseThrow();
		assertEquals(bien1, bienRecupere1);
		assertEquals(bien2, bienRecupere2);
		assertEquals(bien3, bienRecupere3);
	}

	@Test
	@DisplayName("ÉTANT DONNE un nouveau bien à insérer, " +
				 "QUAND j'insere le bien, " +
				 "ALORS le bien est correctement inséré dans la base de données")
	void testInsert() {
		LocalDate dateAnniversaire = LocalDate.of(2001, 3, 14);
		BienImmobilier bien = new Logement("3134567890123", "17 Avenue du Rangueil",
				31200, "Toulouse", dateAnniversaire, 2, 45.5, 3);
		this.dao.insert(bien);
		BienImmobilier bienRecupere = this.dao.getById("3134567890123").orElseThrow();
		assertEquals(bien, bienRecupere);
	}

	@Test
	@DisplayName("ÉTANT DONNE un bien déjà inséré dans la base de données, " +
				 "QUAND je mets a jour les information du bien, " +
				 "ALORS le bien a ete mise a jour dans la BD.")
	void testUpdate() {
		BienImmobilier bien = this.dao.getById("testBatiment").orElseThrow();
		((Batiment) bien).setPeriodeConstruction("3 ans");
		this.dao.update(bien);
		BienImmobilier bienRecupere = this.dao.getById("testBatiment").orElseThrow();
		assertEquals(bien, bienRecupere);
	}

	@Test
	@DisplayName("ÉTANT DONNE un bien déjà inséré dans la base de données, " +
				 "QUAND je supprime ce bien, " +
				 "ALORS ce bien a bien ete supprime dans la BD.")
	void testDelete() {
		this.dao.delete(bien2);
		assertFalse(this.dao.getById("3125789461342").isPresent());
	}

	@Test
	@DisplayName("ETANT DONNE 5 biens existants dans la BD et j'insere 3 biens supplementaires, " +
				 "QUAND le proprietaire recupere tous les biens, " +
				 "ALORS tous les biens sont bien recuperes (8 biens au total)")
	void testGetAll() {
		List<BienImmobilier> biensRecuperes = this.dao.getAll();
		assertEquals(8, biensRecuperes.size());
	}
}