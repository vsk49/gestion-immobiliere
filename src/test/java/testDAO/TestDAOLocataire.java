package testDAO;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import dao.JDBCConnexion;
import dao.JDBCLocataire;
import modele.Genre;
import modele.Locataire;

public class TestDAOLocataire {

private JDBCLocataire daoLocataire;
	private final Connection connexion = JDBCConnexion.getConnexion();
	private boolean originalAutoCommit;

	@Before
	public void setUp() throws Exception {
		originalAutoCommit = this.connexion.getAutoCommit();
		this.connexion.setAutoCommit(false);
		this.daoLocataire = new JDBCLocataire();
	}

	@After
	public void tearDown() throws Exception {
		this.connexion.rollback();
		connexion.setAutoCommit(originalAutoCommit);
		JDBCConnexion.closeConnexion();
	}


	@Test
	public void testGetById() {
		// ÉTANT DONNE un locataire déjà inséré dans la base de données
        LocalDate dateNaissance = LocalDate.of(2001, 10, 8);
        LocalDate dateEntree = LocalDate.of(2021, 5, 3);
        LocalDate dateDepart = null;

		Locataire Locataire = new Locataire("DJEA", "Durang", "Jean", Genre.MASCULIN, dateNaissance,
            "Toulouse", "Français", "Etudiant", "0606060606",
            "jeandurang@mail.test", dateEntree, dateDepart, 0);
		this.daoLocataire.insert(Locataire);
		
		// QUAND le proprietaire recupere le locataire
		Locataire locataireRecupere = this.daoLocataire.getAll().get(0);
		
		// ALORS le locataire est correctement recupere de la BD.
		assertEquals(Locataire.getNom(), locataireRecupere.getNom());
		assertEquals(Locataire.getPrenom(), locataireRecupere.getPrenom());
		assertEquals(Locataire.getGenre(), locataireRecupere.getGenre());
		assertEquals(Locataire.getDateNaissance().toString(), locataireRecupere.getDateNaissance().toString());
		assertEquals(Locataire.getLieuNaissance(), locataireRecupere.getLieuNaissance());
		assertEquals(Locataire.getNationalite(), locataireRecupere.getNationalite());
		assertEquals(Locataire.getProfession(), locataireRecupere.getProfession());	
        assertEquals(Locataire.getTelephone(), locataireRecupere.getTelephone());	
        assertEquals(Locataire.getEmail(), locataireRecupere.getEmail());	
        assertEquals(Locataire.getDateEntree().toString(), locataireRecupere.getDateEntree().toString());	
        assertEquals(Locataire.getDateDepart(), locataireRecupere.getDateDepart());	
	}


	@Test
	public void testInsert() {
		// ÉTANT DONNE un nouveau locataire à insérer
        LocalDate dateNaissance = LocalDate.of(2001, 10, 8);
        LocalDate dateEntree = LocalDate.of(2021, 5, 3);
        LocalDate dateDepart = null;

		Locataire Locataire = new Locataire("DJEA", "Durang", "Jean", Genre.MASCULIN, dateNaissance,
            "Toulouse", "Français", "Etudiant", "0606060606",
            "jeandurang@mail.test", dateEntree, dateDepart, 0);

		// QUAND j'insere le locataire
		this.daoLocataire.insert(Locataire);

		// ALORS le locataire est correctement inséré dans la base de données
		Locataire locataireRecupere = this.daoLocataire.getAll().get(4);
		assertEquals("Durang", locataireRecupere.getNom());
		assertEquals("Jean", locataireRecupere.getPrenom());
		assertEquals(Genre.MASCULIN, locataireRecupere.getGenre());
		assertEquals(dateNaissance.toString(), locataireRecupere.getDateNaissance().toString());
		assertEquals("Toulouse" ,locataireRecupere.getLieuNaissance());
		assertEquals("Français", locataireRecupere.getNationalite());
        assertEquals("Etudiant", locataireRecupere.getProfession());
        assertEquals("0606060606", locataireRecupere.getTelephone());
        assertEquals("jeandurang@mail.test", locataireRecupere.getEmail());
        assertEquals(dateEntree.toString(), locataireRecupere.getDateEntree().toString());
        assertEquals(dateDepart, locataireRecupere.getDateDepart());
    }


	@Test
	public void testUpdate() {
		// ÉTANT DONNE un locataire déjà inséré dans la base de données
		LocalDate dateNaissance = LocalDate.of(2001, 10, 8);
        LocalDate dateEntree = LocalDate.of(2021, 5, 3);
        LocalDate dateDepart = null;

		Locataire Locataire = new Locataire("DJEA", "Durang", "Jean", Genre.MASCULIN, dateNaissance,
            "Toulouse", "Français", "Etudiant", "0606060606",
            "jeandurang@mail.test", dateEntree, dateDepart, 0);
		this.daoLocataire.insert(Locataire);
		Locataire = this.daoLocataire.getById("DJEA").orElseThrow();

		// QUAND je mets a jour les information du locataire
		Locataire.setEmail("jeanDurang@mail.test");
		this.daoLocataire.update(Locataire);

		// ALORS le locataire a ete mise a jour dans la BD.
		Locataire LocataireRecupere = this.daoLocataire.getById("DJEA").orElseThrow();
		assertEquals("jeanDurang@mail.test", LocataireRecupere.getEmail());
	}


	@Test
	public void testDelete() {
		// ÉTANT DONNE un locataire déjà inséré dans la base de données
		LocalDate dateNaissance = LocalDate.of(2001, 10, 8);
        LocalDate dateEntree = LocalDate.of(2021, 5, 3);
        LocalDate dateDepart = null;

		Locataire Locataire = new Locataire("5", "Durang", "Jean", Genre.MASCULIN, dateNaissance,
            "Toulouse", "Français", "Etudiant", "0606060606",
            "jeandurang@mail.test", dateEntree, dateDepart, 0);
            this.daoLocataire.insert(Locataire);
            Locataire = this.daoLocataire.getAll().get(4);

		// QUAND je supprime ce locataire
		this.daoLocataire.delete(Locataire);

		// ALORS ce locataire a correctement ete supprime dans la BD.
		assertFalse(this.daoLocataire.getById(Locataire.getIdLocataire()).isPresent());
	}


	@Test
	public void testGetAll() {
		// ETANT DONNE 2 locataire existants dans la BD
        LocalDate dateNaissance1 = LocalDate.of(2001, 10, 8);
        LocalDate dateEntree1 = LocalDate.of(2021, 5, 3);
        LocalDate dateDepart1 = null;
		Locataire Locataire1 = new Locataire("5", "Durang", "Jean", Genre.MASCULIN, dateNaissance1,
            "Toulouse", "Français", "Etudiant", "0606060606",
            "jeandurang@mail.test", dateEntree1, dateDepart1, 0);

        LocalDate dateNaissance2 = LocalDate.of(2002, 11, 22);
        LocalDate dateEntree2 = LocalDate.of(2020, 1, 6);
        LocalDate dateDepart2 = null;
        Locataire Locataire2 = new Locataire("6", "Durang", "Jean", Genre.MASCULIN, dateNaissance2,
            "Toulouse", "Français", "Etudiant", "0606060606",
            "jeandurang@mail.test", dateEntree2, dateDepart2, 0);

        this.daoLocataire.insert(Locataire1);
        this.daoLocataire.insert(Locataire2);
		
		// QUAND le proprietaire recupere tous les locataire
		List<Locataire> LocataireRecuperes = this.daoLocataire.getAll();
		
		// ALORS tous les locataire sont bien recuperes
        assertEquals(6, LocataireRecuperes.size());
	}
}
