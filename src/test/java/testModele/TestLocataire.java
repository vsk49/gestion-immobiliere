package testModele;

import dao.JDBCLocataire;
import modele.Genre;
import modele.Locataire;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestLocataire {

    private Locataire locataireBD;
    private Locataire locataire;

    @Before
    public void setUp() {
        this.locataireBD = new JDBCLocataire().getById("VKOH").orElseThrow();
        this.locataire = new Locataire("IBAL", "Balqis", "Irdyna", Genre.FEMININ,
                LocalDate.of(2004, 1, 10), "Kuching, Sarawak", "Malaisie",
                "Etudiant", "07 82 58 03 88", "dyna.eliana04@gmail.com",
                LocalDate.of(2020, 9, 1),
                LocalDate.of(2021, 8, 31), 1.0);
    }

    @After
    public void tearDown() {
        this.locataireBD = null;
        this.locataire = null;
    }

    @Test
    public void testGetters() {
        assertEquals("VKOH", this.locataireBD.getIdLocataire());
        assertEquals("Koh", this.locataireBD.getNom());
        assertEquals("Virgil Shaun", this.locataireBD.getPrenom());
        assertEquals("M", this.locataireBD.getGenre().getLibelle());
        assertEquals("2004-04-09", this.locataireBD.getDateNaissance().toString());
        assertEquals("Toulouse", this.locataireBD.getLieuNaissance());
        assertEquals("Malaisie", this.locataireBD.getNationalite());
        assertEquals("Etudiant", this.locataireBD.getProfession());
        assertEquals("06 11 16 22 42", this.locataireBD.getTelephone());
        assertEquals("virgilskoh@gmail.com", this.locataireBD.getEmail());
        assertEquals("2024-03-05", this.locataireBD.getDateEntree().toString());
        assertNull(this.locataireBD.getDateDepart());
    }

    @Test
    public void testSetters() {
        this.locataireBD.setIdLocataire("IBAL");
        this.locataireBD.setNom("Balqis");
        this.locataireBD.setPrenom("Irdyna");
        this.locataireBD.setGenre(Genre.FEMININ);
        this.locataireBD.setDateNaissance(LocalDate.of(2004, 1, 10));
        this.locataireBD.setLieuNaissance("Kuching, Sarawak");
        this.locataireBD.setNationalite("Malaisie");
        this.locataireBD.setProfession("Etudiant");
        this.locataireBD.setTelephone("07 82 58 03 88");
        this.locataireBD.setEmail("dyna.eliana04@gmail.com");
        this.locataireBD.setDateEntree(LocalDate.of(2020, 9, 1));
        this.locataireBD.setDateDepart(LocalDate.of(2021, 8, 31));
        assertEquals(this.locataireBD, this.locataire);
    }

}